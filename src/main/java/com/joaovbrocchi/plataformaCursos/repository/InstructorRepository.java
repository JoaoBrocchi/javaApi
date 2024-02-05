package com.joaovbrocchi.plataformaCursos.repository;

import com.joaovbrocchi.plataformaCursos.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {
}

