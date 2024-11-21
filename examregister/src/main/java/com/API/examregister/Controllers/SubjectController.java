package com.API.examregister.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API.examregister.Entites.Exam;
import com.API.examregister.Entites.Subject;
import com.API.examregister.Services.SubjectService;

@RestController
@RequestMapping("api/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    
    @GetMapping
    public List<Subject> getAllSubjects()
    {
      return subjectService.getAllsubjects();   
    }

    @GetMapping("{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable("id") Long id)
    {
      Subject subject= subjectService.getSubjectById(id);
      return ResponseEntity.ok(subject);   
    }
    //here we write the name of the subject and then we create the subject object with it
    @PostMapping
    public Subject createSubject(@RequestBody String name)
    {
        return subjectService.createSubject(name);
    }
}
