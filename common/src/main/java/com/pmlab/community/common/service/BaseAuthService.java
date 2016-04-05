package com.pmlab.community.common.service;

import com.pmlab.community.common.entity.auth.Role;
import com.pmlab.community.common.entity.auth.Auth;
import com.pmlab.community.common.entity.user.User;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by tfu on 2016/4/4.
 */
@Service
public class BaseAuthService {
    public void addUserAuth(Auth m){
        //TODO
    }

    public void updateUserAuth(Auth m){
        //TODO
    }

    public void deleteUserAuth(Auth m){
        //TODO
    }

    public Set<Role> findRoles(User user){
        //TODO
        return null;
    }

    public Set<String> findStringRoles(User user){
        //TODO
        return null;
    }

    public Set<String> findStringPermissions(User user){
        return null;
    }
}
