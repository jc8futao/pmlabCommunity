package com.pmlab.community.common.service;

import com.pmlab.community.common.entity.user.User;
import com.pmlab.community.common.repository.BaseUserMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * 基础用户 service
 */
@Service
public class BaseUserService {
    @Inject
    private BaseUserMapper baseUserMapper;

    public User createUser(User user){
        return null;
    }

    public User updateUser(User user){
        return null;
    }

    public User bindUser(User user, String openId){
        return null;
    }

    public User changePassword(User user, String newPassword){
        //TODO
        return null;
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
