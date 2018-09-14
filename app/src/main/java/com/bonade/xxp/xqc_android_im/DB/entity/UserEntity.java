package com.bonade.xxp.xqc_android_im.DB.entity;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here

import android.text.TextUtils;

import com.bonade.xxp.xqc_android_im.config.DBConstant;
import com.bonade.xxp.xqc_android_im.imservice.entity.SearchElement;
import com.bonade.xxp.xqc_android_im.util.pinyin.PinYin;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.NotNull;

import java.io.Serializable;
// KEEP INCLUDES END

/**
 * Entity mapped to table "UserInfo".
 */
public class UserEntity extends PeerEntity {

    private Integer companyId;
    private String companyName;
    private String jobName;
    private String deptName;
    private String mobile;
    private Integer isFriend;
    private String email;
    private String userName;

    // KEEP FIELDS - put your custom fields here
    private PinYin.PinYinElement pinyinElement = new PinYin.PinYinElement();
    private SearchElement searchElement = new SearchElement();
    // KEEP FIELDS END

    @Generated
    public UserEntity() {
    }

    public UserEntity(Long cid) {
        this.cid = cid;
    }

    @Generated
    public UserEntity(Long cid, int peerId, String mainName, String avatar, Integer companyId, String companyName, String jobName, String deptName, String mobile, Integer isFriend, String email, String userName, Integer status, Integer created, Integer updated) {
        this.cid = cid;
        this.peerId = peerId;
        this.mainName = mainName;
        this.avatar = avatar;
        this.companyId = companyId;
        this.companyName = companyName;
        this.jobName = jobName;
        this.deptName = deptName;
        this.mobile = mobile;
        this.isFriend = isFriend;
        this.email = email;
        this.userName = userName;
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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getIsFriend() {
        return isFriend;
    }

    public void setIsFriend(Integer isFriend) {
        this.isFriend = isFriend;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
    public boolean isFriend() {
        return isFriend == 1;
    }

    public PinYin.PinYinElement getPinyinElement() {
        return pinyinElement;
    }


    public SearchElement getSearchElement() {
        return searchElement;
    }

    @Override
    public int getType() {
        return DBConstant.SESSION_TYPE_SINGLE;
    }
    // KEEP METHODS END

}
