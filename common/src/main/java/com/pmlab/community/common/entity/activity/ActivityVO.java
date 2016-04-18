package com.pmlab.community.common.entity.activity;

import java.util.Date;

/**
 * Created by mazip on 2016/4/13.
 * 前台展示用 带分页
 */
public class ActivityVO {

    // 主键ID
    private long id;
    // 活动名称
    private String activityName;
    // 活动日期
    private Date activityDate;
    // 活动截止报名时间
    private Date enrollEndtime;
    // 活动最大报名人数
    private int activityMaxnum;
    // 活动状态
    private byte activityState;
    // 活动已报名人数
    private int activityEnrollnum;

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

    public int getActivityMaxnum() {
        return activityMaxnum;
    }

    public void setActivityMaxnum(int activityMaxnum) {
        this.activityMaxnum = activityMaxnum;
    }

    public byte getActivityState() {
        return activityState;
    }

    public void setActivityState(byte activityState) {
        this.activityState = activityState;
    }

    public int getActivityEnrollnum() {
        return activityEnrollnum;
    }

    public void setActivityEnrollnum(int activityEnrollnum) {
        this.activityEnrollnum = activityEnrollnum;
    }
}
