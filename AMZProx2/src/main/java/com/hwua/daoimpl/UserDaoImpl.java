package com.hwua.daoimpl;

import com.hwua.dao.UserDao;
import com.hwua.enpity.User;
import com.hwua.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class UserDaoImpl  implements UserDao {
    @Override
    public int insert(User user) throws Exception {
        String sql="insert into amz_user values(null,?,?,?,?,?,?,?,?,1)";
        QueryRunner qr=new QueryRunner(C3P0Utils.getDs());
        return qr.update(sql,user.getUname(),user.getPwd(),
                user.getSex(),user.getBirthday(),
                user.getIdcard(),user.getEmail(),
                user.getMobile(), user.getAddress());
    }

    @Override
    public User queryByUser(User user) throws Exception {
        String sql="select id,uname,pwd,sex,birthday,idcard,email,mobile,address,utype from amz_user  where uname=? and pwd=?";
       QueryRunner qr=new QueryRunner(C3P0Utils.getDs());

        return qr.query(sql,new BeanHandler<>(User.class),user.getUname(),user.getPwd());
    }
}
