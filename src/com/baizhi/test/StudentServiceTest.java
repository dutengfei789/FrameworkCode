package com.baizhi.test;

import com.baizhi.dao.StudentDao;
import com.baizhi.entity.Student;
import com.baizhi.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentServiceTest {

    @Autowired
    private StudentService service;

    @Test
    public void selectByPage() {
        Map map = service.selectByPage("张三", 1, 3);
        List<Student> list= (List<Student>) map.get("rows");
        list.forEach(System.out::println);
        int total= (int) map.get("total");
        System.out.println("total = " + total);
    }
}