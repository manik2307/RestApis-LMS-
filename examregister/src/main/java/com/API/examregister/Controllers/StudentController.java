package com.API.examregister.Controllers;

import com.API.examregister.Entites.Student;
import com.API.examregister.Dto.STDDto;
import com.API.examregister.Entites.Exam;
import com.API.examregister.Repositories.StudentRepository;
import com.API.examregister.Repositories.ExamRepository;
import com.API.examregister.Services.ExamService;
import com.API.examregister.Services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudent()
    {
      return studentService.getAllStudent();   
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id)
    {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public Student createStudent(@RequestBody STDDto Name)
    {
      return studentService.createStudent(Name);
    }
    //enrolling the student in the subject
    @PostMapping("/{studentid}/subjects/{subjectid}")
    public Student RegisterStudentInsubject(@PathVariable Long studentid,@PathVariable Long subjectid)
    {
        return studentService.RegisterStudentInsubject(studentid,subjectid);
    }
    }
