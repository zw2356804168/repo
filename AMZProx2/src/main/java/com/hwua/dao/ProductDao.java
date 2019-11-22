package com.hwua.dao;

import com.hwua.enpity.Product;

import java.util.List;

public interface ProductDao {
    //查找所有商品
    public List<Product> queryAllThing()throws Exception;



    //查找热卖
    public List<Product>queryHotsale()throws Exception;

  //查询总记录数
  public Long queryCount() throws Exception;

//查询分页
public List<Product> queryMsgByLimit(Integer start,Integer pageSize) throws Exception;


//按照一级标题查找商品
public  List<Product>queryFirstid(Integer id)throws Exception;

//按照二级标题查找商品
public List<Product>querySecondid(Integer id)throws Exception;

//通过ID查找商品
public Product queryBycommId( Long id)throws Exception;

//模糊搜索
    public List<Product> queryBySearch(String name)throws Exception;


}
