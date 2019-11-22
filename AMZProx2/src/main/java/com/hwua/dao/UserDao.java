package com.hwua.dao;

import com.hwua.enpity.User;

public interface UserDao {

    //登录
    public User queryByUser(User user)throws Exception;
   //注册
    public int insert(User user)throws Exception;


}
