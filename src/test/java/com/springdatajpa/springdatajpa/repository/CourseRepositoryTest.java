package com.springdatajpa.springdatajpa.repository;

import com.springdatajpa.springdatajpa.entity.Course;
import com.springdatajpa.springdatajpa.entity.Student;
import com.springdatajpa.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
        @Autowired
        private CourseRepository courseRepository;
        
        @Test
        public void printCourse(){
            List<Course> courses=courseRepository.findAll();
            System.out.println("courses = " + courses);
        }
        @Test
        public void saveCourseWithTeacher(){
            Teacher teacher=Teacher.builder()
                    .firstName("Ram")
                    .lastName("Krishnan")
                    .build();
            Course course=Course.builder()
                    .title("Python")
                    .credit(4)
                    .teacher(teacher)
                    .build();

            courseRepository.save(course);
        }
        
        @Test
        public void findAllPagination(){
            Pageable firstPageWithThreeRecords=
                    PageRequest.of(0,3);
            Pageable secondPageWithTwoRecords=
                    PageRequest.of(1,2);
            List<Course> courses=courseRepository.findAll(secondPageWithTwoRecords).getContent();
            
            long totalElements=courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
            long totalPages=courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();
            System.out.println("totalPages = " + totalPages);
            System.out.println("totalElements = " + totalElements);
            courses.forEach((x)->{
                System.out.println("data = " + x);
            });
        }

        @Test
        public  void findAllSorting(){
            Pageable sortByTitle=PageRequest.of(0,2, Sort.by("title"));
            System.out.println("sortByTitle = " + sortByTitle);
            Pageable sortByCreditsDesc=PageRequest.of(0,2,Sort.by("credit").descending());
            System.out.println("sortByCreditsDesc = " + sortByCreditsDesc);
            Pageable sortByTitleDescAndCredit=PageRequest.of(0,
                    2,
                    Sort.by("title").descending().and(Sort.by("Credit")));
            List<Course> courses=courseRepository.findAll(sortByTitle).getContent();
            courses.forEach((x)->{
                System.out.println("x = " + x);
            });
            List<Course> courses1=courseRepository.findAll(sortByCreditsDesc).getContent();
            courses1.forEach((y)->{
                System.out.println("y = " + y);
            });
            List<Course> courses2=courseRepository.findAll(sortByTitleDescAndCredit).getContent();
            courses2.forEach((z)->{
                System.out.println("z = " + z);
            });
        }

        @Test
        public void saveCourseWithStudentAndTeacher(){
            Teacher teacher=Teacher.builder()
                    .firstName("Max")
                    .lastName("Fluz")
                    .build();
            Student student=Student.builder()
                    .firstName("veer")
                    .lastName("rajkumar")
                    .emailId("veer_r@gmail.com")
                    .build();
            Course course=Course.builder()
                    .title("AI")
                    .credit(3)
                    .teacher(teacher)
                    .students(List.of(student))
                    .build();
            courseRepository.save(course);
        }
}