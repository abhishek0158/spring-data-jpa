package com.springdatajpa.springdatajpa.repository;

import com.springdatajpa.springdatajpa.entity.Guardian;
import com.springdatajpa.springdatajpa.entity.Student;
import org.apache.catalina.LifecycleState;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student=Student.builder()
                .emailId("abhishek@gmail.com")
                .firstName("abhishek")
                .lastName("gowlikar")
              //  .guardianName("Raj")
             //   .guardianEmail("raj@gmail.com")
               // .guardianMobile("1234567890")
         .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian=Guardian.builder()
                .email("abhi@gmail.com")
                .name("abhi")
                .mobile("012345678")
                .build();

        Student student=Student.builder()
                .firstName("shivam")
                .emailId("shivam@gmail.com")
                .lastName("raj")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList=studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> studentList=studentRepository.findByFirstName("abhishek");
        System.out.println(studentList);
    }

    @Test
    public void printStudentContainingFirstName(){
        List<Student> studentList=studentRepository.findByFirstNameContaining("abhi");
        System.out.println(studentList);
    }
    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> studentList=studentRepository.findByGuardianName("Raj");
        System.out.println(studentList);
    }
    @Test
    public void printStudentBasedOnFirstNameAndLastName(){
        Student student=studentRepository.findByFirstNameAndLastName("abhishek","gowlikar");
        System.out.println(student);
    }
    @Test
    public void printStudentBasedOnEmailIdUsingMyQuery(){
        Student student=studentRepository.getStudentByEmailAddress("abhishek@gmail.com");
        System.out.println("student = " + student);
    }
    @Test
    public void printStudentFirstNameFormEmailAddress(){
        String student=studentRepository.getStudentFirstNameByEmailAddress("abhishek@gmail.com");
        System.out.println("student = " + student);
    }
    
    @Test
    public void printStudentByEmailAddressNativeQuery(){
        Student student=studentRepository.getStudentByEmailAddressNativeQuery("abhishek@gmail.com");
        System.out.println("student = " + student);
    }
    @Test
    public void testGetStudentByEmailAddressNativeQueryNamedParam(){
        Student student=studentRepository.getStudentByEmailAddressNativeQueryNamedParam("abhishek@gmail.com");
        System.out.println("student = " + student);
    }
    @Test
    public void updateFirstName(){
        int i=studentRepository.updateStudentNameByEmailId("Abhishek","abhishek@gmail.com");
        System.out.println("i = " + i);
    }
}