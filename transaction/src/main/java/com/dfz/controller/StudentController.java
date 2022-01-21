package com.dfz.controller;

import com.dfz.entity.Student;
import com.dfz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author DFZ
 * @Date 2021-07-19 18:34
 * @Description
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    public void update() {
        Student student = new Student();
        student.setId(1L);
        student.setName("DDFFZZ");
        studentService.update(student);
    }

}
