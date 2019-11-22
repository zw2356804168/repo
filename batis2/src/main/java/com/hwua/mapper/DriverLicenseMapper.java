package com.hwua.mapper;

import com.hwua.pojo.Driverlicense;

public interface DriverLicenseMapper {
    public Driverlicense findDriverLicenseById(Long did) throws Exception;
}
