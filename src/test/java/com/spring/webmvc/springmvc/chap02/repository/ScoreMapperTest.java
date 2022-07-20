package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ScoreMapperTest {

    @Autowired
    ScoreMapper mapper;

    @Test
    @DisplayName("등록한다")
    void saveTest() {
        {
            Score score = new Score();
            score.setName("홍길동");
            score.setKor(50);
            score.setEng(50);
            score.setMath(50);

            mapper.save(score);
        }
    }


}