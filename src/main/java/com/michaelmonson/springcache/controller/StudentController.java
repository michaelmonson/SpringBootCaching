
package com.michaelmonson.springcache.controller;

import com.michaelmonson.springcache.domain.Student;
import com.michaelmonson.springcache.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Student Controller", description = "Allows Students to be added, updated, and removed from the system.  Currently the system does not persist student data permanently.")
@RestController
@RequestMapping("/student")
//@Api(tags = "Student Controller")
public class StudentController {

    @Autowired
    StudentService studentService;


    /**
     * Add a student to our school.
     *
     * @param student represents a specific student with contact information
     * @return student object with a generated ID
     */
    @Operation(summary = "Add Student Record", description = "Add a new student and associated information.  A new ID will be added to the student record.")
    @PostMapping("")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @Operation(summary = "Update Student by ID", description = "Update the specified student.")
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        return studentService.updateStudent(student, id);
    }

    /**
     * Get back a student by the specified student ID.
     *
     * @param id Student ID
     * @return the student specified by the ID
     */
    @Operation(summary = "Get Student by ID", description = "Return the student data by the specified ID.  Contact information is also returned.")
    @GetMapping("/{id}")
    public Student findStudentById(@PathVariable Long id) {
        System.out.println("Searching by ID  : " + id);

        return studentService.getStudentByID(id);
    }

    @Operation(summary = "Delete Student by ID", description = "Delete a student by the specified student ID.")
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        System.out.println("Deleting Student Entity for ID: " + id);
        studentService.deleteStudent(id);
    }

    /**
     *  Requests a list of all students currently in cache.
     *
     *  @return List of Students currently residing in memory cache
     */
    @Operation(summary = "Return a list of all Students", description = "Returns all students stored in our cache.")
    @GetMapping("")
    public List<Student> getAllStudents() {
        return studentService.getStudents();
    }
}