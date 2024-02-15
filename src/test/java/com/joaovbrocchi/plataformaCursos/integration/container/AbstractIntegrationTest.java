package com.joaovbrocchi.plataformaCursos.integration.container;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.lifecycle.Startables;

import java.util.Map;
import java.util.stream.Stream;

@ContextConfiguration(initializers = AbstractIntegrationTest.Initializer.class)
public class AbstractIntegrationTest {
    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext>{

        static MySQLContainer<?> mysqlContainer = new MySQLContainer<>("mysql:8.0.28");


        private static void startContainers(){
            Startables.deepStart(Stream.of(mysqlContainer)).join();
        }

        private static Map<String, String> createConnectionConfig(){
            return Map.of(
                    "spring.datasource.url", mysqlContainer.getJdbcUrl(),
                    "spring.datasource.username", mysqlContainer.getUsername(),
                    "spring.datasource.password", mysqlContainer.getPassword()
            );
        }

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            startContainers();
            ConfigurableEnvironment environment = applicationContext.getEnvironment();
            MapPropertySource testContainers = new MapPropertySource(
                    "testContainers",
                    (Map) createConnectionConfig());
            environment.getPropertySources().addFirst(testContainers);

        }
    }
}
