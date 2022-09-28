package com.boot.mvc20220916youri.web.controller.api;

import com.boot.mvc20220916youri.web.dto.AddNewReqDto;
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
    public ResponseEntity<?> addNews(AddNewReqDto addNewReqDto) {

        log.info("{}", addNewReqDto);

    Map<String, Object> map = new HashMap<String, Object>();
    map.put("title", addNewReqDto.getTitle());
    map.put("broadcastingName", addNewReqDto.getBroadcastingName());
    map.put("content", addNewReqDto.getContent());

    List<String> fileNameList = new ArrayList<String>();
    addNewReqDto.getFiles().forEach((file) -> {
        fileNameList.add(file.getOriginalFilename()); //업로드되는 파일 이름 적어준다.
    });
    map.put("fileNames", fileNameList);

        return ResponseEntity.ok(new CMRespDto<>(1, "뉴스등록완료", map));
    }

}