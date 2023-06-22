package com.springdatajpa.springdatajpa.repository;

import com.springdatajpa.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

     List<Student> findByFirstName(String firstName);
     List<Student> findByFirstNameContaining(String name);

     List<Student> findByLastNameNotNull();
     List<Student> findByGuardianName(String name);
     Student findByFirstNameAndLastName(String firstName,String lastName);
     //Query based on class and attributes using in class
     @Query("select s from Student s where s.emailId=?1")
     Student getStudentByEmailAddress(String EmailId);

     //JPQL Query
     @Query("select s.firstName from Student s where s.emailId=?1")
     String getStudentFirstNameByEmailAddress(String emailId);

     //Native SQL Query
     @Query(value = "SELECT * FROM tbl_student s where s.email_address=?1",
             nativeQuery = true)
     Student getStudentByEmailAddressNativeQuery(String email);

     @Query(value = "SELECT * FROM tbl_student s where s.email_address=:emailId",
             nativeQuery = true)
     Student getStudentByEmailAddressNativeQueryNamedParam(@Param("emailId")   String email);


     @Modifying//this method will modify the data in table or to modify table in DB
     @Transactional//Some transactional are performed on it and transactional are emitted back to database
     @Query(value = "UPDATE tbl_student set first_name = ?1 where email_address=?2",nativeQuery = true)
     int updateStudentNameByEmailId(String firstName,String emailId);

}
