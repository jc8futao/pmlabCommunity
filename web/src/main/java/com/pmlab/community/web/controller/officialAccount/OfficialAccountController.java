package com.pmlab.community.web.controller.officialAccount;

import com.pmlab.community.common.entity.user.User;
import com.pmlab.community.web.bind.annotation.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 公众号 Controller
 */
@Controller
@RequestMapping("/officialAccount")
public class OfficialAccountController {

    @RequestMapping("/events")
    public String getEvents(){
        return "officialAccount/event";
    }

    @RequestMapping("/enrolls")
    public String getEnrolls(@CurrentUser User currentUser, Model model){
        model.addAttribute("currentUser", currentUser);
        return "officialAccount/enroll";
    }

    @RequestMapping("/register")
    public String getRegister(){
        return "officialAccount/register";
    }
}
