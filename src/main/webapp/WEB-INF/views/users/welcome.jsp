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
        <h1>Obligato</h1>
        <nav>
            <ul>
                <li><a href="users/sign-up">로그인</a></li>
                <li><a href="community/list">커뮤니티</a></li>
            </ul>
            <button>앱 다운로드</button>
        </nav>
    </header>
    <main>
        <div class="hero">
            <h2>님. 환영합니다!</h2>
            <p>여러 서비스가 준비되어 있습니다.</p>
            <button><a href="../index">홈으로 가기</a></button>
        </div>
    </main>
</div>
</body>
</html>