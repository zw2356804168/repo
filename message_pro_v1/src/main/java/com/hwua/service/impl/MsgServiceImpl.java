package com.hwua.service.impl;

import com.hwua.dao.MsgDao;
import com.hwua.dao.impl.MsgDaoImpl;
import com.hwua.entity.Message;
import com.hwua.entity.User;
import com.hwua.service.MsgService;

import java.util.List;

public class MsgServiceImpl implements MsgService {
    private MsgDao msgDao;

    public MsgServiceImpl() {
        this.msgDao = new MsgDaoImpl();
    }
    @Override
    public List<Message> queryAllMsgsByLoginId(Long loginid) throws Exception {
        return msgDao.queryAllMsgsById(loginid);
    }

    @Override
    public Message queryMsgById(Long id) throws Exception {
        Message msg = msgDao.queryMsgById(id);
        //判断短消息的状态是否是未读状态
        if(msg.getState()==1){
            msg.setState(0);
            msgDao.updateMsgState(msg);
        }
        return msg;
    }

    @Override
    public int delMsgById(String id) throws Exception {
        return msgDao.delete(id);
    }


}
