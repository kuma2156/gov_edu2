package com.korit.springboot_study.mapper;

import com.korit.springboot_study.mapper.dto.Visit;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VisitMapper {
    int insert(Visit vist);

}
