package com.example.crud_student.persistance.repository;

import com.example.crud_student.persistance.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Page<Student> findAllByName(String name, Pageable pageable);

}
