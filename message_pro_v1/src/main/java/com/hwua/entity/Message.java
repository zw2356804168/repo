package com.hwua.entity;

import lombok.Data;

@Data
public class Message {
    private Long id;
    private Long sendid;
    private String title;
    private String msgContent;
    private Integer state;
    private Long receiveid;
    private String msg_create_date;
    //发送者
    private User sendUser;
}
