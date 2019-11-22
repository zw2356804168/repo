package com.hwua.daoimpl;

import com.hwua.dao.ProductDao;
import com.hwua.enpity.Product;
import com.hwua.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class ProductDaoImpl implements ProductDao {



    @Override
    public List<Product> queryAllThing() throws Exception {
        String sql="select id,name,description,price,stock,major_id,minor_id,img_source  from amz_product";
        QueryRunner qr=new QueryRunner(C3P0Utils.getDs());
        return qr.query(sql, new BeanListHandler<>(Product.class));
    }

    @Override
    public List<Product> queryHotsale() throws Exception {
       String sql="SELECT * FROM `amz_product` order by stock";
        QueryRunner qr=new QueryRunner(C3P0Utils.getDs());
        return qr.query(sql,new BeanListHandler<>(Product.class));
    }

    @Override
    public Long queryCount() throws Exception {
        String sql="select count(*) from amz_product";
       QueryRunner qr=new QueryRunner(C3P0Utils.getDs());
        return (Long)qr.query(sql,new ScalarHandler<>());
    }


    @Override
    public List<Product> queryMsgByLimit(Integer start, Integer pageSize) throws Exception {
        String sql="select * from amz_product order by id desc limit ?,?";
        QueryRunner qr = new QueryRunner(C3P0Utils.getDs());
        return qr.query(sql,new BeanListHandler<>(Product.class),start,pageSize);
    }

    @Override
    public List<Product> queryFirstid(Integer id) throws Exception {
        String sql="SELECT * FROM `amz_product` where major_id=? ";
        QueryRunner qr=new QueryRunner(C3P0Utils.getDs());
        return qr.query(sql,new BeanListHandler<>(Product.class),id);
    }

    @Override
    public List<Product> querySecondid(Integer id) throws Exception {
        String sql="SELECT * FROM `amz_product` where minor_id=?";
        QueryRunner qr=new QueryRunner(C3P0Utils.getDs());
        return qr.query(sql,new BeanListHandler<>(Product.class),id);
    }

    @Override
    public Product queryBycommId(Long id) throws Exception {
       String sql="SELECT * FROM `amz_product` where id=?";
       QueryRunner qr=new QueryRunner(C3P0Utils.getDs());
        return qr.query(sql,new BeanHandler<>(Product.class),(id));
    }

    @Override
    public List<Product> queryBySearch(String name) throws Exception {
       String sql="SELECT * FROM `amz_product` where name like ?";
       QueryRunner qr=new QueryRunner(C3P0Utils.getDs());
        return qr.query(sql,new BeanListHandler<>(Product.class),name);
    }


}
