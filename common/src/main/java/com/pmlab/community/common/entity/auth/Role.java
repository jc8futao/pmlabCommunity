package com.pmlab.community.common.entity.auth;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色 bean
 */
public class Role implements Serializable {
    private static final long serialVersionUID = -1430246236605498441L;
    private Long id; //编号
    private String role; //角色标识 程序中判断使用,如"admin"
    private String description; //角色描述,UI界面显示使用
    private List<Long> permissionIds; //拥有的权限
    private Boolean available = Boolean.FALSE; //是否可用,如果不可用将不会添加给用户

    public Role() {
    }

    public Role(String role, String description, Boolean available) {
        this.role = role;
        this.description = description;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getPermissionIds() {
        if(permissionIds == null) {
            permissionIds = new ArrayList<Long>();
        }
        return permissionIds;
    }

    public void setPermissionIds(List<Long> permissionIds) {
        this.permissionIds = permissionIds;
    }

    public String getPermissionIdsStr() {
        if(CollectionUtils.isEmpty(permissionIds)) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        for(Long permissionId : permissionIds) {
            s.append(permissionId);
            s.append(",");
        }
        return s.toString();
    }

    public void setPermissionIdsStr(String permissionIds) {
        if(StringUtils.isEmpty(permissionIds)) {
            return;
        }
        String[] permissionIdStrs = permissionIds.split(",");
        for(String permissionId : permissionIdStrs) {
            if(StringUtils.isEmpty(permissionId)) {
                continue;
            }
            getPermissionIds().add(Long.valueOf(permissionId));
        }
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", permissionIds=" + permissionIds +
                ", available=" + available +
                '}';
    }
}
