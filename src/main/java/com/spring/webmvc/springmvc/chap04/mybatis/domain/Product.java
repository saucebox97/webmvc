package com.spring.webmvc.springmvc.chap04.mybatis.domain;


import lombok.*;

import java.util.Date;

@Setter @Getter @ToString
@NoArgsConstructor // 기본 생성자를 생성해줌
@AllArgsConstructor //
public class Product {

    private String serialNo;
    private String productName;
    private int price;
    private Date madeAt;
}
