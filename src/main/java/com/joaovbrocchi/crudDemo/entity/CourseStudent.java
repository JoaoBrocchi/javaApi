package com.joaovbrocchi.crudDemo.entity;

import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name="course_student")
public class CourseStudent {


    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST
    },fetch = FetchType.LAZY
    )
    @JoinTable(
            name="course_student",
            joinColumns = @JoinColumn(name= "course_id"),
            inverseJoinColumns =@JoinColumn(name= "student_id")
    )
    private List<Student> students;
}
