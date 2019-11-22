package com.hwua.mapper;


import com.hwua.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    public Teacher findStudentbYiD(Long id)throws Exception;
    public List<Teacher> findAllTeachers2() throws Exception;
    public List<Teacher> findAllTeachers() throws Exception;
    public List<Teacher> findTeachers(@Param("name") String name, @Param("sex") String sex) throws Exception;
    public int updateTeacher(Teacher teacher) throws Exception;
    public List<Teacher> findTeachersByIds(List<Long> list) throws Exception;

}
