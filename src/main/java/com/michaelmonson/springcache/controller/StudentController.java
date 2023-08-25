
package com.michaelmonson.springcache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.michaelmonson.springcache.domain.Student;
import com.michaelmonson.springcache.service.StudentService;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    /**
     * Get back a student by the specified student ID.
     *
     * @param id Student ID
     * @return the student specified by the ID
     */
    @GetMapping("/student/{id}")
    public Student findStudentById(@PathVariable Long id) {
        System.out.println("Searching by ID  : " + id);

        return studentService.getStudentByID(id);
    }


    /**
     *  Requests a list of all students currently in cache.
     *
     *  @return List of Students currently residing in memory cache
     */
    @GetMapping("/student")
    public List<Student> getAllStudents() {
        return studentService.getStudents();
    }
}