package com.boot.mvc20220916youri.web.controller.api;

import com.boot.mvc20220916youri.web.dto.AddNewsReqDto;
import com.boot.mvc20220916youri.web.dto.CMRespDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class NewsController {
    @PostMapping("/api/news")
    public ResponseEntity<?> addNews(AddNewsReqDto addNewsReqDto) {

        log.info("{}", addNewsReqDto);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", addNewsReqDto.getTitle());
        map.put("broadcastingName", addNewsReqDto.getBroadcastingName());
        map.put("content", addNewsReqDto.getContent());

        List<String> fileNameList = new ArrayList<String>();
        addNewsReqDto.getFiles().forEach((file) -> {
            fileNameList.add(file.getOriginalFilename());
        });
        map.put("files", fileNameList);

        return ResponseEntity.ok(new CMRespDto<>(1, "뉴스등록완료", map));
    }

}