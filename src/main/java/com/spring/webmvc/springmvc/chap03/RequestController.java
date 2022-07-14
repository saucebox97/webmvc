package com.spring.webmvc.springmvc.chap03;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
public class RequestController {
// post = 등록의의미 get = 가져오는 의미 가 있기떄문에 이런 조건을 걸어줘야됀다
    @RequestMapping(value = "/req/hello", method = RequestMethod.POST)
    @ResponseBody
    public String hello() {
        log.info("/req/hello 요청!!");
        return "hello!!!";
    }

//    @RequestMapping(value = "/req/bye", method = RequestMethod.GET)
    @GetMapping("/req/bye") // 위에 코드와 같다(줄여쓸수있다)
    @ResponseBody
    public String bye() {
        log.info("/req/bte GET 요청!!");
        return "bye!!!";
    }

    // URL에서 파라미터 열기 // /로 받아오는것 // 주소창으로 접근하는건 Get Post는 안됌
    @GetMapping("/member/{un}") // {userName} = 식별자 // 식별자이름은 내가짓는거
    @ResponseBody // 클라이언트에게 직접 데이터 응답 @PathVariable 를쓰면 경로 받아옴
    public String member(@PathVariable("un") String userName) {
        return "I am " + userName ;
    }

}
