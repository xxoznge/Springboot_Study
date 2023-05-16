package com.example.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //JSON 반환
public class HelloController {

    @GetMapping("/hello") // GET 요청을 받을 수 있는 API 만들기
    public String hello(){
        return "hello";
    }
}
