package com.hwua.dao;


import com.hwua.enpity.News;

import java.util.List;

public interface NewsDao {
      //查找所有新闻
    public List<News> queryAllnew()throws Exception;

    //根据id读取新闻
    public News querynewsById(Long id)throws Exception;

}
