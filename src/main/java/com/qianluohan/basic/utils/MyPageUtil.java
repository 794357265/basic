package com.qianluohan.basic.utils;

import com.github.pagehelper.Page;

import java.util.List;

public class MyPageUtil<E>  {
    /**
     * 当前页
     */
    private int pageNum;
    /**
     * 总条数
     */
    private int total;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 页长
     */
    private int pageSize;
    /**
     * 数据
     */
    private List<E> data;

    public MyPageUtil(Page<E> page) {
        this.pageNum = page.getPageNum();
        this.total = page.getEndRow();
        this.totalPage = page.getPages();
        this.pageSize = page.getPageSize();
        this.data = page.getResult();
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
