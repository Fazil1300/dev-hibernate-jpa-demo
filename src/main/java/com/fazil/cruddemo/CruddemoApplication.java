package com.fazil.cruddemo;

import com.fazil.cruddemo.dao.StudentDAO;
import com.fazil.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {
    public StudentDAO studentDAO;

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            //savingSingleStudent(studentDAO);
            savingMultipleStudent(studentDAO);
        };
    }

    private void savingMultipleStudent(StudentDAO studentDAO) {
        //Creating multiple student objects
        System.out.println("Creating Multiple Student Objects");
        Student tempStudent1 = new Student("Taylor", "Swift", "taylor@gmail.com");
        Student tempStudent2 = new Student("Harry", "Styles", "harry@gmail.com");
        Student tempStudent3 = new Student("Ed", "Sheeran", "Edsheeran@gmail.com");

        //Saving a student objects
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

        //Display id of the inserted student objects and display record
        System.out.println("Student Id : " + tempStudent1.getId());
        System.out.println(tempStudent1);

        System.out.println("Student Id : " + tempStudent2.getId());
        System.out.println(tempStudent2);

        System.out.println("Student Id : " + tempStudent3.getId());
        System.out.println(tempStudent3);

        //Display successful message
        System.out.println("Multiple objects saved successfully");
    }

    private void savingSingleStudent(StudentDAO studentDAO) {
        //Creating student object
        Student tempStudent = new Student("Mohamed", "Fazil", "fazil@gmail.com");

        //Saving a student object
        studentDAO.save(tempStudent);

        //Display id of the inserted student object
        System.out.println("Student Id : " + tempStudent.getId());

        //Display student object
        System.out.println(tempStudent);

    }
}
