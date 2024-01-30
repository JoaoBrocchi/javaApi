package com.joaovbrocchi.crudDemo.dao;

import com.joaovbrocchi.crudDemo.entity.Course;
import com.joaovbrocchi.crudDemo.entity.Instructor;

import java.util.List;

public interface IAppDao {
    void save(Instructor instructor);
    Instructor findByID(int id);

    void DeleteById(int id);

    List<Course> findCoursesByInstrcutorId(int id);

    public Instructor findInstructorByIdJoinFecth(int id);

    public Instructor update(int id);

    public Course findCourseByIdJoinFecth(int id);
}
