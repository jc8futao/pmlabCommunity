package com.pmlab.community.common.repository;

import com.pmlab.community.common.entity.auth.Role;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;
import java.util.Set;

/**
 * Created by tfu on 2016/4/6.
 */
@MapperScan
public interface RoleMapper {
    @Insert("INSERT INTO sys_role VALUES(#{role}, #{name}, #{description}, #{buildIn}, #{show})")
    public Role createRole(Role role);

    @Update("UPDATE sys_role SET " +
            " role = #{role}, " +
            " role = #{name}, " +
            " role = #{description}, " +
            " role = #{buildIn}, " +
            " role = #{show} " +
            " WHERE id = #{id}")
    public Role updateRole(Role role);

    @Delete("DELETE FROM sys_role WHERE id = #{roleId}")
    public void deleteRole(@Param("roleId") Long roleId);

    @Select("SELECT * FROM role WHERE name = #{name}")
    public Role findOneByName(@Param("name") String name);

    @Select("SELECT * FROM role WHERE id = #{id}")
    public Role findOneById(@Param("name") Long id);

    @Select("SELECT * FROM role WHERE role = #{role}")
    public Role findOneByRole(@Param("role") String role);

    @Select("SELECT * FROM role")
    public List<Role> findAll();
}
