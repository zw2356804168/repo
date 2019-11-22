package com.hwua.servlet;

import com.alibaba.fastjson.JSON;
import com.hwua.enpity.PageEntity;
import com.hwua.enpity.Product;
import com.hwua.enpity.User;
import com.hwua.service.ProductService;
import com.hwua.serviceimpl.ProductServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Product.do")
public class ProductServlet extends HttpServlet {
         private ProductService ps;


    @Override
    public void init(ServletConfig config) throws ServletException {
        ps=new ProductServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
             req.setCharacterEncoding("utf-8");
             resp.setContentType("application/json;charset=utf-8");
             PrintWriter out = resp.getWriter();

          String param = req.getParameter("param");

        if(param.equals("Product")){
            try {
                Integer pageNo = Integer.parseInt(req.getParameter("pageNo"));
                Integer pageSize = Integer.parseInt(req.getParameter("pageSize"));
                PageEntity pageEntity = new PageEntity();
                Long count = ps.queryCount();
                List<Product> list = ps.queryMsgByLimit((pageNo - 1) * pageSize, pageSize);
                pageEntity.setTotalRecords(count);
                pageEntity.setPageNo(pageNo);
                pageEntity.setPageSize(pageSize);
                pageEntity.setList(list);
                //System.out.println(list);
                String s = JSON.toJSONString(pageEntity);
                out.write(s);
                //List<Product> list = ps.queryAllcommodity();
                //String list1 = JSON.toJSONString(list);
               // System.out.println(list1);
                //out.println(list1);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if(param.equals("HotSale")){
            try {
                List<Product> HotSale = ps.queryHotsale();
               String Sale = JSON.toJSONString(HotSale);
               out.println(Sale);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if(param.equals("mohu")){
            String word = req.getParameter("word");
           String kw="%"+word+"%";

            try {
                List<Product> list= ps.queryBySearch(kw);
                req.setAttribute("mid",list);
                req.getRequestDispatcher("/product-list.jsp").forward(req,resp);
                System.out.println(list);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
