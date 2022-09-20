package com.boot.mvc20220916youri.web.controller.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController// 이게 있으면 무조건 REST api이다.
@Slf4j // Logger LOGGER = LoggerFactory.getLogger(getClass());
// 로그를 남기는 라이브러리 sout 대신 이거씀
public class ResponseBodyController {

    @GetMapping("/api/text")
    public String textGetReq(@RequestParam String value, int num) {
        //파라미터로 받는 방법. 포스트맨으로 실시. @RequestParam 생략가능
        return "파라미터 값: " + value + ", " + num;
    }

    @PostMapping("/api/text")
    public String textPostReq(@RequestParam String name, int age) {
        log.info("name: {}, {}, {}, {}", name, age, name, age); //@Slf4j 가 있어서 log 쓸수있음
        log.info("age: {}", age);
        return "name: " + name + ", age: " + age;
    }

    @PutMapping("/api/text")
    public String textPutReq() {
        log.info("put Request!!");
        return "풋 요청에 대한 응답";
    }

    @DeleteMapping("/api/text")
    public String textDeleteReq() {
        return "Delete 요청에 대한 응답";
    }
}