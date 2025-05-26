package com.korit.springboot_study.repository;

import com.korit.springboot_study.domain.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> {
    
}
