package com.hwua.servlet;

import com.alibaba.fastjson.JSON;
import com.hwua.enpity.Category;
import com.hwua.enpity.Product;
import com.hwua.service.CategoryService;
import com.hwua.service.ProductService;
import com.hwua.serviceimpl.CategoryServiceImpl;
import com.hwua.serviceimpl.ProductServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/hl.do")
public class HeadLineServlet extends HttpServlet {


    private String linkId(String id, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String histroyId = null;
        boolean flag = false;//默认没有找到指定名字的cookie
        //非第一次访问的时候
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("historyid")) {
                    flag = true;
                    histroyId = cookie.getValue();//1-2-3
                    break;
                }

            }
        }

        //浏览第一个商品的时候
        if (cookies == null || flag == false) {
            histroyId = id;
        }

        LinkedList<String> list = new LinkedList<String>(Arrays.asList(histroyId.split("-")));
        //假如长度不满4,冲突:先删除冲突的id,再把id添加到头部,不冲突,直接放到头部

        if (list.size() < 4) {
            if (list.contains(id)) {
                list.remove(id);//先删除
            }

        }

        if (list.size() == 4) {
            if (list.contains(id) == false) {
                list.removeLast();// 删除最后一个id
            } else {
                list.remove(id);//先删除
            }

        }
        list.addFirst(id);//添加到头部
        //动态拼接id
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if(i>0){
                sb.append("-");
            }
            sb.append(list.get(i));//拼接字符串
        }
        return sb.toString();
    }



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
        resp.setCharacterEncoding("utf-8");
      String  param  =req.getParameter("param");
        //一级标题
        if(param.equals("Firstid")){
            try {
                String id = req.getParameter("id");
                //查到所有一级标题
                List<Product> products = ps.queryFirstId(Integer.parseInt(id));
                CategoryService categoryService=new CategoryServiceImpl();
                Category category=categoryService.queryCategorybyid(Long.parseLong(id));

                req.setAttribute("Firstid",category);
                req.setAttribute("param","Firstid");
                //放到域中
                req.setAttribute("mid",products);
                //转发
                req.getRequestDispatcher("/product-list.jsp").forward(req,resp);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(param.equals("secondId")){//二级标题

            try {
                String id = req.getParameter("id");

                List<Product> secondId = ps.querySecondId(Integer.parseInt(id));
                CategoryService categoryService=new CategoryServiceImpl();
                Category categoryMinor=categoryService.queryCategorybyid(Long.parseLong(id));
                Category categoryMajor=categoryService.queryCategorybyid(categoryMinor.getParent_id());
                req.setAttribute("secondId",categoryMajor);
                req.setAttribute("Firstid",categoryMinor);
                req.setAttribute("param","secondId");
                req.setAttribute("sid",secondId);
                req.getRequestDispatcher("/product-list.jsp").forward(req,resp);
            } catch (Exception e) {
                e.printStackTrace();
            }


       //通过id查询商品
        }else if (param.equals("dingdan")){
            String id = req.getParameter("id");

            try {

                Product product = ps.queryBycommId(Long.parseLong(id));

                String historyId = linkId(String.valueOf(id), req);//获得拼接好的商品id

                Cookie cookie=new Cookie("historyid",historyId);
                cookie.setMaxAge(60*60*24*5);
                resp.addCookie(cookie);


                req.setAttribute("comm",product);
                req.getRequestDispatcher("/product_view.jsp").forward(req,resp);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if (param.equals("history")){//最近浏览
            String historyId = req.getParameter("historyid");

            List<Product>list=new ArrayList();
            if(!historyId.equals("")){
                String[] ids = historyId.split("-");
                for (String id:ids){
                    int i=Integer.parseInt(id);
                    try {
                        Product product = ps.queryBycommId((long) i);
                        list.add(product);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            String str = JSON.toJSONString(list);
            System.out.println(str);
            resp.getWriter().print(str);

        }

    }
}




