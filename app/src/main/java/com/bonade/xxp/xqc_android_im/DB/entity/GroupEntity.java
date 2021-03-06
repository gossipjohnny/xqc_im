package com.bonade.xxp.xqc_android_im.DB.entity;

import android.text.TextUtils;

import com.bonade.xxp.xqc_android_im.config.DBConstant;
import com.bonade.xxp.xqc_android_im.imservice.entity.SearchElement;
import com.bonade.xxp.xqc_android_im.util.pinyin.PinYin;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "GroupInfo".
 */
public class GroupEntity extends PeerEntity {

    private Integer groupType;
    @SerializedName("groupOwnerId")
    private Integer creatorId;
    @SerializedName("groupCounts")
    private Integer userCount;
    @SerializedName("groupUserIds")
    private String userIds;
    private Integer version;

    // KEEP FIELDS - put your custom fields here
    private PinYin.PinYinElement pinyinElement = new PinYin.PinYinElement();
    private SearchElement searchElement = new SearchElement();
    // KEEP FIELDS END

    public GroupEntity() {
    }

    public GroupEntity(Long cid) {
        this.cid = cid;
    }

    public GroupEntity(Long cid, int peerId, Integer groupType, String mainName, String avatar, Integer creatorId, Integer userCount, String userIds, Integer version, Integer status, Integer created, Integer updated) {
        this.cid = cid;
        this.peerId = peerId;
        this.groupType = groupType;
        this.mainName = mainName;
        this.avatar = avatar;
        this.creatorId = creatorId;
        this.userCount = userCount;
        this.userIds = userIds;
        this.version = version;
        this.status = status;
        this.created = created;
        this.updated = updated;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public int getPeerId() {
        return peerId;
    }

    public void setPeerId(int peerId) {
        this.peerId = peerId;
    }

    public Integer getGroupType() {
        return groupType;
    }

    public void setGroupType(Integer groupType) {
        this.groupType = groupType;
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public int getUpdated() {
        return updated;
    }

    public void setUpdated(int updated) {
        this.updated = updated;
    }

    // KEEP METHODS - put your custom methods here

    /**
     * 获取群组成员Id的list
     * -- userIds 前后去空格，按照逗号区分， 不检测空的成员(非法)
     *
     * @return
     */
    public Set<Integer> getGroupMemberIds() {
        if (TextUtils.isEmpty(userIds)) {
            return Collections.emptySet();
        }

        String[] arrayUserIds = userIds.trim().split(",");
        if (arrayUserIds.length <= 0) {
            return Collections.emptySet();
        }

        Set<Integer> result = new TreeSet<>();
        for (int i = 0; i < arrayUserIds.length; i++) {
            int userId = Integer.parseInt(arrayUserIds[i]);
            result.add(userId);
        }
        return result;
    }

    /**
     * todo 入参变为 set【自动去重】
     * 每次都要转换 性能不是太好，todo
     *
     * @param memberIds
     */
    public void setGroupMemberIds(List<Integer> memberIds) {
        String userList = TextUtils.join(",", memberIds);
        setUserIds(userList);
    }

    public PinYin.PinYinElement getPinyinElement() {
        return pinyinElement;
    }

    public void setPinyinElement(PinYin.PinYinElement pinyinElement) {
        this.pinyinElement = pinyinElement;
    }

    public SearchElement getSearchElement() {
        return searchElement;
    }

    public void setSearchElement(SearchElement searchElement) {
        this.searchElement = searchElement;
    }

    @Override
    public int getType() {
        return DBConstant.SESSION_TYPE_GROUP;
    }
    // KEEP METHODS END

}
