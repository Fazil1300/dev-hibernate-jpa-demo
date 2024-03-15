package com.fazil.cruddemo.dao;

import com.fazil.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findByID(int id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);
}
