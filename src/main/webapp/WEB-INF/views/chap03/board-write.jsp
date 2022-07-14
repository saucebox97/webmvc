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
        <label>
            작성자 <input type="text" name="writer">
        </label>
        <label>
            글제목 <input type="text" name="title">
        </label>
        <label>
            내용 <input type="text" name="content">
        </label>
        <label>
            <!-- submit 서버로 이동하는 버튼 button 기능이없음 -->
            <button type="submit">글 작성하기</button>
        </label>
        <label>
            <button id="go-home" type="button">목록으로</button>    
        </label>
    </form>

    <script>

        const $homeBtn = document.getElementById('go-home');
        $homeBtn.onclick = e => {
            location.href = '/board/list';
        };

    </script>

</body>
</html>