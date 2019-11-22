package com.hwua.enpity;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String uname;
    private String pwd;
    private Integer sex;
    private String birthday;
    private String idcard;
    private String email;
    private String mobile;
    private String address;
    private String utype;


    public User() {
    }

    public User( String uname, String pwd, Integer sex, String birthday, String idcard, String email, String mobile, String address, String utype) {

        this.uname = uname;
        this.pwd = pwd;
        this.sex = sex;
        this.birthday = birthday;
        this.idcard = idcard;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.utype = utype;
    }

    public User(String uname, String pwd) {
        this.uname = uname;
        this.pwd = pwd;
    }


    public User(String uname, String pwd, Integer sex, String birthday, String idcard, String email, String mobile, String address) {
        this.uname = uname;
        this.pwd = pwd;
        this.sex = sex;
        this.birthday = birthday;
        this.idcard = idcard;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }
}
