package com.hwua.dao;

import com.hwua.enpity.Order;
import com.hwua.enpity.Orderdetials;

import java.util.List;

public interface OrderDao {
  //添加订单
    public int addOrder(Order order)throws Exception;

    //添加订单明细
    public int addOrderdetail(Orderdetials od)throws Exception;

    //查询订单
    public Order queryorderid(Order order)throws Exception;

    //查询订单明细
  public List<Orderdetials> queryOrderDetails(Long id)throws Exception;

  //查询用户所有订单
  public List<Order> queryorderByUSER(Integer id)throws Exception;

}
