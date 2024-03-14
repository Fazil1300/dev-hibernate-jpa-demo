package com.fazil.cruddemo.dao;

import com.fazil.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;

public class StudentDAOImplementation implements StudentDAO{
    private EntityManager entityManager;

    public StudentDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }
}
