package com.API.examregister.Services;

import org.springframework.stereotype.Service;

import com.API.examregister.Dto.STDDto;
import com.API.examregister.Entites.Exam;
import com.API.examregister.Entites.Student;
import com.API.examregister.Entites.Subject;
import com.API.examregister.Repositories.StudentRepository;
import com.API.examregister.Repositories.SubjectRepository;

import jakarta.security.auth.message.callback.PrivateKeyCallback.SubjectKeyIDRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectService subjectService;

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("the id does not exists in the database"));
    }

    public Student createStudent(STDDto name) {
       //check if the student with the same name does not exists
       if(!studentRepository.existsByname(name.getName()))
       {
          throw new IllegalArgumentException( "the name already exists in the database");
       }
       //if not exists
       //create the new student object and save it
       Student student=new Student();
       student.setEnrolledSubjects(null);
       student.setName(name.getName());
       student.setEnrolledSubjects(null);
       return studentRepository.save(student);
    }

    public Student RegisterStudentInsubject(Long studentid, Long subjectid) {
       //verify the student id 
       Student student=getStudentById(studentid);
       //verify the subject id
       Subject subject=subjectService.getSubjectById(subjectid);
       if(student.getEnrolledSubjects().contains(subject))
       {
        throw new IllegalArgumentException("subject is already enrolled to the student");
       }
       else
       {
        student.getEnrolledSubjects().add(subject);
        subject.getStudents().add(student);
       }
       return studentRepository.save(student);
    }
    
}
