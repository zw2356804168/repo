package com.hwua.dao;

import com.hwua.entity.User;
//alt+ enter
public interface UserDao {
    public int insert(User user) throws Exception;
    public User queryByUser(User user) throws Exception;
    public User queryById(Long id) throws Exception;
}
