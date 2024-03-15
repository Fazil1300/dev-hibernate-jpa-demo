package com.fazil.cruddemo.dao;

import com.fazil.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImplementation implements StudentDAO {
    private EntityManager entityManager;

    public StudentDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findByID(int id) {
        Student student = entityManager.find(Student.class, id);
        return student;
    }

    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student ORDER BY lastName desc", Student.class);

        //get result from the query
        List<Student> students = typedQuery.getResultList();

        //return the list
        return students;

    }
}
