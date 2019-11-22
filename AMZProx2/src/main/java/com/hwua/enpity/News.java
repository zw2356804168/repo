package com.hwua.enpity;

import lombok.Data;

@Data
public class News {
private Long id;
private String title;
private String content;
private String create_time;

//无参
public News(){}



//有参


    public News(Long id, String title, String content, String create_time) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.create_time = create_time;
    }
}
