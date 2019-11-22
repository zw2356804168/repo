package com.hwua.service;

import com.hwua.enpity.Category;
import com.hwua.enpity.ChildCateGory;

import java.util.List;

public interface CategoryService {


    //查询一二级分类
    public List<Category> querysort()throws Exception;

    //查找自己标签
    public ChildCateGory queryChild(int id)throws Exception;




    //通过id查找一级标签
    public ChildCateGory queryFathrt(int id)throws Exception;

    //查询所有标签
    public List<Category> queryAllCategory()throws  Exception;

    //通过id查询标签
    public Category queryCategorybyid(Long id)throws Exception;
}
