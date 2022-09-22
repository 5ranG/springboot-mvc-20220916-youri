package com.boot.mvc20220916youri.web.controller.api;

import com.boot.mvc20220916youri.domain.User;
import com.boot.mvc20220916youri.repository.UserRepository;
import com.boot.mvc20220916youri.web.dto.UserAddReqDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j // 로그를 찍어야하니까?
@RestController
@RequestMapping("/api/v1")// 모든 요청 앞에 이게 붙는다.
public class UserRestController {

    @Autowired @Qualifier("a") //스프링 기능 중 하나. 필드에 사용된 예시
    private UserRepository userRepository; //생성자 생략가능

    @GetMapping("/users/{userCode}") 
    // @PathVariable를 이용하여 {} 경로를 변수로 선언
    public ResponseEntity<?> getUser(@PathVariable int userCode) {//userCode변수선언
        User user = userRepository.findUserByUserCode(userCode);
        //userRepository에 있는 findUserByUserCode({userCode})를 찾나?

        return ResponseEntity.ok().body(user);
        //body에 user값을 단순하게 출력한다.
    }


    @GetMapping("/users2/{userId}")
    public ResponseEntity<?> getUser(@PathVariable String userId) {
        //@RequestParam String 로 가지고 옴
        User user = userRepository.findUserByUserId(userId);
        //UserRepositoryImpl에 있는 함수를 사용

        return ResponseEntity.ok().body(user);
        //body에 비교한 값을 뱉는다.
    }

    @PostMapping("/user") //포스트맨
    public ResponseEntity<?> addUser(UserAddReqDto userAddReqDto) {
        int result = userRepository.save(userAddReqDto.toEntity());
        if(result == 0) {
            return ResponseEntity.internalServerError().body("데이터 오류(Server)");
        }
        return ResponseEntity.ok().body("사용자 추가 완료");
    }
}
