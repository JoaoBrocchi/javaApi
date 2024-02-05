package com.joaovbrocchi.plataformaCursos.service;

import com.joaovbrocchi.plataformaCursos.entity.Course;
import com.joaovbrocchi.plataformaCursos.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long courseId) {
        return courseRepository.findById(Math.toIntExact(courseId));
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(Math.toIntExact(courseId));
    }


}
