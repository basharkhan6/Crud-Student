package com.example.crud_student.web.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class CreateStudentRequest {

    @NotBlank
    private String name;

}
