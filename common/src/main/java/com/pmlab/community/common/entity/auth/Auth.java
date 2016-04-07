package com.pmlab.community.common.entity.auth;

import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户权限 bean
 */
public class Auth {
    private Long id;
    private Long userId = 0L;
    private Set<Role> roles;
    private Set<Permission> permissions;

    private Set<String> roleStrings;
    private Set<String> permissionStrings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        if(roleStrings == null) {
            roleStrings = new HashSet<String>();
        }
        if(!CollectionUtils.isEmpty(roles)){
            for(Role role : roles){
                roleStrings.add(role.getRole());
            }
        }
        this.roles = roles;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        if(permissionStrings == null){
            permissionStrings = new HashSet<String>();
        }
        if(!CollectionUtils.isEmpty(permissions)){
            for(Permission permission : permissions){
                permissionStrings.add(permission.getName());
            }
        }
        this.permissions = permissions;
    }

    public Set<String> getPermissionStrings() {
        return permissionStrings;
    }

    public Set<String> getRoleStrings() {
        return roleStrings;
    }
}
