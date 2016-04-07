package com.pmlab.community.common.repository;

import com.pmlab.community.common.entity.auth.Role;
import com.pmlab.community.common.entity.auth.UserRoleRelation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import java.util.Set;

/**
 * 用户角色关系 mapper
 */
@MapperScan
public interface UserRoleRelationMapper {
    @Insert("INSERT INTO sys_user_role_relation VALUES(#{userId}, #{roleId})")
    public UserRoleRelation save(UserRoleRelation userRoleRelation);

    @Delete("DELETE FORM sys_user_role_relation WHERE userId = #{userId}")
    public void deleteRelationByUserId(@Param("userId") Long userId);

    @Select("SELECT * FROM sys_role WHERE id IN (SELECT roleId FROM sys_user_role_relation WHERE userId = #{userId})")
    public Set<Role> getRolesOfUser(@Param("userId") Long userId);
}
