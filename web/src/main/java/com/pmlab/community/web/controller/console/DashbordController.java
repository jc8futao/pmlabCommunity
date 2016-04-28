package com.pmlab.community.web.controller.console;

import com.google.gson.Gson;
import com.pmlab.community.common.entity.activity.Activity;
import com.pmlab.community.common.entity.activity.ActivityVO;
import com.pmlab.community.common.entity.common.Pagenation;
import com.pmlab.community.console.service.ActivityService;
import com.pmlab.community.web.common.ReturnMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by mazip on 2016/4/11.
 */
@Controller
public class DashbordController {

    @Inject
    private ActivityService activityService;

    @Value("${imgurl}")
    private String imgUrl;

    @RequestMapping("/dashbord")
    public String dashbord(){
        return "dashbord";
    }

    /**
     * page
     * @return
     */
    @RequestMapping(value="/activity/list",method= RequestMethod.GET)
    public String activityList(){
        return "activity/activity";
    }

    /**
     * data
     * @param start
     * @param length
     * @return
     */
    @RequestMapping(value="/activity/list",method= RequestMethod.POST)
    public @ResponseBody
    Pagenation<ActivityVO> activityListValue(@RequestParam(defaultValue="0") int start,@RequestParam(defaultValue="10") int length,@RequestParam(defaultValue="") String searchName,@RequestParam(defaultValue="-1") byte state){
        Pagenation<ActivityVO> activitys= activityService.getActivityList(start,length,searchName,state);
        return activitys;
    }

    /**
     * 获取单个活动详情
     * @param id
     * @return
     */
    @RequestMapping(value="/activity/{id}",method= RequestMethod.GET)
    public String singleActivity(@PathVariable("id") long id,Model model){

        Activity activity = activityService.getActivity(id);
        model.addAttribute("activity",activity);
        return "activity/singleActivity";
    }

    /**
     * 上传图片
     * @return
     */
    @RequestMapping(value="/activity/upload",method= RequestMethod.POST,produces = "multipart/form-data;charset=UTF-8")
    public void uploadpic(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="file", required=false)MultipartFile Upload){

        // TODO: 增加文件格式校验
        byte[] bytes = new byte[0];
        try {
            bytes = Upload.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String uploadDir = request.getRealPath("/")+"upload";
        File dirPath = new File(uploadDir);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
        String sep = System.getProperty("file.separator");
        String[] s = Upload.getOriginalFilename().split("\\.");
        String ext="";
        if(s.length>1){
           ext = s[s.length-1];
        }
        String fileName = UUID.randomUUID().toString().replace("-","")+"."+ext;
        File uploadedFile = new File(uploadDir + sep
                + fileName);
        try {
            FileCopyUtils.copy(bytes, uploadedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ReturnMessage rm = new ReturnMessage();
        rm.setCode("200");
        rm.setMessage("success");
        rm.setData(imgUrl+fileName);
        try {
            response.setHeader("Content-type", "application/json;charset=UTF-8");
            PrintWriter pw = response.getWriter();
            Gson g = new Gson();
            pw.write(g.toJson(rm));
            pw.flush();
            pw.close();
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }

    }
    /**
     * 修改单个活动
     * @return
     */
    @RequestMapping(value="/activity/modify/{id}",method= RequestMethod.GET)
    public String modifyActivity(@PathVariable("id") long id,Model model){
        Activity activity = activityService.getActivity(id);
        model.addAttribute("activity",activity);
        return "activity/modifyActivity";
    }

    @RequestMapping(value="/activity/modify",method= RequestMethod.POST)
    public String modifyActivity(@ModelAttribute Activity activity){
        activityService.modifyActivity(activity);
        return "redirect:/activity/list";
    }

    /**
     * 添加活动
     * @param activity
     * @return
     */
    @RequestMapping(value="/activity/add",method= RequestMethod.POST)
    public String addActivity(@ModelAttribute Activity activity){
        activity.setActivityState((byte)0);
        activityService.createActivity(activity);
        return "redirect:/activity/list";
    }


}
