package com.hwua.serviceimpl;

import com.hwua.dao.NewsDao;
import com.hwua.daoimpl.NewsDaoImpl;
import com.hwua.enpity.News;
import com.hwua.service.NewsService;

import java.util.List;

public class NewsServiceImpl implements NewsService {
     private NewsDao newsDao;
     public  NewsServiceImpl(){
         newsDao=new  NewsDaoImpl();
     }


    @Override
    public List<News> queryNews() throws Exception {
        return newsDao.queryAllnew();
    }


    @Override
    public News queryALLnewsById(Long id) throws Exception {
         return newsDao.querynewsById(id);
    }
}
