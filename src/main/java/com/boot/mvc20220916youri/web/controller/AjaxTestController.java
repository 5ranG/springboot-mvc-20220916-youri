package com.boot.mvc20220916youri.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AjaxTestController {

    @GetMapping("/ajax/{id}")
    public String loadAjax1(@PathVariable int id){
        return "ajax/ajax" + id;
    }

}
