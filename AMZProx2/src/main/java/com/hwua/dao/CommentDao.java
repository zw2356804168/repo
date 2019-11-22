package com.hwua.dao;

import com.hwua.enpity.Comment;

import java.util.List;

public interface CommentDao {

    //查询所有留言
 public List<Comment> queryAllComment()throws Exception;




 //查询所有留言数
 public Long querycomments() throws Exception;



 //查询分页
 public List<Comment> queryMsgByLimit(Integer start,Integer pageSize) throws Exception;



 //发送评论
 public Integer insertguestbook(Comment comment)throws Exception;
}
