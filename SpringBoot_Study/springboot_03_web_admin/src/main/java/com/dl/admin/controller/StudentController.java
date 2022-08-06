package com.dl.admin.controller;

import com.dl.admin.pojo.Student;
import com.dl.admin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudent")
    @ResponseBody
    public Student getStudent(Integer id) {
        System.out.println("StudentController ---> "+ id);
        return studentService.getStudentById(id);
    }


}
