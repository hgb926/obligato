<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Web Study</title>
</head>
<link rel="stylesheet" href="/assets/css/main.css">
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        margin: 0;
        padding: 0;
    }

    .main-content {
        width: 50%;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h1 {
        font-size: 24px;
        color: #333;
    }

    p {
        font-size: 14px;
        color: #666;
    }

    .form-group {
        margin-bottom: 15px;
    }

    label {
        display: block;
        font-weight: bold;
        margin-bottom: 5px;
    }

    input[type="text"], select, textarea {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 14px;
        box-sizing: border-box;
    }

    textarea {
        height: 150px;
        resize: vertical;
    }

    .captcha {
        display: flex;
        align-items: center;
        margin-bottom: 15px;
    }

    .captcha input[type="checkbox"] {
        margin-right: 10px;
    }

    button {
        display: inline-block;
        padding: 10px 20px;
        color: #fff;
        background-color: #007bff;
        border: none;
        border-radius: 4px;
        font-size: 16px;
        cursor: pointer;
    }

    button:hover {
        background-color: #0056b3;
    }

</style>
<body>
<%--<header>--%>
<%--    <h1>Obligato</h1>--%>
<%--    &lt;%&ndash;        <c:if test="${userInfo != null}">&ndash;%&gt;--%>
<%--    &lt;%&ndash;            <div>${userInfo.nickName}님, 환영합니다!</div>&ndash;%&gt;--%>
<%--    &lt;%&ndash;        </c:if>&ndash;%&gt;--%>
<%--    <nav>--%>
<%--        <ul>--%>
<%--            &lt;%&ndash;                <li><a href="users/sign-up">마이페이지</a></li>&ndash;%&gt;--%>
<%--            <li><a href="community/list">커뮤니티</a></li>--%>
<%--            &lt;%&ndash;                <li><a href="#">로그아웃</a></li>&ndash;%&gt;--%>


<%--            <li><a href="users/sign-up">로그인</a></li>--%>
<%--            <li><a href="users/register">회원가입</a></li>--%>
<%--            &lt;%&ndash;                <li><a href="#">커뮤니티</a></li>&ndash;%&gt;--%>

<%--        </ul>--%>
<%--        <button>앱 다운로드</button>--%>
<%--    </nav>--%>
<%--</header>--%>
<div class="main-content">
    <h1>함께 할 때 더 즐거운 순간</h1>
<%--    <p>남녀노소할것없이 지식공유를 통하여 OKKY에서 다양한 사람들과 협업을 하거나 정보를 서로 나눠보세요.</p>--%>

<%--        <div class="form-group">--%>
        <%--            <label for="topic">토픽</label>--%>
        <%--            <select id="topic">--%>
        <%--                <option value="">토픽을 선택해주세요.</option>--%>
        <%--            </select>--%>
        <%--        </div>--%>
    <form action="/community/write" method="post">


    <div class="form-group">
            <label for="title">제목</label>
            <input type="text" id="title" name="title" placeholder="제목을 입력해주세요.">
        </div>

        <div class="form-group">
            <label for="writer">작성자 이름</label>
            <input type="text" id="writer" name="userName" placeholder="작성자 이름을 입력해주세요.">
        </div>

        <div class="form-group">
            <label for="content">본문</label>
            <textarea id="content" name="content" placeholder="내용을 입력해주세요."></textarea>
        </div>

        <button type="submit">등록</button>
    </form>
</div>
</body>
</html>