package com.hwua.serviceimpl;

import com.hwua.dao.ProductDao;
import com.hwua.daoimpl.ProductDaoImpl;
import com.hwua.enpity.Product;
import com.hwua.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
        private ProductDao productDao;



        public ProductServiceImpl(){
            productDao=new ProductDaoImpl();
        }

   //查询所有商品
    @Override
    public List<Product> queryAllcommodity() throws Exception {
        return productDao.queryAllThing();
    }
   //热卖
    @Override
    public List<Product> queryHotsale() throws Exception {
        return productDao.queryHotsale();
    }
    //所有记录数
    @Override
    public Long queryCount() throws Exception {
        return productDao.queryCount();
    }
   //查询分页
    @Override
    public List<Product> queryMsgByLimit(Integer start, Integer pageSize) throws Exception {
        return productDao.queryMsgByLimit(start,pageSize);
    }
    //一级标题
    @Override
    public List<Product> queryFirstId(Integer id) throws Exception {
        return productDao.queryFirstid(id);
    }
   //二级标题
    @Override
    public List<Product> querySecondId(Integer id) throws Exception {
        return productDao.querySecondid(id);
    }
      //通过商品id查询
    @Override
    public Product queryBycommId(Long id) throws Exception {

        return productDao.queryBycommId(id);
    }
//模糊查询
    @Override
    public List<Product> queryBySearch(String name) throws Exception {
        return productDao.queryBySearch(name);
    }


}
