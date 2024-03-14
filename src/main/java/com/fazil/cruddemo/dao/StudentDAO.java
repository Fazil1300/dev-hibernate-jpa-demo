package com.fazil.cruddemo.dao;

import com.fazil.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student student);
    Student findByID(int id);
}
