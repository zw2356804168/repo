package com.hwua.enpity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class ShopCar {

    private List<CartItem> list=new ArrayList<>();//集合里面持有购物项
    private  User user=new User();
    private Double  title;//总计金额


    public List<CartItem> getList() {
        return list;
    }



    public void setList(List<CartItem> list) {
        this.list = list;
    }



    public User getUser() {

        return user;
    }



    public void setUser(User user) {
        this.user = user;

    }
   //总计
    public Double getTitle() {
      double t=0;
        for (CartItem cartItem:this.list) {
              t+=cartItem.getShortmoney();
        }
      return t;
    }

    public void setTitle(Double title) {

        this.title = title;
    }
}
