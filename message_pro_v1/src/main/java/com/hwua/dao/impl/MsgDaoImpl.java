package com.hwua.dao.impl;

import com.hwua.dao.MsgDao;
import com.hwua.entity.Message;
import com.hwua.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class MsgDaoImpl implements MsgDao {
    @Override
    public List<Message> queryAllMsgsById(Long id) throws Exception {
        String sql="select id,sendid,title,msgContent,state,receiveid,msg_create_date from messages where receiveid=? order by msg_create_date desc";
        QueryRunner qr = new QueryRunner(C3P0Util.getDs());
        return qr.query(sql,new BeanListHandler<>(Message.class),id);
    }

    @Override
    public Message queryMsgById(Long id) throws Exception {
        String sql="select id,sendid,title,msgContent,state,receiveid,msg_create_date from messages where id=?";
        QueryRunner qr = new QueryRunner(C3P0Util.getDs());
        return qr.query(sql,new BeanHandler<>(Message.class),id);
    }

    @Override
    public int updateMsgState(Message msg) throws Exception {
        String sql = "update messages set state=? where id = ?";
        QueryRunner qr = new QueryRunner(C3P0Util.getDs());
        return qr.update(sql,msg.getState(),msg.getId());
    }

    @Override
    public int delete(String id) throws Exception {
        String sql="delete from messages where id=?";
        QueryRunner qr = new QueryRunner(C3P0Util.getDs());
        return qr.update(sql,id);
    }
}
