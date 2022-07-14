package com.spring.webmvc.springmvc.chap02.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository // @컴퍼런스 개념 @conference
@RequiredArgsConstructor // final필드를 매개변수로 받아서 초기화해주는 생성자 선언
public class ScoreRepositoryImpl implements ScoreRepository{
    // final 붙이는 이유 의존객체를 변하게하지않기위해
    // 스프링 JDBC - JDBC Template : JDBC를 단순화
    private final JdbcTemplate template; // final를 쓰려면 초기화를해야됌

//    @Autowired(의존성) // 필요한 의존 객체의 “타입"에 해당하는 빈을 찾아 주입
//    public ScoreRepositoryImpl(JdbcTemplate template) {
//        this.template = template;
//    } // @RequiredArgsConstructor를 쓰면 이걸(생성자) 만들어줌

    @Override // nextval 1씩 증가를 시켜주는 코드 // 들어갈때 ''붙여서 들어감 예 : 'score'
    public boolean save(Score score) {
        String sql = "INSERT INTO tbl_score " +
                "VALUES (seq_tbl_score.nextval, ?,?,?,?,?,?,?)";
        // INSERT, UPDATE, DELETE는 템플릭의 updata() 메서드 활용
        return template.update(sql, score.getName(), score.getKor()
                , score.getEng(), score.getMath(), score.getTotal()
                , score.getAverage(), score.getGrade().toString()) == 1;
    }

    @Override
    public List<Score> findAll(String sort) {
        StringBuilder sql = new StringBuilder("SELECT * FROM tbl_score");

        switch(sort) {
            case "num":
                sql.append(" ORDER BY stu_num");
                break;
            case "name":
                sql.append(" ORDER BY stu_name");
                break;
            case "average":
                sql.append(" ORDER BY average DESC");
                break;
        }
        // SELECT문의 경우는 query()
//        return template.query(sql, new ScoreRowMapper());
        /* 클래스를 안만들어도 할수있음
        return template.query(sql, new RowMapper<Score>() {
            @Override // ResultSet에 값을 담아와서 score 객체에 저장 그리고 그것을 count만큼 반복
            public Score mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Score(rs);
            }
        });
         */
        return template.query(sql.toString(), (rs, rowNum) -> new Score(rs));
    }

    @Override
    public Score findOne(int stuNum) {

        String sql = "SELECT * FROM tbl_score WHERE stu_num=?";
        // 단일 건수 조회시 사용
//        return template.queryForObject(sql, new ScoreRowMapper(), stuNum);
        return template.queryForObject(sql, (rs, rowNum) -> new Score(rs), stuNum);
    }

    @Override
    public boolean remove(int stuNum) {
        String sql = "DELETE FROM tbl_score WHERE stu_num=?";
        return template.update(sql, stuNum) == 1;
    }
}
