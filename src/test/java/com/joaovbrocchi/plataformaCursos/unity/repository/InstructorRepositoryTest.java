package com.joaovbrocchi.plataformaCursos.unity.repository;

import com.joaovbrocchi.plataformaCursos.integration.container.AbstractIntegrationTest;
import com.joaovbrocchi.plataformaCursos.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class InstructorRepositoryTest extends AbstractIntegrationTest {
        @Autowired
        InstructorRepository instructorRepository;
}
