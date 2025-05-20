package com.korit.springboot_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  요청 URL : /api/age 응답데이터 : {name : 김명규 , age" 27}
//  요청 URL : /api/names 응답데이터 : ["김명규","김일","김이"]
//  요청 URL : /api/students 응답데이터 : [{name : 김명규 , age" 27}, {name : 김일 , age" 32}]
//  요청 URL : /api/students2 응답데이터 :
/*
*
* [
*   {
*       name : 김명규,
*       age : 27,
*       hobby:[축구, 농구]
*   }...
* ]
* */
@RequestMapping("/api")
@RestController
public class HttpStudyController2 {

    @GetMapping("/age")
    public Map<String, ?> getInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","김명규");
        map.put("age",27);
        return map;
    }

    @GetMapping("/names")
    public List<String> getNames(){
        List<String> nameList = new ArrayList<>();
        nameList.add("김명규");
        nameList.add("조은별");
        nameList.add("김삼");

        return nameList;
    }

    @GetMapping("/students")
    public List<?> getStudents(){
        List<Map<String,Object>> studentsList = new ArrayList<>();
        Map<String,Object> infoMap =new HashMap<>();
        Map<String,Object> infoMap2 =new HashMap<>();
        
        infoMap.put("name","김명규");
        infoMap.put("age",27);
        infoMap2.put("name","조은별");
        infoMap2.put("age",21);

        studentsList.add(infoMap);
        studentsList.add(infoMap2);

        return studentsList;
    }

    @GetMapping("/students2")
    public List<?> getStudents2(){
        List<Map<String,Object>> studentsList2 = new ArrayList<>();
        Map<String,Object> infoMap =new HashMap<>();
        List<String> hobby = new ArrayList<>();

        Map<String,Object> infoMap2 =new HashMap<>();
        List<String> hobby2 = new ArrayList<>();

        infoMap.put("name","김명규");
        infoMap.put("age",27);
        hobby.add("축구");
        hobby.add("농구");
        infoMap.put("hobby",hobby);

        infoMap2.put("name","조은별");
        infoMap2.put("age",21);
        hobby2.add("게임");
        hobby2.add("배드민턴");
        infoMap2.put("hobby",hobby2);

        studentsList2.add(infoMap);
        studentsList2.add(infoMap2);

        return studentsList2;
    }
}
