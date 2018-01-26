package com.YJ.service.impl;

import com.YJ.domain.BaseResult;
import com.YJ.domain.Student;
import com.YJ.mapper.StudentMapper;
import com.YJ.page.PageBean;
import com.YJ.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    //service层调用持久层的接口对象声明
    @Resource
    private StudentMapper studentMapper;

    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    public BaseResult<Student> pageSelect(int pageIndex, int pageSize) {

        BaseResult<Student> result = new BaseResult<Student>();

        int total = studentMapper.getTotalRecord();

        //构建分页对象
        PageBean<Student> pageBean = new PageBean<Student>(
                pageIndex + 1, pageSize, total);

        //获取当前页数据
        List<Student> datas = studentMapper.pageSelect(pageBean);

        //将总记录数与当前页data数据设置到BaseResult对象中
        result.setTotal(total);
        result.setData(datas);

        return result;
    }
}