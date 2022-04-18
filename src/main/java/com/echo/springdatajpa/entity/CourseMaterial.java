package com.echo.springdatajpa.entity;

import lombok.*;

import javax.persistence.*;


// course material cant exist without course
@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString(exclude = "course")
@Entity
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "courseMaterial_sequence",
            sequenceName = "courseMaterial_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "courseMaterial_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "course_id",                 // column name of the foreign key, it will denote the course Id
            referencedColumnName = "courseId"   // which column/property in the Course class it is referencing to
    )
    private Course course;
}
