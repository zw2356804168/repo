package com.hwua.serviceimpl;

import com.hwua.dao.CategoryDao;
import com.hwua.dao.CommentDao;
import com.hwua.daoimpl.CategoryDaoImpl;
import com.hwua.daoimpl.CommentDaoImpl;
import com.hwua.enpity.Comment;
import com.hwua.service.CommentService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    private CommentDao ct;


    public CommentServiceImpl(){
        ct=new CommentDaoImpl();
    }


    @Override
    public List<Comment> queryAllComment() throws Exception {
        return ct.queryAllComment();
    }

    @Override
    public Long quertAllComments() throws Exception {
        return ct.querycomments();
    }


    @Override
    public List<Comment> queryMsgByLimit(Integer start, Integer pageSize) throws Exception {
        return ct.queryMsgByLimit(start,pageSize);
    }

    @Override
    public Integer insertguestbook(Comment comment) throws Exception {
        return ct.insertguestbook(comment);
    }
}
