package com.hwua.mapper;

import com.hwua.pojo.Course;

import java.util.List;

public interface CourseMapper {
    public List<Course> findCoursesByTid(Long id) throws Exception;

}
