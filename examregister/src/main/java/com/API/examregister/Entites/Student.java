package com.API.examregister.Entites;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registrationId;

    private String name;

    @ManyToMany
    @JoinTable(name = "student_subjects",
               joinColumns = @JoinColumn(name = "student_id"),
               inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> enrolledSubjects;

    @ManyToMany
    @JoinTable(name = "student_exams",
               joinColumns = @JoinColumn(name = "student_id"),
               inverseJoinColumns = @JoinColumn(name = "exam_id"))
    private List<Exam> registeredExams;
}
