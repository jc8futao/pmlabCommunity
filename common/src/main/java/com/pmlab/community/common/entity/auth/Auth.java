package com.pmlab.community.common.entity.auth;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户权限 bean
 */
public class Auth {
    private Long Id;
    private Long userId = 0L;
    private Set<Long> roleIds;
    private Set<String> permissions;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<Long> getRoleIds() {
        if (roleIds == null) {
            roleIds = new HashSet<>();
        }
        return roleIds;
    }

    public void setRoleIds(Set<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }
}
