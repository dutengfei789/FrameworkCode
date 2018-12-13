package com.baizhi.controller;

import com.baizhi.entity.Student;
import com.baizhi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;


    @RequestMapping("selectByPage")
    @ResponseBody
    public Map selectByPage(String stuName, int page, int rows) {
        return service.selectByPage(stuName,page,rows);
    }

    @RequestMapping("updateStudent")
    @ResponseBody
    public boolean updateStudent(Student student) {

        try {
            service.updateStudent(student);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @RequestMapping("deleteIds")
    @ResponseBody
    public boolean deleteIds(int[] ids) {
        try {
            service.multiDeleteStudent(ids);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
