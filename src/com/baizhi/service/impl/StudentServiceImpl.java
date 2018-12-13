package com.baizhi.service.impl;

import com.baizhi.dao.StudentDao;
import com.baizhi.entity.Student;
import com.baizhi.service.StudentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Map selectByPage(String stuName, int page, int rows) {
        Map map = new HashMap();

        Page<Student> studentPage = new Page<>(page, rows);
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_delete",0);

        if (stuName != null && !"".equals(stuName)) {

            queryWrapper.like("stu_name", stuName);
        }
        IPage<Student> studentIPage = studentDao.selectPage(studentPage, queryWrapper);

        List<Student> records = studentIPage.getRecords();

        Integer integer = studentDao.selectCount(queryWrapper);

        map.put("rows", records);
        map.put("total", integer);

        return map;
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateById(student);
    }

    @Override
    public void multiDeleteStudent(int[] arr) {
        studentDao.multiDeleteStudent(arr);
    }

}
