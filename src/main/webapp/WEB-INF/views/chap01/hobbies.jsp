<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
</head>
<body>

    <h1>[${name}] 의 취미 목록</h1>
    <ol>
        <!-- 여기는 html 주석됌 / for(String h : hList) -->
        <c:forEach var="h" items="${hobbies}">
            <%-- 여기에서 주석쓸려면 jsp주석 형태로쓰기 c:가 jsp여서--%>
            <li>${h}</li>
        </c:forEach>
    </ol>

</body>
</html>