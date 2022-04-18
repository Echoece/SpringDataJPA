package com.echo.springdatajpa.repository;

import com.echo.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String firstName);
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String guardianName);

    // JPQL query, ?1 means the first parameter
    @Query("SELECT s FROM Student s WHERE s.emailId = ?1")
    Student getStudentByEmailAddressV2(String email);

    // Same query with named parameter
    @Query("SELECT s FROM Student s WHERE s.emailId = :email")
    Student getStudentByEmailAddress(@Param("email") String email);

    // native SQL query
    @Query(
        value = "SELECT * FROM tbl_student s WHERE email_address = :email",
        nativeQuery = true
    )
    Student getStudentByEmailAddressNative(@Param("email") String email);

    // For DML operations (updating/delete etc)
    @Modifying
    @Transactional  // should be in the service layer, keeping it here for reference
    @Query(
        value = "UPDATE tbl_student SET first_name=?1 WHERE email_address=?2",
        nativeQuery = true
    )
    int updateStudentByEmailId(String firstName, String EmailID);




}
