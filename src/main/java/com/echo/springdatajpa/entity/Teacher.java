package com.echo.springdatajpa.entity;

import lombok.*;

import javax.persistence.*;

@Builder @Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
public class Teacher {
    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long teacherId;
    private String firstName;
    private String lastName;

    // Using Many to one is recommended to use whenever possible, so commenting out this relationship.
    // Uni directional relationship is defined in the Course entity class.

    /*@OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private List<Course> courses;*/
}
