package com.pmlab.community.console.service;


import com.pmlab.community.common.entity.activity.Activity;
import com.pmlab.community.common.entity.activity.ActivityVO;
import com.pmlab.community.common.entity.common.Pagenation;
import com.pmlab.community.common.repository.ActivityMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by mazip on 2016/4/13.
 */
@Service
public class ActivityService {

    @Inject
    private ActivityMapper activityMapper;

    /**
     * 添加活动
     * @param activity
     * @return
     */
    public boolean createActivity(Activity activity){

        int i = activityMapper.insertActivity(activity);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 分页查询活动
     * @param start
     * @param pageSize
     * @param activeName
     * @param activeState
     * @return
     */
    public Pagenation<ActivityVO> getActivityList(int start, int pageSize, String activeName, byte activeState){

        List<ActivityVO> vo = activityMapper.getActivityList(start,pageSize,activeName,activeState);
        int total = activityMapper.getActivityListCount(activeName,activeState);
        Pagenation<ActivityVO> pagenation = new Pagenation<ActivityVO>();
        pagenation.setData(vo);
        pagenation.setRecordsTotal(total);
        pagenation.setRecordsFiltered(total);
        return pagenation;
    }


    /**
     * 获取单个活动信息
     * @param id
     * @return
     */
    public Activity getActivity(long id){
        return activityMapper.getSingleActivity(id);
    }

    public int modifyActivity(Activity activity){

        return activityMapper.modifyActivity(activity);
    }

}
