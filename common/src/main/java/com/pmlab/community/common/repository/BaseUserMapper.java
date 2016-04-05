package com.pmlab.community.common.repository;

import com.pmlab.community.common.entity.user.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

/**
 * Created by tfu on 2016/4/4.
 */
@MapperScan
public interface BaseUserMapper {

    @Select("select * from sys_user where username=#{username}")
    public User findByUsername(@Param("username")String username);

    @Select("select * from sys_user where openid=#{openid}")
    public User findByOpenId(@Param("openid")String openid);
}
