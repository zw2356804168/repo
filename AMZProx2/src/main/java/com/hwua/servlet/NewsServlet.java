package com.hwua.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hwua.enpity.News;
import com.hwua.service.NewsService;
import com.hwua.serviceimpl.NewsServiceImpl;

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

@WebServlet("/news.do")
public class NewsServlet extends HttpServlet {
    private NewsService ns;


    @Override
    public void init(ServletConfig config) throws ServletException {
        ns=new NewsServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String param = req.getParameter("param");
        if(param.equals("Allnews")){
            resp.setContentType("application/json;charset=utf-8");
                try {
                    List<News>list= ns.queryNews();

                    PrintWriter out = resp.getWriter();
                    if(list!=null) {
                        String json = JSON.toJSONString(list);
                        out.print(json.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
            }

        }else if (param.equals("new")){

            String id = req.getParameter("id");
            try {
                News news = ns.queryALLnewsById(Long.parseLong(id));


                req.setAttribute("news",news);

                req.getRequestDispatcher("news_view.jsp").forward(req,resp);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }
}
