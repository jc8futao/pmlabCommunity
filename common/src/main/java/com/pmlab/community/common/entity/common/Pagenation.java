package com.pmlab.community.common.entity.common;

import java.util.List;
import java.util.Map;

/**
 * Created by mazip on 2016/4/14.
 *
 * 分页对象
 */
public class Pagenation<T> {

    private String draw;

    private List<T> data;

    // 总数
    private int recordsTotal;

    private int recordsFiltered;
    // 当前第几页
    private int page;
   // 每页多少条
    private int pageSize;

    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
