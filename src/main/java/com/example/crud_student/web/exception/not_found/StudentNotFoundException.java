package com.example.crud_student.web.exception.not_found;

public class StudentNotFoundException extends NotFoundException {

    public StudentNotFoundException() {
        super("Student not found!!!");
    }

    public StudentNotFoundException(Long id) {
        super(String.format("Student(%d) not found!!", id));
    }

    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
