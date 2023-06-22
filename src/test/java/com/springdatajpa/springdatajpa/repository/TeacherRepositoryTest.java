package com.springdatajpa.springdatajpa.repository;

import com.springdatajpa.springdatajpa.entity.Course;
import com.springdatajpa.springdatajpa.entity.CourseMaterial;
import com.springdatajpa.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void insertIntoTeacher(){

        //Teacher 1
        //while inserting teacher 1 course material was optional =true (not mandatory)
//        Course course1=Course.builder()
//                .title("DSA in Java")
//                .credit(6)
//                .build();
//        Course course2=Course.builder()
//                .title("Java Programming")
//                .credit(3)
//                .build();
//        Teacher teacher=Teacher.builder()
//                .firstName("Sandeep")
//                .lastName("Jain")
//                .courses(List.of(course1,course2))
//                .build();
//
//        teacherRepository.save(teacher);

    //teacher 2
//        Course course=Course.builder()
//                .title("DSA Advance and CP")
//                .credit(8)
//                .build();
//        CourseMaterial courseMaterial=CourseMaterial.builder()
//                .url("www.striver.com")
//                .course(course)
//                .build();
//        courseMaterialRepository.save(courseMaterial);


//        System.out.println(List.of(courseRepository.findById(5L).get()));
//        Teacher teacher=Teacher.builder()
//                .firstName("Raj")
//                .lastName("Vikram")
//                .courses(List.of(courseRepository.findById(5L).get()))
//                .build();
//        teacherRepository.save(teacher);
    }
}