package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLOutput;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // 의존성 주입을 테스트각인에서 사용 가능
class ScoreRepositoryImplTest {

    @Autowired
    ScoreRepository repository;

    @Test
    @DisplayName("점수 정보가 데이터베이스 테이블에 삽입되어야 한다")
    void saveTest() {
        Score s = new Score("우왁우", 88, 77, 99);
        boolean result = repository.save(s);

        assertTrue(result);

    }

    @Test
    @DisplayName("특정 학번에 해당하는 점수 정보가 데이터베이스 테이블에서 삭제되어야 한다")
    @Transactional // 테스트할때 한번 지워보고 통과하면
    @Rollback // 이전 상태로 돌려놓는다
    void removeTest() {

        //given
        int stuNum = 1;

        //when
        boolean result = repository.remove(stuNum);

        //then
        assertTrue(result);

    }

    @Test
    @DisplayName("모든 점수 정보를 조회해야 한다.")
    void findAllTest() {

        List<Score> scoreList = repository.findAll("");

        scoreList.forEach(s -> System.out.println(s)); // iter써도됌

    }

    @Test
    @DisplayName("특정 점수 정보를 조회해야 한다.")
    void findOneTest() {

        Score score = repository.findOne(4);

        System.out.println(score);

        assertEquals("우왁이", score.getName());

    }

}