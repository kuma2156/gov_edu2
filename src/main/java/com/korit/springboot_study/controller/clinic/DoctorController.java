package com.korit.springboot_study.controller.clinic;

import com.korit.springboot_study.domain.dto.DoctorRegisterDto;
import com.korit.springboot_study.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DoctorController {

    private DoctorService doctorService;
    /*
    * {
    *       doctorName:
    *       departmentName:
    * }
    * */

    @PostMapping("/api/clinic/doctors")
    public ResponseEntity<?> register(@RequestBody DoctorRegisterDto registerDto) {
        doctorService.register(registerDto);
        return ResponseEntity.ok(null);
    }
}
