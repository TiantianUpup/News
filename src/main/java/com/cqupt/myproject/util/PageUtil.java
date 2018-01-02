package com.cqupt.myproject.util;

import java.util.List;

/**
 * 分页工具,对分页信息进行了一个封装
 * @author hetiantian
 * @version 2017/11/12.
 */
public class PageUtil<T> {
    private Integer currPage;//当前页数
    private Integer pageSize;//当前页数
    private Integer totalCount;//总记录数
    private Integer totalPage;//总页数
    private List<T> lists;//每页的显示数据

    public PageUtil() {

    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }
}
