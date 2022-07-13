package com.spring.webmvc.springmvc.chap02.controller;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import com.spring.webmvc.springmvc.chap02.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreRepository repository;

//    @Autowired
//    public ScoreController(ScoreRepository repository) {
//        this.repository = repository;
//    }

    // 점수 등록 및 조회 화면 열기 요청
    @RequestMapping("/score/list")
    public String list(Model model) {
        log.info("/score/list GET 요청!!");
        // jsp에게 점수 정보 리스트를 전달해야 함.
        List<Score> scoreList = repository.findAll();
        // scores = 키 scoreList = 벨류
        model.addAttribute("scores", scoreList);
        return "chap02/score-list";
    }

    // 점수 신규 등록 요청
    @RequestMapping("/score/register")
    public String register(Score score) {
        score.calcTotalAndAvg();
        score.calcGrade();
        log.info("/score/register POST! - " + score);

        // 실패하면 홈으로 // redirect 로 다시끌고와야됌
        return repository.save(score) ? "redirect:/score-list" : "redirect:/";
    } //chap02/score-list

    // 디테일 ?
    @RequestMapping("/score/detail")
    public String detail(Score score) {
        
        return "chap02/score-detail";
    }
}
