package com.qianluohan.basic.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
/**
* @author zhangyibing  qianluohan.com
* @Date 2020/6/9
* @desription
**/
public class MyPageUtil<E>  {
    /**
     * 当前页
     */
    private long pageNum;
    /**
     * 总条数
     */
    private long total;
    /**
     * 总页数
     */
    private long totalPage;
    /**
     * 页长
     */
    private long pageSize;
    /**
     * 数据
     */
    private List<E> data;

    public MyPageUtil(Page<E> page) {
        this.pageNum = page.getCurrent();
        this.total = page.getTotal();
        this.totalPage = page.getPages();
        this.pageSize = page.getSize();
        this.data = page.getRecords();
    }

    public long getPageNum() {
        return pageNum;
    }

    public void setPageNum(long pageNum) {
        this.pageNum = pageNum;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "MyPageUtil{" +
                "pageNum=" + pageNum +
                ", total=" + total +
                ", totalPage=" + totalPage +
                ", pageSize=" + pageSize +
                ", data=" + data +
                '}';
    }
}
