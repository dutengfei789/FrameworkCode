package com.baizhi.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("ss_student")
public class Student {
    @TableId("stu_id")
    private int stuId;
    private String stuName;
    private int stuAge;
    private int stuGender;
    private int isDelete;

    public Student() {
    }

    public Student(int stuId, String stuName, int stuAge, int stuGender, int isDelete) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.stuGender = stuGender;
        this.isDelete = isDelete;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public int getStuGender() {
        return stuGender;
    }

    public void setStuGender(int stuGender) {
        this.stuGender = stuGender;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                ", stuGender=" + stuGender +
                ", isDelete=" + isDelete +
                '}';
    }
}
