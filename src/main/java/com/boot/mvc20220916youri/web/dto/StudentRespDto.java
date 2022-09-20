package com.boot.mvc20220916youri.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder // 생성하기 편하려구
@Getter // jackson은 이게 없으면 에러남
@AllArgsConstructor
public class StudentRespDto {
    private int studentCode;
    private String studentName;
    private int studentYear;
    private String studentAddress;
    private String studentPhone;
}
