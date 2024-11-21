package com.API.examregister.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.API.examregister.Entites.Exam;
@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {}