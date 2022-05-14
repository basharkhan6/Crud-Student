package com.example.crud_student.service;

import com.example.crud_student.web.dto.CreateStudentRequest;
import com.example.crud_student.web.dto.UpdateStudentRequest;
import com.example.crud_student.web.exception.not_found.StudentNotFoundException;
import com.example.crud_student.persistance.model.Student;
import com.example.crud_student.persistance.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student find(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Page<Student> list(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    public Student create(CreateStudentRequest createRequest) {
        Student student = new Student();
        student.setName(createRequest.getName());
        return studentRepository.save(student);
    }

    public void update(Long id, UpdateStudentRequest updateRequest) {
        Student student = find(id);
        // update only necessary fields
        student.setName(updateRequest.getName());
        studentRepository.save(student);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

}
