package com.hwua.pojo;

import lombok.Data;

@Data
public class Driverlicense {

  private long id;
  private String dno;
  private String address;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getDno() {
    return dno;
  }

  public void setDno(String dno) {
    this.dno = dno;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

}
