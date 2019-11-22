package com.hwua.test;

import com.hwua.mapper.StudentMapper;
import com.hwua.pojo.Student;
import com.hwua.utils.SqlsessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

public class StudentTest {
    @Test
    public void test1() throws Exception{
        SqlSessionFactory sessionFactory= SqlsessionFactoryUtils.getInstance();
       try(SqlSession sqlSession=sessionFactory.openSession()){
           StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
           Student studentid = mapper.findStudentbYiD(13l);
           System.out.println(studentid);
       }
    }
    @Test
    public void test2() throws Exception{
        SqlSessionFactory sessionFactory= SqlsessionFactoryUtils.getInstance();
        try(SqlSession sqlSession=sessionFactory.openSession()){
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> stuList = mapper.FindallStudent();
            System.out.println(stuList);

        }
    }
    @Test
    public void test3() throws Exception{
        SqlSessionFactory sessionFactory= SqlsessionFactoryUtils.getInstance();
        try(SqlSession sqlSession=sessionFactory.openSession()){
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
           Student stu=new Student();
           stu.setSno("no007");
           stu.setSname("小黑");
           stu.setSsex("男");
            int stu1 = mapper.saveStudent(stu);
            sqlSession.commit();
            System.out.println(stu1);
        }
    }

    @Test
    public void test4() throws Exception{
        SqlSessionFactory sessionFactory= SqlsessionFactoryUtils.getInstance();
        try(SqlSession sqlSession=sessionFactory.openSession()){
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

            int stu2 = mapper.delStudentByID(12l);
            sqlSession.commit();
            System.out.println(stu2);

        }
    }

    @Test
    public void test5() throws Exception{
        SqlSessionFactory sessionFactory= SqlsessionFactoryUtils.getInstance();
        try(SqlSession sqlSession=sessionFactory.openSession()){
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Student stu3=new Student();
            stu3.setId(6l);
            stu3.setSname("xiaoxiao");

             mapper.updateStudent(stu3);
             sqlSession.commit();
            System.out.println(stu3);

        }
    }
    @Test
    public void test6() throws Exception{
        SqlSessionFactory sessionFactory= SqlsessionFactoryUtils.getInstance();
        try(SqlSession sqlSession=sessionFactory.openSession()){
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
           /* String name="赵";
            name="%"+name+"%";*/

           List<Student> students = mapper.finfStudentbYNAMELike("x");
           System.out.println(students);

        }
    }
    @Test
    public void test7() throws Exception{
        SqlSessionFactory sessionFactory= SqlsessionFactoryUtils.getInstance();
        try(SqlSession sqlSession=sessionFactory.openSession()){
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            Student student = mapper.findStudentByName("张三", "男");
            System.out.println(student);
        }
    }

}
