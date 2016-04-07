package com.pmlab.community.common.service;

import com.pmlab.community.common.entity.auth.Permission;
import com.pmlab.community.common.entity.auth.Role;
import com.pmlab.community.common.entity.auth.Auth;
import com.pmlab.community.common.entity.auth.UserRoleRelation;
import com.pmlab.community.common.entity.user.User;
import com.pmlab.community.common.repository.RolePermissionRelationMapper;
import com.pmlab.community.common.repository.UserRoleRelationMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * authService
 */
@Service
public class BaseAuthService {
    @Inject
    private UserRoleRelationMapper userRoleRelationMapper;

//    @Inject
//    private RolePermissionRelationMapper rolePermissionRelation;

    public void save(Auth m){
        //
        Long userId = m.getUserId();
        userRoleRelationMapper.deleteRelationByUserId(userId);

        Set<Role> roles = m.getRoles();
        for(Role role : roles){
            userRoleRelationMapper.save(new UserRoleRelation(m.getUserId(), role.getId()));
        }

        //permission 暂时不实现
    }

    public void delete(Auth m){
        Long userId = m.getUserId();
        userRoleRelationMapper.deleteRelationByUserId(userId);
    }

    public Auth getAuthOfUser(User user){
        Long userId = user.getId();
        Set<Role> userRoles = userRoleRelationMapper.getRolesOfUser(userId);

        Auth m = new Auth();
        m.setUserId(userId);
        m.setRoles(userRoles);

        //permission 部分暂不实现
        return m;
    }
}
