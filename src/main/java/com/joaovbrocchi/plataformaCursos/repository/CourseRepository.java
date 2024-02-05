package com.joaovbrocchi.plataformaCursos.repository;

import com.joaovbrocchi.plataformaCursos.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CourseRepository extends JpaRepository<Course, Integer> {

}
