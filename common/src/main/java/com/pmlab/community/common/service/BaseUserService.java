package com.pmlab.community.common.service;

import com.pmlab.community.common.entity.user.User;
import com.pmlab.community.common.repository.BaseUserMapper;
import com.pmlab.community.common.repository.UserRoleRelationMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * 基础用户 service
 */
@Service
public class BaseUserService {
    @Inject
    private BaseUserMapper baseUserMapper;

    @Inject
    private UserRoleRelationMapper userRoleRelationMapper;

    @Inject
    private PasswordHelper passwordHelper;

    public User save(User user, Boolean ifChangePassword){
        if(ifChangePassword){
            passwordHelper.encryptPassword(user);
        }
        if (user.getId() != null && user.getId() > 0){
            baseUserMapper.updateUser(user);
        }else{
            baseUserMapper.createUser(user);
        }
        return user;
    }

    public void delete(User user){
        baseUserMapper.deleteUser(user.getId());
        userRoleRelationMapper.deleteRelationByUserId(user.getId());
    }

    public User findByUsername(String username) {
        return baseUserMapper.findByUsername(username);
    }

    public User findByEmail(String email) {
        return null;
    }

    public User findByMobilePhoneNumber(String mobilePhoneNumber) {
        //TODO
        return null;
    }

    public User findByOpenId(String openid) {
        //TODO
        return baseUserMapper.findByOpenId(openid);
    }
}
