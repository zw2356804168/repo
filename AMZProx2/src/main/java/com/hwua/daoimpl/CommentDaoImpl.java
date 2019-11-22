package com.hwua.daoimpl;

import com.hwua.dao.CommentDao;
import com.hwua.enpity.Comment;
import com.hwua.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.List;

public class CommentDaoImpl implements CommentDao {
    @Override
    public List<Comment> queryAllComment() throws Exception {
        String sql="select id,reply,content,create_time,reply_time,nick_name,state from amz_comment  order by id desc";
        QueryRunner qr=new QueryRunner(C3P0Utils.getDs());
        return qr.query(sql,new BeanListHandler<>(Comment.class));
    }

    @Override
    public Long querycomments() throws Exception {
        String sql="select count(*) from amz_comment";
        QueryRunner qr=new QueryRunner(C3P0Utils.getDs());
        return (Long) qr.query(sql,new ScalarHandler<>());
    }


    @Override
    public List<Comment> queryMsgByLimit(Integer start, Integer pageSize) throws Exception {
        String sql="select * from amz_comment order by create_time desc limit ?,?";
        QueryRunner  qr=new QueryRunner(C3P0Utils.getDs());
        return qr.query(sql,new BeanListHandler<>(Comment.class),start,pageSize);
    }

    @Override
    public Integer insertguestbook(Comment comment) throws Exception {
        String sql="insert into amz_comment values(null,?,?,now(),now(),?,null)";
           QueryRunner qr=new QueryRunner(C3P0Utils.getDs());

        return qr.update(sql,comment.getReply(),comment.getContent(),comment.getNick_name());
    }
}
