package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScoreMapper {

    // 점수 저장
    boolean save(Score score);

    // 전체 점수 정보 조회
    List<Score> findAll(String sort);

    // 개별 점수 조회
    Score findOne(int stuNum);

    // 점수 정보 삭제
    boolean remove(int stuNum);

}
