package com.hwua.service;

import com.hwua.entity.User;

public interface UserService {
    public User login(User user) throws Exception;//登录
    public boolean register(User user) throws Exception;//注册
    public User querySendUserById(Long sendId)throws  Exception;//查询发送者
}
