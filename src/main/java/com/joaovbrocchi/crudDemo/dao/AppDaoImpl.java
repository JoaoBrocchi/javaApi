package com.joaovbrocchi.crudDemo.dao;

import com.joaovbrocchi.crudDemo.entity.Course;
import com.joaovbrocchi.crudDemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDaoImpl implements  IAppDao{
    EntityManager entityManager;


    @Autowired
    public AppDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findByID(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void DeleteById(int id) {

        entityManager.remove(findByID(id));
    }

    @Override
    public List<Course> findCoursesByInstrcutorId(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor_id = :data", Course.class
        );
        query.setParameter("data", id);
        return query.getResultList();

    }

    @Override
    @Transactional
    public Instructor update(int id) {
        Instructor instructor =findByID(id);
        Instructor dbInstructor = entityManager.merge(instructor);
        return dbInstructor;
    }

    @Override
    public Course findCourseByIdJoinFecth(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from course c"
                        + "join fetch i.courses"
                        + "Join fetch c.reviews"
                        + "where c.id = :data"
                ,Course.class
        );
        query.setParameter("data", id);
        Course course = query.getSingleResult();
        return course;
    }

    @Override
    public Instructor findInstructorByIdJoinFecth(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from instructor i"
                + "join fetch i.courses"
                + "Join fetch i.instructorDetail"
                + "where i.id = :data"
                ,Instructor.class
        );
        query.setParameter("data", id);
        Instructor instructor = query.getSingleResult();
        return instructor;

    }
}
