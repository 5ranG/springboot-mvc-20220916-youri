package com.boot.mvc20220916youri.web.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseDataDto {
    private String value1;
    private int value2;
    private boolean value3;
}
