package com.spring.webmvc.chap04.v3.controller;

import com.spring.webmvc.chap04.View;
// 컨트롤 알트 o 하면 안쓰는거 알아서 지워줌
import java.util.Map;

public interface ControllerV3 {

    /*
        @paramMap : 요청정보(쿼리 파라미터)를 모두 읽어서 맵에 담아줌.
        return
     */
    View process(Map<String, String> paramMap);
}