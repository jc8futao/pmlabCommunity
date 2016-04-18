package com.pmlab.community.common.entity.activity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by mazip on 2016/4/13.
 */
public class Activity {
    // 主键ID
    private long id;
    // 活动名称
    private String activityName;
    // 活动日期
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date activityDate;
    // 活动截止报名时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date enrollEndtime;
    // 活动地点
    private String activityLocation;
    // 活动最大报名人数
    private int activityMaxnum;
    // 活动描述
    private String activityInstruction;
    // 活动图片
    private String activityPic;
    // 活动链接
    private String activityLink;
    // 活动状态
    private byte activityState;
    // 活动创建时间
    private Date createTime;
    // 活动修改时间
    private Date updateTime;
    // 活动创建人
    private long createUser;
    // 活动修改人
    private long updateUser;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    public Date getEnrollEndtime() {
        return enrollEndtime;
    }

    public void setEnrollEndtime(Date enrollEndtime) {
        this.enrollEndtime = enrollEndtime;
    }

    public String getActivityLocation() {
        return activityLocation;
    }

    public void setActivityLocation(String activityLocation) {
        this.activityLocation = activityLocation;
    }

    public int getActivityMaxnum() {
        return activityMaxnum;
    }

    public void setActivityMaxnum(int activityMaxnum) {
        this.activityMaxnum = activityMaxnum;
    }

    public String getActivityInstruction() {
        return activityInstruction;
    }

    public void setActivityInstruction(String activityInstruction) {
        this.activityInstruction = activityInstruction;
    }

    public String getActivityPic() {
        return activityPic;
    }

    public void setActivityPic(String activityPic) {
        this.activityPic = activityPic;
    }

    public String getActivityLink() {
        return activityLink;
    }

    public void setActivityLink(String activityLink) {
        this.activityLink = activityLink;
    }

    public byte getActivityState() {
        return activityState;
    }

    public void setActivityState(byte activityState) {
        this.activityState = activityState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(long createUser) {
        this.createUser = createUser;
    }

    public long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(long updateUser) {
        this.updateUser = updateUser;
    }
}
