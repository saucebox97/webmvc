package com.spring.webmvc.springmvc.chap03.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.sql.ResultSet;
import java.sql.SQLException;

@Setter @Getter @ToString @Log4j2
@NoArgsConstructor
public class Board {

    private int boardNo;
    private String content;
    private String writer; // 글쓴이
    private String title; // 제목
    //////////////////////////////////////
    private int viewCnt; // 조회수
    private String regDate; // 날짜

    public Board(int boardNo, String content, String writer, String title) {
        this.boardNo = boardNo;
        this.content = content;
        this.writer = writer;
        this.title = title;
    }

    public Board(ResultSet rs) throws SQLException {
        this.boardNo = rs.getInt("board_no");
        this.content = rs.getString("content");
        this.writer = rs.getString("writer");
        this.title = rs.getString("title");
        this.viewCnt = rs.getInt("view_cnt");
        this.regDate = rs.getString("reg_date");
    }
}
