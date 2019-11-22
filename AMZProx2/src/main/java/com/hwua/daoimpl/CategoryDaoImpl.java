package com.hwua.daoimpl;

import com.hwua.dao.CategoryDao;
import com.hwua.enpity.Category;
import com.hwua.enpity.ChildCateGory;
import com.hwua.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {


    @Override
    public List<Category> queryfirstParentId() throws Exception {
        String sql="SELECT * FROM amz_product_category where parent_id=id";
        QueryRunner qr=new QueryRunner(C3P0Utils.getDs());
//        List<Category>list= (List<Category>) qr.query(sql,new BeanHandler<>(Category.class));
        return qr.query(sql,new BeanListHandler<>(Category.class));
    }

    @Override
    public List<Category> querysecondId(Long id) throws Exception {
        String sql="SELECT id,name FROM amz_product_category where parent_id!=id and parent_id=?";
        QueryRunner qr=new QueryRunner(C3P0Utils.getDs());
        List<Category>list=qr.query(sql,new BeanListHandler<>(Category.class),id);
        return list;
    }

    @Override
    public ChildCateGory queryChild(int id) throws Exception {
       String sql="select id,name,parent_id from amz_product_category where id=?";
       QueryRunner qr=new QueryRunner(C3P0Utils.getDs());
        return qr.query(sql,new BeanHandler<>(ChildCateGory.class),id);
    }

    @Override
    public ChildCateGory queryFathrt(int id) throws Exception {
        String sql="select id, name,parent_id from amz_product_category where id=? " ;
        QueryRunner qr=new QueryRunner(C3P0Utils.getDs());

        return qr.query(sql,new BeanHandler<>(ChildCateGory.class),id);
    }

    @Override
    public List<Category> queryAllCategory() throws Exception {
        String sql="select*from amz_product_category";
        QueryRunner qr=new QueryRunner(C3P0Utils.getDs());
        return qr.query(sql,new BeanListHandler<>(Category.class));
    }

    @Override
    public Category queryCategorybyid(Long id) throws Exception {
        String sql="select*from amz_product_category where id=?";
        QueryRunner qr=new QueryRunner(C3P0Utils.getDs());
        return qr.query(sql,new BeanHandler<>(Category.class),id);
    }
}
