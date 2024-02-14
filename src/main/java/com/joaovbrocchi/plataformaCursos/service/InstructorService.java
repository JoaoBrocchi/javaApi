package com.joaovbrocchi.plataformaCursos.service;

import com.joaovbrocchi.plataformaCursos.entity.Instructor;
import com.joaovbrocchi.plataformaCursos.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;




    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Optional<Instructor> getInstructorById(int instructorId) {
        return instructorRepository.findById(instructorId);
    }

    public Instructor saveInstructor(Instructor instructor) {
        if (!checkIfInstructorExist(instructor)) {
            return instructorRepository.save(instructor);
        } else {
            throw new RuntimeException("Já existe esse instrutor");
        }
    }
    public boolean checkIfInstructorExist(Instructor instructor) {
        return instructorRepository.findById(instructor.getId()).isPresent();
    }



    public void deleteInstructor(int instructorId) {
        instructorRepository.deleteById(instructorId);
    }


    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }
}
