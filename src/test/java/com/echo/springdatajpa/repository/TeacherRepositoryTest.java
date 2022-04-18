package com.echo.springdatajpa.repository;

import com.echo.springdatajpa.entity.Course;
import com.echo.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course courseDBA = Course.builder()
                .title("DB")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .title("Java")
                .credit(6)
                .build();

        Teacher teacher =
                Teacher.builder()
                        .firstName("Rahim")
                        .lastName("Khan")
                        //.courses(List.of(courseDBA,courseJava))
                        .build();

        teacherRepository.save(teacher);
    }

}
