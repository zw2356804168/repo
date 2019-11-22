package com.hwua.enpity;

import java.util.List;

/**
 * 分页实体类,这个对象中封装了一页所对应的相关数据
 */
public class PageEntity {
    private Long totalRecords;//总记录数,从数据库进行查询
    private Integer totalPages;//总页数
    private Integer pageSize;//每页显式的记录数,从外面传进来
    private Integer pageNo;//当前页码数,从外面传进来
    private Integer prePage;//上一页页码数
    private Integer nextPage;//下一页页码数
    private List<?> list = null;//每页显示的记录集合,从数据库查询

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    /**
     * 总页数
     *
     * @return
     */
    public Integer getTotalPages() {
        totalPages = (int) (totalRecords / pageSize);
        if (totalRecords % pageSize != 0) {
            totalPages += 1;
        }
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 上一页
     * @return
     */
    public Integer getPrePage() {
        if (pageNo <= 1) {
            prePage = 1;
        } else {
            prePage = pageNo - 1;
        }
        return prePage;
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }

    /**
     * 获得下一页
     * @return
     */
    public Integer getNextPage() {
        if(pageNo>=getTotalPages()){
            nextPage=getTotalPages();
        }else{
            nextPage= pageNo+1;
        }
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
