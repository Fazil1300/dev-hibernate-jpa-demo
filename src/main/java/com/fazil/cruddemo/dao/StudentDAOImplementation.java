package com.fazil.cruddemo.dao;

import com.fazil.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
