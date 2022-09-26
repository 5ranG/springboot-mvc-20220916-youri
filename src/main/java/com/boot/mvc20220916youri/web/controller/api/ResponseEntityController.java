package com.boot.mvc20220916youri.web.controller.api;

import com.boot.mvc20220916youri.web.dto.CMRespDto;
import com.boot.mvc20220916youri.web.dto.StudentRespDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ResponseEntityController {
    @GetMapping("/api/v1/entity/data1")
    public ResponseEntity<?> getData(){
//        return new ResponseEntity<String>(HttpStatus.OK);
//        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
//        return new ResponseEntity<String>("ResponseEntity 응답", HttpStatus.INTERNAL_SERVER_ERROR);
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("test-token1", UUID.randomUUID().toString());
        headers.add("test-token2", UUID.randomUUID().toString());
        headers.add("test-token3", UUID.randomUUID().toString());
        return new ResponseEntity<String>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/v1/entity/data2")
    public ResponseEntity<?> getData2(){
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("test-token1", UUID.randomUUID().toString());
        headers.add("test-token2", UUID.randomUUID().toString());
        headers.add("test-token3", UUID.randomUUID().toString());
        return new ResponseEntity<String>("test", headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/api/v1/entity/data3")
    public ResponseEntity<?> getData3(){
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("test-token1", UUID.randomUUID().toString());
        headers.add("test-token2", UUID.randomUUID().toString());
        headers.add("test-token3", UUID.randomUUID().toString());
        return new ResponseEntity<>(new CMRespDto<>(1, "전송성공", "테스트데이터"),
                headers,
                HttpStatus.OK);
    }
    
    @GetMapping("/api/v1/entity/data5")
    public ResponseEntity<?> getData5() { //static이라서 new 안해두 된다
        HttpHeaders headers = new HttpHeaders();
        headers.add("token1", "aaaa1111");

        return ResponseEntity.ok()
                .headers(headers)
                .body(new CMRespDto<>(1, "전송성공", "테스트데이터"));
    }

    @GetMapping("/api/v1/test/students")
    public ResponseEntity<?> getData6(){
        HttpHeaders headers = new HttpHeaders();

        List<StudentRespDto> dtoList = new ArrayList<StudentRespDto>();
        dtoList.add(StudentRespDto.builder().studentCode(20220001).build());
        dtoList.add(StudentRespDto.builder().studentCode(20220002).build());
        dtoList.add(StudentRespDto.builder().studentCode(20220003).build());

        StringBuilder studentCodeList = new StringBuilder();
        for(StudentRespDto studentRespDto : dtoList){
            studentCodeList.append(studentRespDto.getStudentCode());
            studentCodeList.append(", ");
        }
        studentCodeList.delete(studentCodeList.length() - 2, studentCodeList.length());

        headers.add("student_code_list", studentCodeList.toString());

        /* 아래와 동일
        return new ResponseEntity<>(
                new CMRespDto<>(-1, "HTTP 메소드를 확인해주세요", studentCodeList),
                headers,
                HttpStatus.METHOD_NOT_ALLOWED
        );
         */

        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED)
                .headers(headers)
                .body(new CMRespDto<>(-1, "HTTP 메소드를 확인해주세요", studentCodeList));
    }
}

