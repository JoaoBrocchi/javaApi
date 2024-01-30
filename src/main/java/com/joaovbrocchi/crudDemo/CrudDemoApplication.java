package com.joaovbrocchi.crudDemo;

import com.joaovbrocchi.crudDemo.dao.IAppDao;
import com.joaovbrocchi.crudDemo.entity.Instructor;
import com.joaovbrocchi.crudDemo.entity.InstructorDetail;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(IAppDao appDao){
		return runner -> findInstructorById(appDao).toString();
	}

	public void createInstructor(IAppDao appDao){
		Instructor tempInstructor = new Instructor("chad", "derby", "lucas@gamil.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("banana maluca", "codar");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		appDao.save(tempInstructor);



	}

	public Instructor findInstructorById(IAppDao appDao){
		Instructor tempInstructor = appDao.findByID(1);
		return  tempInstructor;
	}
	public void findInstructorWithCourses(IAppDao appDao){
		int id =1;
		Instructor tempInstructor = appDao.findByID(id);
		tempInstructor.getCourses();
	}

}
