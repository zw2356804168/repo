package com.hwua.mapper;

        import com.hwua.pojo.Student;
        import org.apache.ibatis.annotations.Param;

        import java.util.List;

public interface StudentMapper {
    public Student findStudentbYiD(Long id)throws Exception;
    public List<Student> FindallStudent()throws Exception;
    public int saveStudent (Student stu)throws Exception;
    public  int delStudentByID(Long id)throws  Exception;
    public int updateStudent(Student stu)throws  Exception;


    public  List<Student>finfStudentbYNAMELike(String name)throws Exception;
    public Student findStudentByName(@Param("name")String name, @Param("sex") String sex)throws  Exception;
}
