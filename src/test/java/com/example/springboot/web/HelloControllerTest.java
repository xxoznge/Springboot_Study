package com.example.springboot.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = HelloController.class)

public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈 주입
    private MockMvc mvc; // 웹 API 테스트 시 사용

    @Test
    public void hello가_리턴된다() throws Exception{

        String hello = "hello";

        mvc.perform(get("/hello")) // /hello 주소 HTTP GET 요청
                .andExpect(status().isOk())  // 결과 검증 -> 200인지 아닌지
                .andExpect(content().string(hello)); // 본문의 내용 검증 -> hello 값이 맞는지
    }
}