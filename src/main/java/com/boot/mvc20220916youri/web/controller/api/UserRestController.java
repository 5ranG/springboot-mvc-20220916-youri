package com.boot.mvc20220916youri.web.controller.api;

import com.boot.mvc20220916youri.domain.User;
import com.boot.mvc20220916youri.repository.UserRepository;
import com.boot.mvc20220916youri.web.dto.UserAddReqDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1") // 모든 요청 앞에 이게 붙는다.
@RequiredArgsConstructor
public class UserRestController {

//    @Autowired
//    @Qualifier("a")
//    private UserRepository userRepository;
    private final UserRepository userRepository;
    //@RequiredArgsConstructor이랑 fianl을 같이 쓰면

    @GetMapping("/users/{userCode}")
    public ResponseEntity<?> getUser(@PathVariable int userCode){
        // @PathVariable 로 가지고 옴

        User user = userRepository.findUserByUserCode(userCode);

        return ResponseEntity.ok().body(user);
    }


    @GetMapping("/users")
    public ResponseEntity<?> getUser(@RequestParam String userId){
        //@RequestParam String 로 가지고 옴
        User user = userRepository.findUserByUserId(userId);

        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/user")
    public ResponseEntity<?> addUser(UserAddReqDto userAddReqDto){
        int result = userRepository.save(userAddReqDto.toEntity());
        if(result == 0){
            return ResponseEntity.internalServerError().body("데이터 오류(Server)");
        }
        return ResponseEntity.ok().body("사용자 추가 완료");
    }

}
