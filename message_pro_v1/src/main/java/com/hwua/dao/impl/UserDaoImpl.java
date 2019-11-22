package com.hwua.dao.impl;

import com.hwua.dao.UserDao;
import com.hwua.entity.User;
import com.hwua.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class UserDaoImpl implements UserDao {
    @Override
    public int insert(User user) throws Exception {
        String sql = "insert into users values(null,?,?,?)";
        //创建dbutils核心处理对象,给定连接池对象
        QueryRunner qr = new QueryRunner(C3P0Util.getDs());
        return qr.update(sql, user.getName(), user.getPwd(), user.getEmail());
    }

    @Override
    public User queryByUser(User user) throws Exception {
        String sql = "select id,name,pwd,email from users where name=? and pwd=?";
        //创建dbutils核心处理对象,给定连接池对象
        QueryRunner qr = new QueryRunner(C3P0Util.getDs());
        return qr.query(sql, new BeanHandler<>(User.class), user.getName(), user.getPwd());
    }

    /**
     * 根据发送者的id来获取User对象
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public User queryById(Long id) throws Exception {
        String sql = "select id,name,pwd,email from users where id=?";
        QueryRunner qr = new QueryRunner(C3P0Util.getDs());
        return qr.query(sql,new BeanHandler<>(User.class),id);
    }
}
