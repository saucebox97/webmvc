package com.spring.webmvc.springmvc.chap03.repository;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import com.spring.webmvc.springmvc.chap03.domain.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository // ??
@RequiredArgsConstructor
public class BoardRepositorylmpl implements BoardRepository{

    private final JdbcTemplate template;

    @Override
    public boolean save(Board board) {
        String sql = "INSERT INTO board (board_no, writer, title, content)" +
                "VALUES (seq_board.nextval, ?,?,?)";
        return template.update(sql, board.getWriter(), board.getTitle()
                , board.getContent()) == 1;
    }

    @Override
    public List<Board> findAll(String sort) {
        StringBuilder sql = new StringBuilder("SELECT * FROM board");
        // String달라고해서 String으로 바꾸고해야함
        return template.query(sql.toString(), new RowMapper<Board>() {

            @Override
            public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Board(rs);
            }
        });
    }

    @Override
    public Board findOne(int boardNo) {

        String sql = "SELECT * FROM board WHERE board_no=?";

        return template.queryForObject(sql, new RowMapper<Board>() {
            @Override
            public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Board(rs);
            }
        }, boardNo);
    }

    @Override
    public boolean remove(int boardNo) {
        String sql = "DELETE FROM board WHERE board_no=?";
        return template.update(sql, boardNo) == 1;
    }
}
