package com.pmlab.community.common.entity.user;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息bean
 */
public class User implements Serializable{
    private static final long serialVersionUID = -5486176020776838114L;
    /**
     * 用户的UUID
     */
    private Long id;
    /**
     * 用户的微信openid
     */
    private String openid;
    /**
     * 用户名 (登录使用)
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 用户手机号码
     */
    private String mobilePhoneNumber;
    /**
     * 用户 email
     */
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     * 加密密码的盐
     */
    private String salt;

    /**
     * 创建日期
     */
    private Date createDate;

    /**
     * 创建来源：1、微信公众号；2、平台注册；3、管理员添加；
     */
    private int createSources = 1;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 工作职位
     */
    private String jobTitle;

    /**
     * 工作类型：1、产品；2、开发；3、设计；4、运营；5、市场；6、媒体；7、BD
     */
    private int jobType;

    /**
     * 工作描述
     */
    private String jobDescription;

    /**
     * 是否是管理员
     */
    private Boolean admin = false;

    /**
     * 是否为锁定用户
     */
    private Boolean locked = Boolean.FALSE;

    /**
     * 个人描述
     */
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getCreateSources() {
        return createSources;
    }

    public void setCreateSources(int createSources) {
        this.createSources = createSources;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getJobType() {
        return jobType;
    }

    public void setJobType(int jobType) {
        this.jobType = jobType;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCredentialsSalt(){
        return username + salt;
    }
}
