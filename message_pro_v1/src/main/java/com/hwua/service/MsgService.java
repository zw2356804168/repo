package com.hwua.service;

import com.hwua.entity.Message;
import com.hwua.entity.User;

import java.util.List;

public interface MsgService {
    public List<Message> queryAllMsgsByLoginId(Long loginid) throws Exception;
    public Message queryMsgById(Long id) throws Exception;
    public int delMsgById(String id) throws Exception;
}
