package com.hwua.enpity;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private Long id;
    private Long uid;
    private String uname;
    private String uaddress;
    private String create_time;
    private Double money;
    private List<Orderdetials> list;


}
