package com.boot.mvc20220916youri.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller //콘트롤러는 이걸 꼭 달아줘야함
public class PageController {
    
    @GetMapping({"/", "/index"}) //둘 중 하나로 선택하면 아래꺼가 실행된다
    public String loadIndex(Model model){
        model.addAttribute("name","김준일");

        return "index";
    }

    @GetMapping("/helloboot")
    public String loadHelloBoot(Model model){
        model.addAttribute("nowDate", LocalDateTime.now());
        return "hello";
    }

    @GetMapping("/myinfo")
    public String loadMyInfo(Model model){
        model.addAttribute("name","오유리");
        model.addAttribute("age","99");
        model.addAttribute("phone","010-1234-5678");
        model.addAttribute("address","부산 동래구 사직동");
        return "myinfo";
    }
}
