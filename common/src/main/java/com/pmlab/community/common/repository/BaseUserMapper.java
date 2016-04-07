package com.pmlab.community.common.repository;

import com.pmlab.community.common.entity.user.User;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created by tfu on 2016/4/4.
 */
@MapperScan
public interface BaseUserMapper {

    @Insert("INSERT INTO sys_user(openid, username, realName, mobilePhoneNumber, email, password, salt, createDate, createSources, companyName, jobTitle, jobType, jobDescription, admin, locked, description) " +
            " VALUES(#{openid}, #{username}, #{realName}, #{mobilePhoneNumber}, #{email}, #{password}, #{salt}, #{createDate}, #{createSources}, #{companyName}, #{jobTitle}, #{jobType}, #{jobDescription}, #{admin}, #{locked}, #{description} )")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public User createUser(User user);

    @Insert("UPDATE sys_user SET " +
            "openid = #{openid}," +
            "username = #{username}," +
            "realName = #{realName}," +
            "mobilePhoneNumber = #{mobilePhoneNumber}," +
            "email = #{email}," +
            "password = #{password}," +
            "salt = #{salt}," +
            "createDate = #{createDate}," +
            "createSources = #{createSources}," +
            "companyName = #{companyName}," +
            "jobTitle = #{jobTitle}," +
            "jobType = #{jobType}," +
            "jobDescription = #{jobDescription}," +
            "admin = #{admin}," +
            "locked = #{locked}," +
            "description = #{description}," +
            "WHERE id=#{id}")
    public User updateUser(User user);

    @Select("SELECT * FROM sys_user WHERE username=#{username}")
    public User findByUsername(@Param("username")String username);

    @Select("SELECT * FROM sys_user WHERE openid=#{openid}")
    public User findByOpenId(@Param("openid")String openid);

    @Delete("DELETE FROM sys_user WHERE id=#{id}")
    public void deleteUser(Long userId);
}
