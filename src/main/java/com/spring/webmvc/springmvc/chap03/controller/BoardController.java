package com.spring.webmvc.springmvc.chap03.controller;

import com.spring.webmvc.springmvc.chap03.domain.Board;
import com.spring.webmvc.springmvc.chap03.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final BoardRepository repository;

    //화면
    @RequestMapping("/board/list")
    public String list(String sort, Model model) {
        log.info("/board/list GET 요청!!");
        List<Board> boardList = repository.findAll(sort);

        model.addAttribute("boards", boardList);
        return "chap03/board-list";
    }

    // 글 작성
    @RequestMapping("board/write")
    public String write() {
        log.info("/board/list write 요청!!");
        return "chap03/board-write";
    }

    // 글 신규 등록
    @RequestMapping("/board/register")
    public String register(Board board) {
        log.info("/board/list register 요청!! - {}", board);
        return repository.save(board) ? "redirect:/board/list" : "redirect:/";
    }

    // 글 삭제제
    @RequestMapping("/board/delete")
    public String delete(int boardNo) {
        log.info("/board/list delete 요청!!");
        return repository.remove(boardNo) ? "redirect:/board/list" : "redirect:/";
    }

    // 상세 조회 요청
    @RequestMapping("/board/content")
    public ModelAndView detail(int boardNo) {
        log.info("/board/list detail 요청!!");
        Board board = repository.findOne(boardNo);
        ModelAndView mv = new ModelAndView("chap03/board-content");
        log.info("board - {}", board);
        mv.addObject("b", board);

        return mv;
    }

}
