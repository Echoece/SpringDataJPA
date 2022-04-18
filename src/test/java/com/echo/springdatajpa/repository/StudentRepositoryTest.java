package com.echo.springdatajpa.repository;

import com.echo.springdatajpa.entity.Guardian;
import com.echo.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest   // this test the jpa but wont flush the data. here using this one to check the database changes. Ideally we want to use the other one for testing
//@DataJpaTest    // this tests the jpa then once test is done it flushes the data
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("Echo@gmail.com")
                .firstName("Rafiqul")
                .lastName("Islam")
                /*.guardianName("Sazzad Hossain")
                .guardianEmail("Sazzad@gmail.com")
                .guardianMobile("+8801928333124")*/
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Molla Kader")
                .email("molla@gmail.com")
                .mobile("00125435667")
                .build();

        Student student = Student.builder()
                .firstName("Rahim")
                .lastName("Hasan")
                .emailId("Rahim@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void getStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Rafiqul");
        System.out.println(students);
    }

    @Test
    public void getStudentByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("Rafi");
        System.out.println(students);
    }

    @Test
    public void getStudentByGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Sazzad Hossain");
        System.out.println(students);
    }

    @Test
    public void updateStudentNameByEmailId(){
        studentRepository.updateStudentByEmailId(
                "Updated Name","Echo@gmail.com");

    }

    @Test
    public  void getAllStudent(){
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }
}
