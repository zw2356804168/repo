package com.hwua.enpity;

import lombok.Data;

@Data
public class Orderdetials {
    private Long id;
    private Long oid;//订单id
    private Long pid;//商品id
    private Integer quantity;//数量
    private Double money;//总额
    private String img;
    private String pname;
    private Double price;






}
