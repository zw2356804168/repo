package com.hwua.servlet;

import com.alibaba.fastjson.JSON;
import com.hwua.enpity.Order;
import com.hwua.enpity.Orderdetials;
import com.hwua.enpity.Product;
import com.hwua.enpity.User;
import com.hwua.service.OrderService;
import com.hwua.service.ProductService;
import com.hwua.serviceimpl.OrderServiceImpl;
import com.hwua.serviceimpl.ProductServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/or")
public class OrderServlet extends HttpServlet {
    private  OrderService orderService;
    private ProductService PS;


    @Override
    public void init(ServletConfig config) throws ServletException {
        orderService=new OrderServiceImpl();
        PS=new ProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("param");
        resp.setContentType("application/json;charset=utf-8");
        if(param.equals("order")){
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("login");

            try {
                List<Order> orders = orderService.queryorderByUSER((user.getId()));
                for (Order order : orders) {
                    Long id = order.getId();
                    List<Orderdetials> orderdetials = orderService.queryOrderDetails(id);
                    order.setList(orderdetials);

                     for (Orderdetials orderdetial : orderdetials) {
                        Integer quantity = orderdetial.getQuantity();
                        Long pid = orderdetial.getPid();
                        Product product = PS.queryBycommId(pid);
                        String img_source = product.getImg_source();
                        orderdetial.setImg(img_source);
                        orderdetial.setPname(product.getName());
                    }
                }
                 String json = JSON.toJSONString(orders);

                resp.getWriter().print(json);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }
}
