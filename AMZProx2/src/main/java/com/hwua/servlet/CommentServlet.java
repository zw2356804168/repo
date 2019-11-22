package com.hwua.servlet;

import com.alibaba.fastjson.JSON;
import com.hwua.enpity.Comment;
import com.hwua.enpity.PageEntity;
import com.hwua.service.CommentService;
import com.hwua.serviceimpl.CommentServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/liuyan")
public class CommentServlet  extends HttpServlet {
         private CommentService cs;


    @Override
    public void init(ServletConfig config) throws ServletException {
        cs=new CommentServiceImpl();
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
        if(param.equals("mebo")){
            try {
                Integer pageNo = Integer.parseInt(req.getParameter("pageNo"));
                Integer pageSize = Integer.parseInt(req.getParameter("pageSize"));
                PageEntity pageEntity = new PageEntity();
                List<Comment> list = cs.queryMsgByLimit((pageNo - 1) * pageSize, pageSize);
                Long count = cs.quertAllComments();
                pageEntity.setTotalRecords(count);
                pageEntity.setPageNo(pageNo);
                pageEntity.setPageSize(pageSize);
                pageEntity.setList(list);
                //System.out.println(list);
                String s = JSON.toJSONString(pageEntity);
                //System.out.println(s);
                out.write(s);
               // List<Comment> list1 = cs.queryAllComment();
                //String s = JSON.toJSONString(list1);
                //out.println(s);

                 /*Integer pageNo =Integer.parseInt( req.getParameter("pageNo"));
                Integer pageSize =Integer.parseInt( req.getParameter(" pageSize"));
                PageEntity pageEntity = new PageEntity();
                Long count = cs.quertAllComments();
                List<Comment> list = cs.queryMsgByLimit((pageNo - 1) * pageSize, pageSize);
                pageEntity.setPageNo(pageNo);
                pageEntity.setPageSize(pageSize);
                pageEntity.setTotalRecords(count);
                pageEntity.setList(list);
                System.out.println(list);
                String s = JSON.toJSONString(pageEntity);
                out.write(s);*/
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(param.equals("comment")){
            String name = req.getParameter("guestName");
            String guestTitle = req.getParameter("guestTitle");
            String guestContent = req.getParameter("guestContent");
            Comment comment=new Comment();
            comment.setReply(name);
            comment.setContent(guestTitle);
            comment.setNick_name(guestContent);
            try {
                Integer list = cs.insertguestbook(comment);

                     req.setAttribute("info",list);
                     req.getRequestDispatcher("/guestbook.jsp").forward(req,resp);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
