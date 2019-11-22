package com.hwua.enpity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Category {

    private Long id;
    private String name;
    private Long parent_id;
    private List <Category>list=new ArrayList<>();




    public Category(){}


    public Category(Long id, String name, Long parent_id) {
        this.id = id;
        this.name = name;
        this.parent_id = parent_id;
    }
}

