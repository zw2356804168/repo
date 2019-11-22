package com.hwua.service;

import com.hwua.enpity.Product;

import java.util.List;

public interface ProductService {
    //查询所有商品
    public List<Product> queryAllcommodity()throws Exception;


    //热卖
    public List<Product>queryHotsale()throws Exception;

   //所有记录数
    public Long queryCount() throws Exception;

   //查询分页
    public List<Product> queryMsgByLimit(Integer start,Integer pageSize) throws Exception;


    //查询一级标题商品
    public List<Product> queryFirstId(Integer id)throws Exception;


    //查询二级标题商品
    public List<Product> querySecondId(Integer id)throws Exception;

   //通过id查找商品详细信息
    public Product queryBycommId(Long id)throws Exception;

    //模糊搜索
    public List<Product> queryBySearch(String name)throws Exception;
}
