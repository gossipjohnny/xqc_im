package com.bonade.xxp.xqc_android_im.DB.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public class LoginSp {

    private final String fileName = "login.ini";
    private Context context;
    private final String KEY_LOGIN_NAME = "loginName";
    private final String KEY_PWD = "pwd";
    private final String KEY_LOGIN_ID = "loginId";

    SharedPreferences sharedPreferences;

    private static LoginSp loginSp = null;
    public static LoginSp getInstance(){
        if (loginSp == null) {
            synchronized (LoginSp.class){
                loginSp = new LoginSp();
            }
        }
        return loginSp;
    }
    private LoginSp(){}

    public void init(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences
                (fileName, context.MODE_PRIVATE);
    }

    public void setLoginInfo(int loginId){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_LOGIN_ID, loginId);
        editor.commit();
    }

    public SpLoginIdentity getLoginIdentity(){
//        String userName =  sharedPreferences.getString(KEY_LOGIN_NAME,null);
//        String pwd = sharedPreferences.getString(KEY_PWD,null);
        int loginId = sharedPreferences.getInt(KEY_LOGIN_ID,0);
//         pwd不判空: loginOut的时候会将pwd清空
//        if(TextUtils.isEmpty(userName) || loginId == 0){
//            return null;
//        }
        if (loginId == 0) {
            return null;
        }
//        return new SpLoginIdentity(userName, pwd, loginId);
        return new SpLoginIdentity(loginId);
    }

    public class SpLoginIdentity {
//        private String loginName;
//        private String pwd;
        private long loginId;

//        public SpLoginIdentity(String loginName, String pwd, int loginId){
//            this.loginName = loginName;
//            this.pwd = pwd;
//            this.loginId = loginId;
//        }

        public SpLoginIdentity(long loginId){
            this.loginId = loginId;
        }

        public long getLoginId() {
            return loginId;
        }

        public void setLoginId(int loginId) {
            this.loginId = loginId;
        }

//        public String getLoginName() {
//            return loginName;
//        }
//
//        public String getPwd() {
//            return pwd;
//        }
    }

}