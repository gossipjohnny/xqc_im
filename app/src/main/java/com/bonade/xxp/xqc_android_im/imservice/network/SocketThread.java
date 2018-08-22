package com.bonade.xxp.xqc_android_im.imservice.network;

import android.provider.ContactsContract;

import com.bonade.xxp.xqc_android_im.config.SysConstant;
import com.bonade.xxp.xqc_android_im.protobuf.base.DataBuffer;
import com.bonade.xxp.xqc_android_im.protobuf.base.Header;
import com.bonade.xxp.xqc_android_im.util.Logger;
import com.google.protobuf.GeneratedMessageLite;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.frame.LengthFieldBasedFrameDecoder;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class SocketThread extends Thread {

    private ClientBootstrap clientBootstrap = null;
    private ChannelFactory channelFactory = null;
    private ChannelFuture channelFuture = null;
    private Channel channel = null;
    private String strHost = null;
    private int nPort = 0;
    private static Logger logger = Logger.getLogger(SocketThread.class);

    public SocketThread(String strHost, int nPort, SimpleChannelHandler handler) {
        this.strHost = strHost;
        this.nPort = nPort;
        init(handler);
    }

    @Override
    public void run() {
        doConnect();
    }

    private void init(final SimpleChannelHandler handler) {
        // only one IO thread
        channelFactory = new NioClientSocketChannelFactory(Executors.newSingleThreadExecutor(), Executors.newSingleThreadExecutor());

        clientBootstrap = new ClientBootstrap(channelFactory);
        clientBootstrap.setOption("connectTimeoutMillis", 5000);
        clientBootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
                // 接收的数据包解码
                pipeline.addLast("decoder", new LengthFieldBasedFrameDecoder(
                        400 * 1024, 0, 4, -4, 0
                ));
                // 发送的数据包编码
                //pipeline.addLast("encoder", new PacketEncoder());
                // 具体的业务处理，这个handler只负责接收数据，并传递给dispatcher
                pipeline.addLast("handler", handler);
                return pipeline;
            }
        });

        clientBootstrap.setOption("tcpNoDelay", true);
        clientBootstrap.setOption("keepAlive", true);
        // clientBootstrap.setOption("keepIdle", 20);
        // clientBootstrap.setOption("keepInterval", 5);
        // clientBootstrap.setOption("keepCount", 3);
    }

    private boolean doConnect() {
        try {
            if ((null == channel || (null != channel && !channel.isConnected()))
                    && null != this.strHost && this.nPort > 0) {
                // 启动连接尝试
                channelFuture = clientBootstrap.connect(new InetSocketAddress(strHost, nPort));
                // 等待连接尝试成功或失败
                channel = channelFuture.awaitUninterruptibly().getChannel();
                if (!channelFuture.isSuccess()) {
                    channelFuture.getCause().printStackTrace();
                    clientBootstrap.releaseExternalResources();
                    // ReconnectManager.getInstance().setOnRecconnecting(false);
                    // ReconnectManager.getInstance().setLogining(false);
                    return false;
                }
            }

            // 等待连接关闭或连接尝试
            // 失败
            channelFuture.getChannel().getCloseFuture().awaitUninterruptibly();
            // 关闭线程池、退出
            clientBootstrap.releaseExternalResources();
            return true;
        } catch (Exception e) {
            logger.e("do connect failed. e: %s", e.getStackTrace().toString());
            return false;
        }
    }

    public Channel getChannel() {
        return channel;
    }

    public void close() {
        if (null == channelFuture)
            return;
        if (null != channelFuture.getChannel()) {
            channelFuture.getChannel().close();
        }
        channelFuture.cancel();
    }

    // todo check
    @Deprecated
    public boolean isClose() {
        if (channelFuture != null && channelFuture.getChannel() != null) {
            return !channelFuture.getChannel().isConnected();
        }
        return true;
    }

    /**
     *
     * @param requset
     * @param header
     */
    public boolean sendRequest(GeneratedMessageLite requset, Header header) {
        DataBuffer headerBuffer = header.encode();
        DataBuffer bodyBuffer = new DataBuffer();
        int bodySize = requset.getSerializedSize();
        bodyBuffer.writeBytes(requset.toByteArray());

        DataBuffer buffer = new DataBuffer(SysConstant.PROTOCOL_HEADER_LENGTH + bodySize);
        buffer.writeDataBuffer(headerBuffer);
        buffer.writeDataBuffer(bodyBuffer);

        if (null != buffer && null != channelFuture.getChannel()) {
            // 底层的状态要提前判断，netty抛出的异常上层catch不到
            Channel currentChannel = channelFuture.getChannel();
            boolean isW = currentChannel.isWritable();
            boolean isC = currentChannel.isConnected();
            if(!(isW && isC)){
                throw  new RuntimeException("#sendRequest#channel is close!");
            }
            channelFuture.getChannel().write(buffer.getOrignalBuffer());
            logger.d("packet#send ok");
            return true;
        } else {
            logger.e("packet#send failed");
            return false;
        }
    }
}
