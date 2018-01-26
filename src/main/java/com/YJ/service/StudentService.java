package com.YJ.service;

import com.YJ.domain.BaseResult;
import com.YJ.domain.Student;

import java.util.List;

/**
 * 生死有命
 * 富贵在天
 */
public interface StudentService {
    List<Student> selectAll();

    BaseResult<Student> pageSelect(int pageIndex, int pageSize);
}
