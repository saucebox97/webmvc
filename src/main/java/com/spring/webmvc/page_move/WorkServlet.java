package com.spring.webmvc.page_move;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/work")
public class WorkServlet extends HttpServlet {
// ser 하면 밑에 자동완성
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("work 요청이 들어옴!");
        // http 는 한번의 응답과요청이 일어나면 그다음은 까먹는다 기억을 잃음
        // 1. redirect : 재요청 (요청이 2번들어감) 갑자기 내 의지와상관없이 도박,피싱사이트에 들어가는가게하는거
        // 재요청한 서버로 주소가바뀜
//         resp.sendRedirect("/jsp/result.jsp");

        // 2. forward : 강제 이동 (요청 1번들어감) redirect, forward 둘다 동시에 못씀
        // 주소가안바뀌고 강제로이동시킨곳으로감
         RequestDispatcher rd = req.getRequestDispatcher("/jsp/result.jsp");
         rd.forward(req, resp);
    }
}
