package com.hwua.service;

import com.hwua.enpity.Comment;

import java.util.List;

public interface CommentService {
    //查询所有留言
    public List<Comment> queryAllComment()throws Exception;





    //查询所有留言记录数
    public  Long quertAllComments()throws Exception;



    //查询分页
    public List<Comment> queryMsgByLimit(Integer start,Integer pageSize) throws Exception;


    //添加短消息

    public Integer insertguestbook(Comment comment)throws Exception;
}
