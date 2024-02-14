package com.joaovbrocchi.plataformaCursos.service;
import com.joaovbrocchi.plataformaCursos.entity.Instructor;
import com.joaovbrocchi.plataformaCursos.repository.InstructorRepository;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import  java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import org.mockito.BDDMockito.*;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;


@ExtendWith(MockitoExtension.class)
public class InstructorServiceTest {
    @Mock
    private InstructorRepository instructorRepository;
    @InjectMocks
    private InstructorService instructorService;

    private Instructor instructor;

    @BeforeEach
    void setup(){
        instructor = new Instructor("joao","Brocchi","email123@email.com");
    }

    @Test
    public void testGivenInstructor_whenCreatePerson_thenReturnPerson(){
        given(instructorRepository.save(instructor)).willReturn(instructor);

        Instructor savedInstructor = instructorService.saveInstructor(instructor);

        assertNotNull(savedInstructor);
        assertEquals("joao", savedInstructor.getFirstName());
    }


    @Test
    public void testSaveInstructor_SuccessfulSave() {
        // Configurar comportamento simulado do método checkIfInstructorExist
        given(instructorRepository.findById(any())).willReturn(Optional.empty());

        // Configurar comportamento simulado do método save
        given(instructorRepository.save(any(Instructor.class))).willReturn(instructor);

        Instructor savedInstructor = instructorService.saveInstructor(instructor);


        assertNotNull(savedInstructor);
        assertEquals(instructor.getId(), savedInstructor.getId());
        assertEquals(instructor.getFirstName(), savedInstructor.getFirstName());


        verify(instructorRepository).save(any(Instructor.class));
    }

    @Test
    public void testSaveInstructor_InstructorAlreadyExists() {
        // Configurar comportamento simulado do método checkIfInstructorExist
        given(instructorRepository.findById(any())).willReturn(Optional.of(new Instructor()));

        // Chamar o método saveInstructor e esperar que uma exceção seja lançada
        assertThrows(RuntimeException.class, () -> {
            instructorService.saveInstructor(instructor);
        });

        // Verificar que o método save do repositório nunca foi chamado
        verify(instructorRepository, never()).save(any(Instructor.class));
    }

    @Test
    public void testCheckIfInstructorExist_InstructorExists() {
        // Configurar comportamento simulado do método findById
        given(instructorRepository.findById(any())).willReturn(Optional.of(new Instructor()));

        // Chamar o método checkIfInstructorExist
        boolean instructorExists = instructorService.checkIfInstructorExist(instructor);

        // Verificar que o método retornou true
        assertTrue(instructorExists);
    }

    @Test
    public void testCheckIfInstructorExist_InstructorDoesNotExist() {
        // Configurar comportamento simulado do método findById
        given(instructorRepository.findById(any())).willReturn(Optional.empty());

        // Chamar o método checkIfInstructorExist
        boolean instructorExists = instructorService.checkIfInstructorExist(instructor);

        // Verificar que o método retornou false
        assertFalse(instructorExists);
    }

}
