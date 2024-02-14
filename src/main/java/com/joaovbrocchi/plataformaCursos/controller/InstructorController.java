package com.joaovbrocchi.plataformaCursos.controller;

import com.joaovbrocchi.plataformaCursos.entity.Instructor;
import com.joaovbrocchi.plataformaCursos.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
        Instructor createdInstructor = instructorService.saveInstructor(instructor);
        return new ResponseEntity<>(createdInstructor, HttpStatus.CREATED);
    }
    @GetMapping
    public List<Instructor> findAll(){
        return instructorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> findInstructorById(@PathVariable int id) {
        Optional<Instructor> instructorOptional = instructorService.getInstructorById(id);

        return instructorOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
