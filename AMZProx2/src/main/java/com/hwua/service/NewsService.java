package com.hwua.service;

import com.hwua.enpity.News;

import java.util.List;

public interface NewsService {
   //查询所有消息
    public List<News>queryNews()throws Exception;


     //根据id查看内容
    public News queryALLnewsById(Long id)throws Exception;
}
