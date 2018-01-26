package com.YJ.controller;

import com.YJ.domain.BaseResult;
import com.YJ.domain.Student;
import com.YJ.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StudentController {
    /*声明service层中的对外接口对象*/
    private StudentService studentService;

    /**
     * 配置起始页
     */
    @RequestMapping(value = {"", "/"})
    public String index() {
        return "index";
    }

    //获取学生列表数据,用于前端页面表格显示
    //返回数据已json格式进行返回
    @RequestMapping(value = "/searchStudent")
    @ResponseBody
    public BaseResult<Student> searchStudent() {
        List<Student> students = studentService.selectAll();

        /*将查询到的结果集进行封装*/
        BaseResult<Student> result = new BaseResult<Student>();
        result.setTotal(100);// 设置总记录数
        result.setData(students);// 设置当前页显示数据
        return result;
    }

    @RequestMapping(value = "/findStudent")
    @ResponseBody
    public BaseResult<Student> findStudent(int pageInsex, int pageSize) {
        BaseResult<Student> result = studentService.pageSelect(pageInsex, pageSize);
        return result;
    }

}
