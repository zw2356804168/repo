package com.hwua.service;

import com.hwua.enpity.User;

public interface UserService {
    //登录
    public User login(User user)throws Exception;


    //注册
    public boolean  register(User user)throws Exception;

}
