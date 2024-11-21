package com.API.examregister.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.API.examregister.Entites.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByname(String name);}