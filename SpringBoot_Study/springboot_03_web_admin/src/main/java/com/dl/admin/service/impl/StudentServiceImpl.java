package com.dl.admin.service.impl;

import com.dl.admin.mapper.StudentMapper;
import com.dl.admin.pojo.Student;
import com.dl.admin.service.StudentService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 定制metrics:
     * 实现统计请求访问的次数
     */
    Counter counter;
    public StudentServiceImpl(MeterRegistry meterRegistry) {
        counter = meterRegistry.counter("StudentServiceImpl.getStudentById.count");
    }

    @Override
    public Student getStudentById(Integer id) {
        counter.count();//次数+1
        return studentMapper.getStudentById(id);
    }
}
