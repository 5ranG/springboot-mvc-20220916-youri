package com.boot.mvc20220916youri.web.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class AddNewsReqDto {
    private String title;
    private String broadcastingName;
    private List<MultipartFile> files;
    private String content;
}
