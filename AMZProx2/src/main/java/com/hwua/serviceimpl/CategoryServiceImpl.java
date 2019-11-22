package com.hwua.serviceimpl;

import com.hwua.dao.CategoryDao;
import com.hwua.daoimpl.CategoryDaoImpl;
import com.hwua.enpity.Category;
import com.hwua.enpity.ChildCateGory;
import com.hwua.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao;



    public  CategoryServiceImpl(){categoryDao=new CategoryDaoImpl(); }




    @Override
    public List<Category> querysort() throws Exception {
        List<Category> list = categoryDao.queryfirstParentId();
        for (Category category:list) {
       category.setList(categoryDao.querysecondId(category.getId()));

        }

        return list;
    }

    @Override
    public ChildCateGory queryChild(int id) throws Exception {
        return categoryDao.queryChild(id);
    }

    @Override
    public ChildCateGory queryFathrt(int id) throws Exception {
        return categoryDao.queryFathrt(id);
    }

    @Override
    public List<Category> queryAllCategory() throws Exception {
        return categoryDao.queryAllCategory();
    }

    @Override
    public Category queryCategorybyid(Long id) throws Exception {
        return categoryDao.queryCategorybyid(id);
    }
}
