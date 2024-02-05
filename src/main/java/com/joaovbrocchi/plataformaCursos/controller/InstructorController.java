package com.joaovbrocchi.plataformaCursos.controller;

import com.joaovbrocchi.plataformaCursos.entity.Instructor;
import com.joaovbrocchi.plataformaCursos.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    @Autowired
    private InstructorService instructorService;




    @GetMapping("/{id}")
    public ResponseEntity<Instructor> findInstructorById(@PathVariable int id) {
        Optional<Instructor> instructorOptional = instructorService.getInstructorById(id);

        return instructorOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
