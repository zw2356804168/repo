package com.hwua.enpity;

import lombok.Data;

@Data
public class CartItem {

    private Product product=new Product();//商品
    private Integer quanity;//数量
    private Double Shortmoney;//小计


    public Product getProduct() {

        return product;
    }

    public void setProduct(Product product) {

        this.product = product;
    }

    public Integer getQuanity() {

        return quanity;
    }

    public void setQuanity(Integer quanity) {

        this.quanity = quanity;
    }


    public Double getShortmoney() {

        return this.product.getPrice()*this.quanity;//单个购物项的小计
    }



    public void setShortmoney(Double shortmoney) {

        Shortmoney = shortmoney;
    }
}
