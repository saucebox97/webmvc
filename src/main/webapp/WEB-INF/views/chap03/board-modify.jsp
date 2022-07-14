<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

    <style>

        

    </style>

</head>
<body>

    
    <form action="/board/register" method="POST">
        <h1>${b.boardNo}번 게시물</h1>
        <label>
            작성자 <input type="text" name="writer" value="${b.writer}">
        </label>
        <label>
            글제목 <input type="text" name="title" value="${b.title}">
        </label>
        <label>
            내용 <input type="text" name="content" value="${b.content}">
        </label>
        <label>
            <button id="completion" type="button">완료</button>
        </label>
        <label>
            <button id="go-home" type="button">목록으로</button>    
        </label>
    </form>

    <script>
        const $comBtn = document.getElementById('completion');
        $delBtn.onclick = e => {
            location.href = '/board/content';
        }

        const $homeBtn = document.getElementById('go-home');
        $homeBtn.onclick = e => {
            location.href = '/board/list';
        };

    </script>

</body>
</html>