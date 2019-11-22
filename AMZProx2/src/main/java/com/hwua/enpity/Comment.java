package com.hwua.enpity;

import lombok.Data;

@Data
public class Comment {
    private Long id;
    private String reply;
    private String content;
    private String create_time;
    private String reply_time;
    private String nick_name;







    public Comment(){}

    public Comment(String reply, String content, String create_time, String reply_time, String nick_name) {
        this.reply = reply;
        this.content = content;
        this.create_time = create_time;
        this.reply_time = reply_time;
        this.nick_name = nick_name;

    }
}
