package com.example.code_sd_thuvien.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private String account_Code;
    private String student_Name;
    private List<String> list_Role;



}
