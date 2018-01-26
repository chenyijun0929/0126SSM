package com.YJ.mapper;

import com.YJ.domain.Student;
import com.YJ.page.PageBean;

import java.util.List;

/**
 * Student操作的对外接口声明
 * 具体实现Student.xml
 */
public interface StudentMapper {
    /**
     * 查询所有学生列表
     * 1.方法名对应Student.xml中的id属性
     * 2.方法参数对应Student.xml中的parameterType属性
     * 3.方法返回值对应Student.xml中的resultType属性
     *
     * @return
     */
    List<Student> selectAll();

    /**
     * 分页查询
     *
     * @param pageBean 包含分页信息对象
     */
    List<Student> pageSelect(PageBean<Student> pageBean);

    /**
     * 获取学生表总条数
     */
    Integer getTotalRecord(PageBean<Student>pageBean);
}
