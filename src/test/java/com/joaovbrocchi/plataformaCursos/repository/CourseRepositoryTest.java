//package com.joaovbrocchi.plataformaCursos.repository;
//
//import com.joaovbrocchi.plataformaCursos.entity.Course;
//import com.joaovbrocchi.plataformaCursos.service.CourseServiceTest;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//@DataJpaTest
//public class CourseRepositoryTest {
//
//    @Mock
//    private CourseRepository repositoryMock;
//
//    @InjectMocks
//    private CourseServiceTest service;
//
//    @DisplayName("testa o salvamento ")
//    @Test
//    void testGivenCourse_whenSaving_ThenReturnCourse(){
//        Course course = new Course("oi");
//
//        // Configurar o comportamento do mock
//        when(repositoryMock.save(course)).thenReturn(new Course("oi")); // Supondo que seu construtor inclua o nome e o ID
//
////        Course cursoSalvo = service.save(course);
//
//        assertNotNull(cursoSalvo);
//        assertEquals(1L, cursoSalvo.getId());
//    }
//}
