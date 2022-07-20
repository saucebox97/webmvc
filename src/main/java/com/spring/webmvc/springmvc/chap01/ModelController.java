package com.spring.webmvc.springmvc.chap01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/model")
public class ModelController {

    // 유지보수 및 안정성
    private static class ModelURL {
        public static final String HOBBIES = "/hobbies";
        public static final String HOBBIES2 = "/hobbies2";
        public static final String FROM = "/form";
        public static final String CHECK = "/age-check";
    }

    //===== JSP파일로 포워딩할 떄 데이터 전달하기=====//
    //== 1. Model 객체 사용하기
    @RequestMapping("ModelURL.HOBBIES")
    public String hobbies(Model model) {

        List<String> hList = new ArrayList<>();
        hList.add("산책");
        hList.add("뛰어놀기");
        hList.add("밥먹기");
        hList.add("낮잠자기");
        // 멍멍이라는 데이터가 name 이라는 키값으로 날아감
        model.addAttribute("name", "멍멍이");
        model.addAttribute("hobbies", hList);

        // /WEB-INF/views/chap01/hobbies.jsp
        return "chap01/hobbies";
    }

    //== 2. ModelAndView 사용하기
    @RequestMapping("ModelURL.HOBBIES2")
    public ModelAndView hobbies2() {
        List<String> hList = new ArrayList<>();
        hList.add("영화보기");
        hList.add("맛집가기");

        ModelAndView mv = new ModelAndView("chap01/hobbies");
        mv.addObject("name", "짹짹이");
        mv.addObject("hobbies", hList);

        return mv;
    }

    // age-form 띄우기
    @RequestMapping("ModelURL.FORM")
    public String form() {
        return "chap01/age-form";
    }

    //==3. @ModelAttribute 사용

    // age데이터 처리 // model/age-check
    @RequestMapping(ModelURL.CHECK) // ModelAttribute를쓰면 64줄을 생략가능
    // ModelAttribute("age")에서 ("age")는 생략가능 뒤에 age 랑 이름이같다면
    public String check(@ModelAttribute("age") int age, Model model) {
        // 나이로 출생년도 구해주기 (한국나이)
        int birthYear = LocalDate.now().getYear() - age + 1;

        model.addAttribute("bYear", birthYear);
//        model.addAttribute("age", age);

        return "chap01/age-result";
    }


}
