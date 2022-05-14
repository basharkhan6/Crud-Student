package com.example.crud_student.web.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class UpdateStudentRequest {

    @NotNull
    private Long id;

    @NotBlank
    private String name;

}
