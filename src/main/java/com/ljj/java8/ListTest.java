package com.ljj.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: liujinjian
 * @Date: 2020/8/28 13:56
 */
public class ListTest {

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("你好");
        Student student2 = new Student();
        student2.setName("我是");
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);

        List<Teacher> teacherList = studentList.stream().map(student -> {
            Teacher teacher = new Teacher();
            teacher.setName(student.getName());
            return teacher;
        }).collect(Collectors.toList());
        System.out.println(teacherList);


    }
}
