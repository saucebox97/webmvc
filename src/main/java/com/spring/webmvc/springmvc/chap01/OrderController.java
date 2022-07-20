package com.spring.webmvc.springmvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

    // 주문 양식화면을 열어주는 요청처리
    @RequestMapping("/order-form")
    public String OrderForm() {
        return "chap/o-form";
    }

    // 주문 검증 요청처리
    @RequestMapping("/order-check")
    public String OrderCheck(Model model) {
        return "chap01/o-result";
    }
}
