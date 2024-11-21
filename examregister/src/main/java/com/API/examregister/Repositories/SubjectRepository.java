package com.API.examregister.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.API.examregister.Entites.Subject;
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    boolean existsByname(String name);
}