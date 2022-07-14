package com.spring.webmvc.springmvc.chap03.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import com.spring.webmvc.springmvc.chap03.domain.Board;

import java.util.List;

public interface BoardRepository {

    // 글 저장
    boolean save(Board board);

    // 전체 정보 조회
    List<Board> findAll(String sort);

    // 개별 글 조회
    Board findOne(int stuNum);

    // 글 삭제
    boolean remove(int stuNum);

}
