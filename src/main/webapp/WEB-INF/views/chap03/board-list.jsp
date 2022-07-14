<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- reset css -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@5.0.1/reset.min.css">

    <!-- bootstrap css -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">


    <!-- bootstrap js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" defer></script>

    <!-- jquery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <style>

        .list-header {
            display: flex;
        }
        #board li a:hover {
            color: #ff0;
            background: #930930;
        }
        a {
            color: inherit;
            text-decoration: none;
        }
    </style>

</head>
<body>

    <li class="list-header">
        <div>번호</div>
        <div>작성자</div>
        <div>제목</div>
        <div>조회수</div>
        <div>작성시간</div>
    </li>

    <c:forEach var="b" items="${boards}">
        <ul class="board">
            <li>
                <a href="/board/content?boardNo=${b.boardNo}">${b.boardNo}, ${b.writer}, ${b.title}
                    , ${b.viewCnt}, ${b.regDate}</a>
                <!-- <a class="del-btn" href="/board/delete?boardNo=${b.boardNo}">삭제</a> -->
            </li>
        </ul>
    </c:forEach>

    <a href="write" href="/board/write?boardNo=${b.boardNo}">글쓰기</a>

</body>
</html>