package com.korit.springboot_study.dto.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
public class SearchStudyDto {
    private String searchValue;
    private Integer page = 1;
    private Integer count = 10;
}
