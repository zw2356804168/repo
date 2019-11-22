package com.hwua.dao;

import com.hwua.entity.Message;

import java.util.List;

public interface MsgDao {
    //查询当前登录用户所收到的所有短消息
    public List<Message> queryAllMsgsById(Long id) throws Exception;

    //查询当前短消息
    public Message queryMsgById(Long id) throws Exception;

    public int updateMsgState(Message msg)throws Exception;

    public int delete(String id) throws Exception;
}
