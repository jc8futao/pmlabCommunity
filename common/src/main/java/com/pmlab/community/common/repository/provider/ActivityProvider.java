package com.pmlab.community.common.repository.provider;

import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

/**
 * Created by mazip on 2016/4/14.
 * Activity Sql
 */
public class ActivityProvider {


    private static final String TABLE_NAME = "pmlab_activity";


    /**
     * 拼接查询sql
     *
     * @param parameters
     * @return
     */
    public String queryActivitySql(Map<String, Object> parameters) {
        String activityName = (String) parameters.get("activityName");
        byte activityState = (byte) parameters.get("activityState");
        BEGIN();
        SELECT("id, activityName,activityDate,enrollEndtime,activityMaxnum,activityState");
        FROM(TABLE_NAME);
        if (activityName != null && !"".equals(activityName)) {
            WHERE(" activityName like CONCAT('%',#{activityName,javaType=string,jdbcType=VARCHAR},'%')");
        }
        if (activityState >= 0) {
            WHERE(" activityState = #{activityState,javaType=byte,jdbcType=TINYINT}");
        }
        String sql = SQL();
        sql+=" limit #{start},#{pageSize}";
        return sql;
    }

    /**
     * 分页总数
     * @param parameters
     * @return
     */
    public String queryActivitySqlCount(Map<String, Object> parameters) {
        String activityName = (String) parameters.get("activityName");
        byte activityState = (byte) parameters.get("activityState");
        BEGIN();
        SELECT(" count(1) ");
        FROM(TABLE_NAME);
        if (activityName != null && !"".equals(activityName)) {
            WHERE(" activityName like CONCAT('%',#{activityName,javaType=string,jdbcType=VARCHAR},'%')");
        }
        if (activityState >= 0) {
            WHERE(" activityState = #{activityState,javaType=byte,jdbcType=TINYINT}");
        }
        String sql = SQL();
        return sql;
    }


}
