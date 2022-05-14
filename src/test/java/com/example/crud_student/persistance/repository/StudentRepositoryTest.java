package com.example.crud_student.persistance.repository;

import com.example.crud_student.persistance.model.Student;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DataJpaTest
@RequiredArgsConstructor
class StudentRepositoryTest {

    private final TestEntityManager entityManager;
    private final StudentRepository studentRepository;

    @Test
    void crud() throws Exception {
        String stdName = "Bash";
        Student student = new Student();
        student.setName(stdName);
        entityManager.persist(student);
        entityManager.flush();

        Optional<Student> result = studentRepository.findById(student.getId());
        assertTrue(result.isPresent());
        assertEquals(result.get().getName(), stdName);
    }

}