package com.boot.mvc20220916youri.web.controller.api;

import com.boot.mvc20220916youri.web.dto.AddPostReqDto;
import com.boot.mvc20220916youri.web.dto.CMRespDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class RequestTestController {

    @PostMapping("/api/v1/rp/post") //포스트맨에서 x-www-form 사용
    public ResponseEntity<?> addPost(@RequestParam String writer,
                                     @RequestParam String title,
                                     @RequestParam String content) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("writer", writer);
        map.put("title", title);
        map.put("content", content);

        return ResponseEntity.ok(new CMRespDto<>(1, "게시글 작성 완료", map));
    }

    @PostMapping("/api/v1/dto/post")
    public ResponseEntity<?> addPost(AddPostReqDto addPostReqDto) {
        log.info("{}", addPostReqDto);
        return ResponseEntity.ok(new CMRespDto<>(1, "게시글 작성 완료", addPostReqDto));
    }

    @PostMapping("/api/v1/file/post") //포스트맨에서 form-data 사용
    public ResponseEntity<?> addPost2(AddPostReqDto addPostReqDto) {
        log.info("{}", addPostReqDto);
        List<String> fileNames = new ArrayList<String>();

        String fileName1 = addPostReqDto.getFile().getOriginalFilename();
        fileNames.add(fileName1);

        if(addPostReqDto.getFiles() != null){

        String fileName2 = addPostReqDto.getFiles().get(0).getOriginalFilename(); //리스트
        String fileName3 = addPostReqDto.getFiles().get(1).getOriginalFilename(); //리스트

        fileNames.add(fileName2);
        fileNames.add(fileName3);
        }

        return ResponseEntity.ok(new CMRespDto<>(1, "게시글 작성 완료", fileNames));
        //application.yml 에 파일 크기 세팅해줘야함
    }

    @PostMapping("/api/v1/json/post") //포스트맨에서 json 사용
    //Json은 늘 @RequestBody가 따라와야한다
    public ResponseEntity<?> addPost3(@RequestBody AddPostReqDto addPostReqDto) {
        log.info("{}", addPostReqDto);

        return ResponseEntity.ok(new CMRespDto<>(1, "Json으로 게시글 작성 완료", addPostReqDto));
    }

    @DeleteMapping("/api/v1/post/{id}") //포스트맨에서 DELETE > Params 사용
    public ResponseEntity<?> deletePost(@PathVariable int id){
        log.info("삭제할 게시글 번호: ({})", id);
        return ResponseEntity.ok(new CMRespDto<>(1,"삭제 성공", id));
    }

}