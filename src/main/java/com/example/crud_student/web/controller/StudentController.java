package com.example.crud_student.web.controller;

import com.example.crud_student.service.StudentService;
import com.example.crud_student.web.dto.CreateStudentRequest;
import com.example.crud_student.web.dto.UpdateStudentRequest;
import com.example.crud_student.persistance.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/students")
@CrossOrigin
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public Page<Student> list(@PageableDefault Pageable pageable) {
        return studentService.list(pageable);
    }

    @GetMapping("/{id}")
    public Student find(@PathVariable Long id) {
        return studentService.find(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateStudentRequest createRequest) {
        Student student = studentService.create(createRequest);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}")
                .buildAndExpand(student.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable Long id, @RequestBody @Valid UpdateStudentRequest updateRequest) {
        studentService.update(id, updateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }

}
