package com.hwua.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwua.mapper.TeacherMapper;
import com.hwua.pojo.Teacher;
import com.hwua.utils.SqlsessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TeacherTest {
     @Test
    public void test1()throws Exception{
         SqlSessionFactory sessionFactory= SqlsessionFactoryUtils.getInstance();
         try(SqlSession sqlSession=sessionFactory.openSession()) {
             TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
             Teacher yiD = mapper.findStudentbYiD(1l);
             System.out.println(yiD);
         }
    }

    @Test
    public void test2()throws Exception{
        SqlSessionFactory sessionFactory= SqlsessionFactoryUtils.getInstance();
        try(SqlSession sqlSession=sessionFactory.openSession()) {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            List<Teacher> teaList = mapper.findAllTeachers();
            System.out.println(teaList);
        }
    }


    @Test
    public void test6()throws Exception{
        SqlSessionFactory sessionFactory= SqlsessionFactoryUtils.getInstance();
        try(SqlSession sqlSession=sessionFactory.openSession()) {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

            PageHelper.startPage(1,1);
            List<Teacher> teaList = mapper.findAllTeachers2();
            PageInfo page = new PageInfo(teaList);
            System.out.println(teaList);
            System.out.println("当前页:"+ page.getPageNum());
            System.out.println("当前页显式的记录数:"+ page.getPageSize());
            System.out.println("总记录数:"+ page.getTotal());
            System.out.println("总页数:"+ page.getPages());
            System.out.println("上一页:"+ page.getPrePage());
            System.out.println("下一页:"+ page.getNextPage());
        }
    }

    @Test
    public void test3()throws Exception{
        SqlSessionFactory sessionFactory= SqlsessionFactoryUtils.getInstance();
        try(SqlSession sqlSession=sessionFactory.openSession()) {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            List<Teacher> teaList = mapper.findTeachers("陈豪",null);
            System.out.println(teaList);
        }
    }

    @Test
    public void test4()throws Exception{
        SqlSessionFactory sessionFactory= SqlsessionFactoryUtils.getInstance();
        try(SqlSession sqlSession=sessionFactory.openSession()) {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher t = new Teacher();
            t.setTName("陈豪");
            t.setId(1L);
            int res = mapper.updateTeacher(t);
            sqlSession.commit();
            System.out.println(res);
        }
    }



    @Test
    public void test5()throws Exception{
        SqlSessionFactory sessionFactory= SqlsessionFactoryUtils.getInstance();
        try(SqlSession sqlSession=sessionFactory.openSession()) {
            TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            List<Long> list = new ArrayList<>();
            list.add(1L);
            list.add(2L);
            list.add(5L);
            List<Teacher> allTeachers = mapper.findTeachersByIds(list);
            System.out.println(allTeachers);

        }
    }
}
