package com.hwua.serviceimpl;

import com.hwua.dao.OrderDao;
import com.hwua.daoimpl.OrderDaoImpl;
import com.hwua.enpity.Order;
import com.hwua.enpity.Orderdetials;
import com.hwua.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
   private OrderDao orderDao;



   public OrderServiceImpl(){
       orderDao=new OrderDaoImpl();
   }


    @Override
    public boolean addOrder(Order order) throws Exception {

    return orderDao.addOrder(order)==1;
    }

    @Override
    public boolean addOrderdetail(Orderdetials od) throws Exception {

       return orderDao.addOrderdetail(od)==1;
    }

    @Override
    public Order queryOrder(Order order) throws Exception {

        return orderDao.queryorderid(order);
    }

    @Override
    public List<Orderdetials> queryOrderDetails(Long id) throws Exception {
        return orderDao.queryOrderDetails(id);
    }

    @Override
    public List<Order> queryorderByUSER(Integer id) throws Exception {
        return orderDao.queryorderByUSER(id);
    }
}
