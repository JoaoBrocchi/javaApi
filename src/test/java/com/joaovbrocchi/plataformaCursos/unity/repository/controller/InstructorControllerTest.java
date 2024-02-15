package com.joaovbrocchi.plataformaCursos.unity.repository.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joaovbrocchi.plataformaCursos.entity.Instructor;
import com.joaovbrocchi.plataformaCursos.entity.Student;
import com.joaovbrocchi.plataformaCursos.service.InstructorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock.*;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest
public class InstructorControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    private InstructorService service;

    private Instructor instructor;

    @BeforeEach
    void setup() {
        instructor  = new Instructor("joao","Brocchi","email123@email.com");
    }

    @DisplayName("Testa a criação do instrutor")
    @Test
    void testGivenInstructor_whenCreate_ShouldReturnInstructor() throws Exception {
        // Supondo que 'service' e 'mockMvc' estão devidamente inicializados

        // Configurando o comportamento simulado do serviço
        given(service.saveInstructor(any(Instructor.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        // Realizando a solicitação HTTP para criar um instrutor
        ResultActions response = mockMvc.perform(post("/instructor")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(instructor)));

        // Verificando se a resposta está conforme o esperado (código de status HTTP 200 OK)
        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value(instructor.getFirstName()))
                .andExpect(jsonPath("$.lastName").value(instructor.getLastName()))
                .andExpect(jsonPath("$.email").value(instructor.getEmail()));

        // Verificando se o corpo da resposta contém os detalhes do instrutor criado
        // Você precisará implementar a lógica para verificar isso com base na estrutura do objeto de resposta
    }
    @DisplayName("Testa o findAll")
    @Test
    void testGivenInstructor_whenFindAll_ShouldReturnAListOfInstructors() throws Exception{

        List<Instructor> instructors = new ArrayList<>();
        instructors.add(instructor);
        instructors.add(new Instructor("lucas","Brocchi","email123@email.com"));

        given(service.findAll()).willReturn(instructors);

        ResultActions response = mockMvc.perform(get("/instructor"));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(instructors.size())));






    }
    @DisplayName("testa o find by Id")
    @Test
    void testGivenId_whenFindBy_shouldReturnInstrcutor(){

    }


}
