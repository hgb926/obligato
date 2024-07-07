<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Web Study</title>
    <link rel="stylesheet" href="/assets/css/main.css">
<style>
    .hero a {
        color: white;

        text-underline: none;

    }
</style>
</head>
<body>
<div class="container">
    <header>
        <h1 style="cursor: pointer" onclick="window.location.href=`/`">Obligato</h1>
        <c:if test="${user != null}">
            <div>${user.name}님, 환영합니다!</div>
        </c:if>
        <nav>
            <ul>
                <li><a href="users/sign-up">마이페이지</a></li>
                <li><a href="community/list">커뮤니티</a></li>
                <li><a href="users/sign-out">로그아웃</a></li>
            </ul>
            <button>앱 다운로드</button>
        </nav>
    </header>
    <main>
        <div class="hero">
            <h2>${dto.username}님. 환영합니다!</h2>
            <p>여러 서비스가 준비되어 있습니다.</p>
            <button><a href="../index">홈으로 가기</a></button>
        </div>
    </main>
</div>
</body>
</html>