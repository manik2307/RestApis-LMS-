package com.API.examregister.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.API.examregister.Dto.StudentDto;
import com.API.examregister.Entites.Exam;
import com.API.examregister.Services.ExamService;

@RestController
@RequestMapping("api/exams")
public class ExamController {
    @Autowired
    private ExamService examService;
//mapping for getting all the exams
    @GetMapping
    public List<Exam> getAllExams()
    {
      return examService.getAllExam();   
    }
//mapping for getting exam for specified exam id
    @GetMapping("/{id}")
    public ResponseEntity<Exam> getById(@PathVariable Long id)
    {
        return ResponseEntity.ok(examService.getExamById(id));
    }
//mapping for the creation of exam object by passing the subject id 
    @PostMapping("/{Subjectid}")
   public Exam CreateExam(@PathVariable Long Subjectid)
   {
       return examService.createExam(Subjectid);
   }
//in this we are passing exam id in path variable and student id in studentdto for registering the student to the exam
   @PostMapping("/{examid}/Students/{studentid}")
   public Exam RegisterExam(@PathVariable Long examid,@PathVariable("studentid") Long studentId)
   {
       return examService.RegisterStudent(studentId,examid);
   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteExam(@PathVariable Long id)
    {
       examService.deleteexam(id);
       return ResponseEntity.ok().build();
    }
}
