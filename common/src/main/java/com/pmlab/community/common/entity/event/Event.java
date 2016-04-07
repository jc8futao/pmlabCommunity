package com.pmlab.community.common.entity.event;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动 bean
 */
public class Event implements Serializable{
    private static final long serialVersionUID = -4905342162006126888L;
    /**
     * id
     */
    private Long id;

    /**
     * 活动创建人
     */
    private Long creatorId;

    /**
     * 活动状态
     */
    private int status;
    /**
     * 活动名称
     */
    private String title;

    /**
     * 封面连接
     */
    private String coverUrl;

    /**
     * 活动正文
     */
    private String content;

    /**
     * 报名人数限制：0表示无限制
     */
    private int limited;

    /**
     * 报名人数
     */
    private int enrollNum;

    /**
     * 活动目标人群，与user中的jobType一致；0表示all
     */
    private int target = 0;

    /**
     * 活动场地
     */
    private String address;

    /**
     * 是否公布
     */
    private Boolean published;

    /**
     * 公布时间
     */
    public Date publishTime;

    /**
     * 报名截止时间
     */
    public Date closingTime;

    /**
     * 活动开始时间
     */
    public Date startTime;
    /**
     * 结束时间
     */
    public Date finishDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLimited() {
        return limited;
    }

    public void setLimited(int limited) {
        this.limited = limited;
    }

    public int getEnrollNum() {
        return enrollNum;
    }

    public void setEnrollNum(int enrollNum) {
        this.enrollNum = enrollNum;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Date closingTime) {
        this.closingTime = closingTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
}
