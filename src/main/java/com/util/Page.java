package com.util;

/**
 * @Author 南昌航空大学 18045221-李扬
 * @Date 2020/12/29 18:52
 * @Version 1.0
 */

import lombok.Setter;

import java.io.Serializable;

/**
 * 分页工具类
 */

@Setter
public class Page implements Serializable {

    private static final long serialVersionUID = 1L;

    private int pageNow = 1; // 当前页数

    private int pageSize = 4; // 每页显示记录的条数

    private int totalCount; // 总的记录条数

    private int totalPageCount; // 总的页数

    @SuppressWarnings("unused")
    private int startPos; // 开始位置，从0开始

    @SuppressWarnings("unused")
    private boolean hasFirst;// 是否有首页

    @SuppressWarnings("unused")
    private boolean hasPre;// 是否有前一页

    @SuppressWarnings("unused")
    private boolean hasNext;// 是否有下一页

    @SuppressWarnings("unused")
    private boolean hasLast;// 是否有最后一页

    /**
     * 通过构造函数 传入  总记录数  和  当前页
     * @param totalCount 总记录数
     * @param pageNow 当前页
     */
    public Page(int totalCount, int pageNow) {
        this.totalCount = totalCount;
        this.pageNow = pageNow;
    }

    /**
     * 取得总页数，总页数=总记录数/总页数
     * @return 总页数
     */
    public int getTotalPageCount() {
        totalPageCount = getTotalCount() / getPageSize();
        return (totalCount % pageSize == 0) ? totalPageCount
                : totalPageCount + 1;
    }

    public int getPageNow() {
        return pageNow;
    }


    public int getPageSize() {
        return pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    /**
     * 取得选择记录的初始位置
     * @return
     */
    public int getStartPos() {
        return (pageNow - 1) * pageSize;
    }


    /**
     * 是否是第一页
     * @return
     */
    public boolean isHasFirst() {
        return (pageNow == 1) ? false : true;
    }

    /**
     * 是否有首页
     * @return
     */
    public boolean isHasPre() {
        // 如果有首页就有前一页，因为有首页就不是第一页
        return isHasFirst() ? true : false;
    }

    /**
     * 是否有下一页
     * @return
     */
    public boolean isHasNext() {
        // 如果有尾页就有下一页，因为有尾页表明不是最后一页
        return isHasLast() ? true : false;
    }

    /**
     * 是否有尾页
     * @return
     */
    public boolean isHasLast() {
        // 如果不是最后一页就有尾页
        return (pageNow == getTotalCount()) ? false : true;
    }

}
