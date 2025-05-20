package com.korit.springboot_study.controller;

import com.korit.springboot_study.dto.Address;
import com.korit.springboot_study.dto.PostData;
import com.korit.springboot_study.dto.Student;
import com.korit.springboot_study.dto.param.SearchStudyDto;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class HttpStudyController3 {

    /* get
        주소에 값을 입력한다.
        파라미터를 통해 값을 입력한다.
        파라미터는 주소의 ? 뒤에 따라오는 key value 값을 의미한다.
        http://localhost:8080/api/~~~?파라미터(여러개의 데이터를 요청시 &로 구분)
    */
    @GetMapping("/study/get")
    public String get(@RequestParam String name,
                      @RequestParam Integer age
    ) {

        return "get 요청입니다.";
    }
    /* post @RequestBody 값을 받을 때 써야한다!!
        가능한 json으로 값을 입력한다.
        "{
            "key1": "value1",
            "key2": "value2",
            "key3": {
                key4: value3,
                key5: ["a", "b", "c", "d"]
            }
        }"
    */
    @PostMapping("/study/post")
    public String post(@RequestBody Map<String, Object> data) {
        System.out.println(data);
        System.out.println(data.get("age"));
        System.out.println(data.get("address"));

        Object data2 = data.get("address");
        Map<String, Object> map = (Map<String, Object>) data2;
        Object data3 = map.get("address4");
        List<String> list = (List<String>) data3;
        System.out.println(list);

        System.out.println(((Map<String, Object>) data.get("address")).get("address4"));
        return "post 요청입니다.";
    }

    // post1 와 다르게 다운캐스팅을 하지 않고 하는 방식
    @PostMapping("/study/post2")
    public String post2(@RequestBody PostData postData) {
        System.out.println(postData);
        System.out.println("postData.getAddress() :" + postData.getAddress());
        Address address = postData.getAddress();
        System.out.println("Address address = postData.getAddress();\n address :" + address);
        return "post2 요청입니다.";
    }

    /*
        Class Student {name, age}

        get 요청
        /api/study/students
        응답: [{Student객체1},{Student객체2},{Student객체3}]
        post 요청
        /api/students
        응답: {status: "성공", data: {Student객체2}}
    * */

    @GetMapping("/study/students")
    public List<?> getStudent(SearchStudyDto searchStudyDto) {
//        List<Student> students = List.of(
//                new Student("김명규",27),
//                new Student("조은별",21),
//                new Student("김승우",28),
//                new Student("이준석",40)
//        );
        List<Student> students = new ArrayList<>();
        Random random = new Random();
        int startCode = 0xAC00; // 가
        int endCode = 0xD7A3;   // 힇



        for (int i = 0 ; i < 1000; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append((char)(startCode + random.nextInt(endCode - startCode + 1)));
            builder.append((char)(startCode + random.nextInt(endCode - startCode + 1)));
            builder.append((char)(startCode + random.nextInt(endCode - startCode + 1)));
            students.add(new Student(builder.toString(), random.nextInt(100) + 1));
        }

        if (searchStudyDto.getPage() < 1) {
            searchStudyDto.setPage(1);
        }
        /*
            page = 1 -> 0 index
            page = 2 -> 10 index
            page = 3 -> 20 index
        * */

        System.out.println(searchStudyDto.getSearchValue());
        List<Student> foundStudent = students;
        if (searchStudyDto.getSearchValue() != null && !searchStudyDto.getSearchValue().isBlank()) {
            System.out.println("검색 결과 O");
            foundStudent = students.stream().filter(student -> student.getName().contains(searchStudyDto.getSearchValue())).collect(Collectors.toList());
        }
        else {System.out.println("검색 결과 없음");}

        int startIndex = (searchStudyDto.getPage() - 1) * searchStudyDto.getCount() ;
        List<Student> newStudent = new ArrayList<>();
        if (foundStudent.size() < startIndex) {
            startIndex = 0;
        }
        for (int i = 0; i < (foundStudent.size() < searchStudyDto.getCount() ? foundStudent.size() : searchStudyDto.getCount()); i++) {
            try {
            newStudent.add(foundStudent.get(startIndex + i));
            } catch (Exception e) {
                break;
            }
        }


        return newStudent;
    }

    @PostMapping("/study/students")
    public Map<String,?> postStudent(@RequestBody List<Student> studentList) {
        Map<String, Object> map = new HashMap<>();
        String status = studentList != null ? "성공" : "실패";
        map.put("status",status);
        map.put("data",studentList);
        return map;
    }

    /* put 수정하기
        json으로 값을 입력한다.
    */
    @PutMapping("/study/put")
    public String put() {
        return "put 요청입니다.";
    }
    /* delete 삭제하기
        경로에 값을 입력한다.
        api/study/delete/book/10
    */
    @DeleteMapping("/study/delete/{category}/{id}")
    public String delete(@PathVariable String category, @PathVariable Long id) {
        return "delete 요청입니다.";
    }
}
