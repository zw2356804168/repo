package com.hwua.servlet;

import com.hwua.enpity.*;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private ProductService ps;
    private OrderService orderService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        ps=new ProductServiceImpl();
        orderService = new OrderServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("param");
        if(param.equals("addcart")){
            String id = req.getParameter("id");//拿到id
            String count = req.getParameter("num");//拿到数量
            HttpSession session = req.getSession(false);
                   //seeeion中放购物车
                 ShopCar cart =(ShopCar) session.getAttribute("cart");
                   //判断购物车不为空
                  if(cart==null || cart.equals("")) {
                      ShopCar shopCar=new ShopCar();
                      CartItem cartItem=new CartItem();//购物项
                      try {

                          cartItem.setProduct(ps.queryBycommId(Long.parseLong(id)));

                          cartItem.setQuanity(Integer.parseInt(count));
                         //把购物项塞进购物车
                          shopCar.getList().add(cartItem);
                          session.setAttribute("cart",shopCar);
                          resp.sendRedirect("shopping.jsp");
                      } catch (Exception e) {
                          e.printStackTrace();
                      }
                  }
                  else{
                    boolean   flag=true;
                      for (CartItem cartItem:cart.getList() ) {
                          //遍历list
                          if(cartItem.getProduct().getId().equals(id)){
                              //得到商品id
                              cartItem.setQuanity(cartItem.getQuanity()+Integer.parseInt(count));
                         //商品的数量
                          flag=false;
                          break;
                          }
                      }if(flag){
                          try {
                              CartItem cartItem=new CartItem();

                              cartItem.setProduct(ps.queryBycommId(Long.parseLong(id)));

                              cartItem.setQuanity(Integer.parseInt(count));
                             //购物项放进购物车
                              cart.getList().add(cartItem);
                              session.setAttribute("cart",cart);

                          } catch (Exception e) {
                              e.printStackTrace();
                          }
                      }
                      resp.sendRedirect("shopping.jsp");
                  }

        }else if(param.equals("delete")){//删除购物项
            String pid = req.getParameter("id");
            HttpSession session = req.getSession();
            ShopCar shopCar =(ShopCar) session.getAttribute("cart");
            List<CartItem> list = shopCar.getList();
            for (CartItem cartItem:list) {
               if (cartItem.getProduct().getId()==Long.parseLong(pid)){
                   list.remove(cartItem);
                   break;
               }
            }
            resp.sendRedirect("shopping.jsp");
        }else if(param.equals("settlement")){
            Settlement(req, resp);
        }
    }



    //数据库添加订单和订单明细
    private void Settlement(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession session = req.getSession(false);

        ShopCar shoppingCart = (ShopCar) session.getAttribute("cart");
        //System.out.println(shoppingCart);
        User user = (User)session.getAttribute("login");
        if(user==null){
            //req.setAttribute("info","请先登录");
            //req.getRequestDispatcher("/login.jsp").forward(req,resp);
            resp.sendRedirect("login.jsp");
            return;
        }else{
            if(shoppingCart==null || shoppingCart.getList().size()==0){
                //req.getRequestDispatcher("shopping.jsp").forward(req,resp);
                resp.sendRedirect("index.jsp");
                return;
            }else {
                shoppingCart.setUser(user);
                Order order = new Order();
                order.setUid((long)user.getId());
                order.setUname(user.getUname());
                order.setUaddress(user.getAddress());
                order.setMoney(shoppingCart.getTitle());
                order.setCreate_time(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                try {
                    orderService.addOrder(order);
                    order = orderService.queryOrder(order);//查询订单
                    Orderdetials detail = new Orderdetials();
                    detail.setOid(order.getId());//订单id
                    for (CartItem cartItem:shoppingCart.getList()) {//遍历购物项

                        detail.setQuantity(cartItem.getQuanity());
                        detail.setMoney(cartItem.getProduct().getPrice()*detail.getQuantity());
                        detail.setPid(cartItem.getProduct().getId());
                        System.out.println(detail);
                        orderService.addOrderdetail(detail);
                    }
                    session.setAttribute("cart",null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        req.getRequestDispatcher("/shopping-result.jsp").forward(req,resp);
    }
}
