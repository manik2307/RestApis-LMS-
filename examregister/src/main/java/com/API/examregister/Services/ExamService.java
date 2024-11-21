package com.API.examregister.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.API.examregister.Dto.StudentDto;
import com.API.examregister.Entites.Exam;
import com.API.examregister.Entites.Student;
import com.API.examregister.Entites.Subject;
import com.API.examregister.Repositories.ExamRepository;
import com.API.examregister.Repositories.StudentRepository;
import com.API.examregister.Repositories.SubjectRepository;
@Service
public class ExamService {
    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private SubjectRepository subjectrepository;

    @Autowired
    private StudentRepository studentRepository;
    
    public List<Exam> getAllExam() {
        return examRepository.findAll();
    }

    public Exam getExamById(Long id) {
        return examRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Id not found in the dataBase") );
    }

    public Exam createExam(Long id) {
         Subject subject = subjectrepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Subject ID not found in the database"));
        // Create the Exam object
        Exam exam = new Exam();
        exam.setSubject(subject); // Associate the subject
        exam.setStudents(new ArrayList<>()); // Initialize the student list as empty
        return examRepository.save(exam);
    }

    public void deleteexam(Long id) {
        Exam e=getExamById(id);
        examRepository.delete(e);
    }

    public Exam RegisterStudent(Long studentId, Long examId)
     {
       Student student = studentRepository.findById(studentId)
       .orElseThrow(() -> new IllegalArgumentException("Student ID not found in the database"));
      // Check if the student is enrolled in the subject for which the exam is being conducted
        if (!student.getEnrolledSubjects().contains(getExamById(examId).getSubject())) {
          throw new IllegalArgumentException("Student is not enrolled in the subject of this exam");
         }
      // If all checks pass, add the student to the exam's student list
        getExamById(examId).getStudents().add(student);
        student.getRegisteredExams().add(getExamById(examId));
         return examRepository.save(getExamById(examId));
     }
    
}
