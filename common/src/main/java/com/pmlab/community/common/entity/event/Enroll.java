package com.pmlab.community.common.entity.event;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动报名 bean
 */
public class Enroll implements Serializable{

    private static final long serialVersionUID = 602731604452274947L;
    /**
     * id
     */
    private Long id;
    /**
     * 活动Id
     */
    private Long eventId;

    /**
     * 报名用户Id
     */
    private Long userId;

    /**
     * 用户真实姓名
     */
    private String realName;

    /**
     * 用户手机号码
     */
    private String mobilePhoneNumber;

    /**
     * 公司
     */
    private String company;
    /**
     * 职位
     */
    private String jobTitle;

    /**
     * 报名时间
     */
    private Date enrollTime;

    /**
     * 报名状态:1、报名；2、取消
     */
    private int enrollStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getEnrollTime() {
        return enrollTime;
    }

    public void setEnrollTime(Date enrollTime) {
        this.enrollTime = enrollTime;
    }

    public int getEnrollStatus() {
        return enrollStatus;
    }

    public void setEnrollStatus(int enrollStatus) {
        this.enrollStatus = enrollStatus;
    }
}
