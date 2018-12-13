package com.baizhi.service;


import com.baizhi.entity.Student;

import java.util.Map;


public interface StudentService {

    public Map selectByPage(String stuName, int page, int rows);

    void updateStudent(Student student);

    void multiDeleteStudent(int[] arr);
}
