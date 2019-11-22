package com.hwua.entity;

import lombok.*;

@Data
public class User {
    private Long id;
    private String name;
    private String pwd;
    private String email;
}
