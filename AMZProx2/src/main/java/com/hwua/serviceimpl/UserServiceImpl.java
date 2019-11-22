package com.hwua.serviceimpl;

import com.hwua.dao.UserDao;
import com.hwua.daoimpl.UserDaoImpl;
import com.hwua.enpity.User;
import com.hwua.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;


    public UserServiceImpl(){
        userDao=new UserDaoImpl();

    }

    @Override
    public User login(User user) throws Exception {
        return userDao.queryByUser(user);

    }

    @Override
    public boolean register(User user) throws Exception {
        return userDao.insert(user) == 1;
    }
}
