package com.hwua.enpity;

import lombok.Data;

@Data
public class Product {
    private  Long id;
    private String name;
    private String description;
    private Double price; ;
    private Integer stock;
    private Integer major_id;
    private Integer minor_id;
    private String img_source;


    public Product(){}


    public Product( String name, String description, Double  price, Integer stock, Integer major_id, Integer minor_id, String img_source) {

        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.major_id = major_id;
        this.minor_id = minor_id;
        this.img_source = img_source;
    }



}
