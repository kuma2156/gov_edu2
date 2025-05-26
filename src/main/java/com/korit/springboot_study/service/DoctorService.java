package com.korit.springboot_study.service;


import com.korit.springboot_study.domain.dto.DoctorRegisterDto;
import com.korit.springboot_study.domain.entity.DepartmentEntity;
import com.korit.springboot_study.domain.entity.DoctorEntity;
import com.korit.springboot_study.repository.DepartmentRepository;
import com.korit.springboot_study.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DoctorService {

    private DoctorRepository doctorRepository;
    private DepartmentRepository departmentRepository;

    public void register(DoctorRegisterDto dto) {
        departmentRepository.findByDepartmentName(dto.getDepartmentName())
                .ifPresentOrElse(departmentEntity ->{
                    DoctorEntity entity = dto.toEntity();
                    entity.setDepartmentId(departmentEntity.getId());
                    doctorRepository.save(entity);
                },
                () -> {
                    DepartmentEntity department = DepartmentEntity.builder()
                            .departmentName(dto.getDepartmentName())
                            .build();
                    DepartmentEntity savedEntity = departmentRepository.save(department);
                    DoctorEntity entity = dto.toEntity();
                    entity.setDepartmentId(savedEntity.getId());
                    doctorRepository.save(entity);
                }
            );
        DoctorEntity doctorEntity = dto.toEntity();
        doctorRepository.save(doctorEntity);
    }
}
