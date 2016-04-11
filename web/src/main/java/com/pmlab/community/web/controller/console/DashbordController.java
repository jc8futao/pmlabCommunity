package com.pmlab.community.web.controller.console;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mazip on 2016/4/11.
 */
@Controller
public class DashbordController {

    @RequestMapping("/dashbord")
    public String dashbord(){

        return "dashbord";
    }

}
