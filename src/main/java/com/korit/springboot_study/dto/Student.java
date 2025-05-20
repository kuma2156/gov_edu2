package com.korit.springboot_study.dto;
/*
    Class Student {name, age}

    get 요청
    /api/students
    응답: [{Student객체1},{Student객체2},{Student객체3}]
    post 요청
    /api/students
    응답: {status: "성공", data: {Student객체2}}
* */

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Student {
    private String name;
    private Integer age;

}
