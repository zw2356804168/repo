package com.hwua.daoimpl;

import com.hwua.dao.NewsDao;
import com.hwua.enpity.News;
import com.hwua.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.util.List;

public class NewsDaoImpl implements NewsDao {
    @Override
    public List<News> queryAllnew() throws Exception {
       String sql="select id,title,content,create_time from amz_news";
        QueryRunner qr=new QueryRunner(C3P0Utils.getDs());
        List<News> list=qr.query(sql,new BeanListHandler<>(News.class));
        return list;
    }

    @Override
    public News querynewsById(Long id) throws Exception {
        String sql="select id,title,content,create_time from amz_news where id=?";
        QueryRunner qr=new QueryRunner(C3P0Utils.getDs());
        return qr.query(sql,new BeanHandler<>(News.class),id);
    }


}
