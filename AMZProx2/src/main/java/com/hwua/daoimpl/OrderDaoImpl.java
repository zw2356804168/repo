package com.hwua.daoimpl;

import com.hwua.dao.OrderDao;
import com.hwua.enpity.Order;
import com.hwua.enpity.Orderdetials;
import com.hwua.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.text.SimpleDateFormat;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public int addOrder(Order order) throws Exception {
       String sql="insert into amz_order values(null,?,?,?,?,?,1,1);";
        QueryRunner qr=new QueryRunner(C3P0Utils.getDs());
       return qr.update(sql,order.getUid(),order.getUname(),order.getUaddress(),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(order.getCreate_time()),order.getMoney());
    }

    @Override
    public int addOrderdetail(Orderdetials od) throws Exception {
        String sql="insert into amz_order_detail values(null,?,?,?,?)";
          QueryRunner qr=new QueryRunner(C3P0Utils.getDs());
          return qr.update(sql,od.getOid(),od.getPid(),od.getQuantity(),od.getMoney());
    }

    @Override
    public Order queryorderid(Order order) throws Exception {
       String sql="select * from amz_order where uid=? and uname=? and uaddress=? and create_time=? and money=?   ";
        QueryRunner qr=new QueryRunner(C3P0Utils.getDs());

        return qr.query(sql,new BeanHandler<>(Order.class),order.getUid(),order.getUname(),order.getUaddress(),new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(order.getCreate_time()),order.getMoney());
    }

    @Override
    public List<Orderdetials> queryOrderDetails(Long id) throws Exception {
       String sql="select * from amz_order_detail where oid=?";
        QueryRunner qr=new QueryRunner(C3P0Utils.getDs());
        return qr.query(sql,new BeanListHandler<>(Orderdetials.class),id);
    }

    @Override
    public List<Order> queryorderByUSER(Integer id) throws Exception {
       String sql="select * from amz_order where uid=?";
        QueryRunner qr=new QueryRunner(C3P0Utils.getDs());
        return qr.query(sql,new BeanListHandler<>(Order.class),id);
    }


}
