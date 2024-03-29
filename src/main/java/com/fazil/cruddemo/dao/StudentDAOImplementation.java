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

    @Override
    public List<Student> findByLastName(String lastName) {
        //create query
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student WHERE lastName=:theLastName", Student.class);

        //set query parameter
        typedQuery.setParameter("theLastName", lastName);

        //get result from the query
        List<Student> students = typedQuery.getResultList();

        //return the list
        return students;
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        try {
            Student student = entityManager.find(Student.class, id);
            entityManager.remove(student);
        } catch (Exception e) {
            System.out.println("Record of " + id + " was not found");
        }

    }

    @Override
    @Transactional
    public int deleteAllStudentsRecords() {
        //create query
        int numberOfRecordDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        //return number of record deleted count
        return numberOfRecordDeleted;
    }
}