package com.pmlab.community.web.controller.console;

import com.pmlab.community.common.entity.user.User;
import com.pmlab.community.web.bind.annotation.CurrentUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tfu on 2016/3/24.
 */
@Controller
public class RootController {
    @RequestMapping("/")
    public String getWelcome(){
        return "dashbord";
    }

    @RequestMapping("/login")
    public String getLogin(HttpServletRequest req, Model model){
        String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(AuthenticationException.class.getName().equals(exceptionClassName)){
            error = "用户名/密码错误";
        }else if(LockedAccountException.class.getName().equals(exceptionClassName)){
            error = "用户名锁定";
        }else if(exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        model.addAttribute("error", error);
        return "login";
    }

    @RequestMapping("/user")
    public String template(@CurrentUser User currentUser, Model model){
        model.addAttribute("currentUser", currentUser);
        return "user";
    }

    @RequestMapping("/register")
    public String getRegister(){
        return "register";
    }

    @RequestMapping("/oauth2Failure")
    public String getOauth2FailureView(){
        return "/oauth/failure";
    }

    @RequestMapping("/message")
    public @ResponseBody ResponseEntity<String> onMessage(@RequestParam("echostr") String echostr){
        return new ResponseEntity(echostr ,HttpStatus.OK);
    }
}
