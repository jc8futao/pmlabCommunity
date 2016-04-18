package com.pmlab.community.common.repository;

import com.pmlab.community.common.entity.activity.Activity;
import com.pmlab.community.common.entity.activity.ActivityVO;
import com.pmlab.community.common.repository.provider.ActivityProvider;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * Created by mazip on 2016/4/13.
 *
 * 活动相关Mapper
 */
@MapperScan
public interface ActivityMapper {

    /**
     * 添加活动
     * @param activity
     * @return
     */
    @Insert("INSERT INTO activity(activityName,activityDate,enrollEndtime,activityLocation,activityMaxnum,activityInstruction,activityPic,activityLink,activityState,createTime,updateTime,createUser,updateUser) " +
            " VALUES(#{activityName}, #{activityDate}, #{enrollEndtime}, #{activityLocation}, #{activityMaxnum}, #{activityInstruction}, #{activityPic}, #{activityLink}, #{activityState}, now(), now(), #{createUser}, #{updateUser} )")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public int insertActivity(Activity activity);


    @SelectProvider(type = ActivityProvider.class, method = "queryActivitySql")
    public List<ActivityVO> getActivityList(@Param("start")int start,@Param("pageSize")int pageSize,@Param("activityName")String activityName,@Param("activityState")byte activityState);

    @SelectProvider(type = ActivityProvider.class, method = "queryActivitySqlCount")
    public int getActivityListCount(@Param("activityName")String activityName,@Param("activityState")byte activityState);

    @Select("select id\n," +
            "activityName\n," +
            "activityDate\n," +
            "enrollEndtime\n," +
            "activityLocation\n," +
            "activityMaxnum\n," +
            "activityInstruction\n," +
            "activityPic\n," +
            "activityLink\n," +
            "activityState\n" +
             " from activity where id = #{id}")
    public Activity getSingleActivity(long id);


    @Update("update activity set activityName=#{activityName},activityDate=#{activityDate},enrollEndtime=#{enrollEndtime},activityLocation=#{activityLocation},activityMaxnum=#{activityMaxnum},activityInstruction=#{activityInstruction},activityPic=#{activityPic},activityLink=#{activityLink},updateTime=now() where id = #{id}")
    public int modifyActivity(Activity activity);
}
