package com.joaovbrocchi.plataformaCursos.service;

import com.joaovbrocchi.plataformaCursos.entity.Instructor;
import com.joaovbrocchi.plataformaCursos.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Optional<Instructor> getInstructorById(int instructorId) {
        return instructorRepository.findById(instructorId);
    }

    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public void deleteInstructor(int instructorId) {
        instructorRepository.deleteById(instructorId);
    }


}
