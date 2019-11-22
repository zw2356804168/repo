package com.hwua.servlet;

import com.alibaba.fastjson.JSON;
import com.hwua.enpity.Category;
import com.hwua.service.CategoryService;
import com.hwua.serviceimpl.CategoryServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/cate.do")
public class CategroyServlet extends HttpServlet {
    private CategoryService cs;


    @Override
    public void init(ServletConfig config) throws ServletException {
        cs=new CategoryServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();

        String param = req.getParameter("param");
          if(param.equals("cate")){
              resp.setContentType("application/json");
              try {
                  List<Category> list = cs.querysort();
                  String json = JSON.toJSONString(list);

                   out.println(json);

              } catch (Exception e) {
                  e.printStackTrace();
              }

          }


    }
}
