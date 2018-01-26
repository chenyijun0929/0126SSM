package com.YJ.test;

import com.YJ.domain.Student;
import com.YJ.mapper.StudentMapper;
import com.YJ.page.PageBean;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 生死有命
 * 富贵在天
 */
public class MainTest {

    private ApplicationContext context;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("classpath*:spring-*.xml");
    }

    @Test
    public void testMapper() {
        StudentMapper studentMapper = context.getBean(StudentMapper.class);

        List<Student> students = studentMapper.selectAll();
        System.out.println(students);
        /*获取总条数*/
        int count = studentMapper.getTotalRecord();

        System.out.println(count);
        /*分页查询*/
        PageBean<Student>pageBean = new PageBean<Student>(1,3,count);
        System.out.println(studentMapper.pageSelect(pageBean));
    }

    @Test
    public void test(){
        StudentMapper studentMapper = context.getBean(StudentMapper.class);

        int total = studentMapper.getTotalRecord();

        PageBean<Student> pageBean = new PageBean<Student>(1,3,total);

        Student param = new Student();

        param.setSname("瓦里安");
        pageBean.setParameter(param);

        List<Student> students = studentMapper.pageSelect(pageBean);

        System.out.println(students);
    }
}
