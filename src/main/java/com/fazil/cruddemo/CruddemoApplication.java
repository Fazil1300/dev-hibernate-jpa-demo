package com.fazil.cruddemo;

import com.fazil.cruddemo.dao.StudentDAO;
import com.fazil.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
            //savingMultipleStudent(studentDAO);
            //retrieveStudentByID(studentDAO);
            //retrieveAllStudents(studentDAO);
            //retrieveStudentByLastName(studentDAO);
            updateStudent(studentDAO);
        };
    }

    private void updateStudent(StudentDAO studentDAO) {
        //retrieve student by primary key id
        int studentID = 1;
        Student student = studentDAO.findByID(studentID);

        //display student
        System.out.println("student of an id " + studentID + " is " + student);

        //set first name of a student object
        student.setFirstName("Jhonny");

        //update an student object
        studentDAO.update(student);
        System.out.println("Updated!!!");

        //display updated student object
        System.out.println("Updated Student : " + student);
    }

    private void retrieveStudentByLastName(StudentDAO studentDAO) {
        //get list of student object by last name
        String lastName = "Swift";
        List<Student> studentList = studentDAO.findByLastName(lastName);

        //display the list of students
        for (Student tempStudent : studentList) {
            System.out.println(tempStudent);
        }
    }

    private void retrieveAllStudents(StudentDAO studentDAO) {
        //get the list of students
        List<Student> studentList = studentDAO.findAll();

        //display the list of students
        for (Student tempStudent : studentList) {
            System.out.println(tempStudent);
        }
    }

    private void retrieveStudentByID(StudentDAO studentDAO) {
        //Create a student object
        Student student = new Student("Justin", "Bieber", "justin@gmail.com");

        //save a student object
        studentDAO.save(student);
        System.out.println("Record inserted successfully!!!");

        //Display ID of an inserted student ID
        int id = student.getId();
        System.out.println("Generated ID of an Inserted student object : " + id);

        //retrieve an student object by generated id
        Student tempStudent = studentDAO.findByID(id);

        //Display retrieved student object
        System.out.println(tempStudent);

        //display retrieved message
        System.out.println("Object retrieved successfully");
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
