package com.hwua.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Teacher {

  private long id;
  private String tName;
  private String sex;
  private String birthday;
  private long did;
  private  Driverlicense driverlicense;
  private List<Course> cList;




}
