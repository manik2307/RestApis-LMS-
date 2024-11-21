package com.API.examregister.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.API.examregister.Entites.Subject;
import com.API.examregister.Repositories.SubjectRepository;
@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public Subject createSubject(String name) {
        //check if the subject with the same name is already there
        if(!subjectRepository.existsByname(name))
        {
            throw new IllegalArgumentException("Subject with the same name Alreday exists");
        }
        Subject subject=new Subject();
        subject.setName(name);
        subject.setStudents(null);
        return subjectRepository.save(subject);
    }

    public List<Subject> getAllsubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("the id does not exists in the database"));
    }
    
}
