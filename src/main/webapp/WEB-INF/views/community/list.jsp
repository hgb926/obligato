<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Web Study</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f8ff;
        margin: 0;
        padding: 0;
    }

    .container {
        width: 100%;
        max-width: 1200px;
        margin: 0 auto;
        padding: 20px;
    }

    header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        background-color: #ffffff;
        padding: 20px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    header h1 {
        margin: 0;
        font-size: 24px;
    }

    nav a {
        margin-left: 20px;
        text-decoration: none;
        color: #333;
        font-size: 16px;
    }

    .download-button {
        background-color: #007bff;
        color: #ffffff;
        padding: 10px 20px;
        border-radius: 5px;
    }

    main {
        background-color: #ffffff;
        padding: 40px;
        margin: 20px 10%;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    main h2 {
        font-size: 24px;
        margin-bottom: 20px;
    }

    .write-button {
        background-color: #007bff;
        color: #ffffff;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
        margin-bottom: 20px;
    }

    .write-button:hover {
        background-color: #0056b3;
    }

    .posts {
        display: flex;
        flex-direction: column;
    }

    .post {
        background-color: #f9f9f9;
        padding: 20px;
        margin-bottom: 20px;
        border-radius: 5px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    .post h3 {
        margin: 0 0 10px;
        font-size: 18px;
    }

    .post p {
        margin: 0 0 10px;
        font-size: 14px;
        color: #666;
    }

    .post span {
        font-size: 12px;
        color: #999;
    }
</style>
<body>
<div class="container">
    <header>
        <h1>Obligato</h1>
        <nav>
            <a href="../users/sign-up">로그인</a>
            <a href="../users/register">회원가입</a>
            <a href="">커뮤니티</a>
            <a href="#" class="download-button">앱 다운로드</a>
        </nav>
    </header>
    <main>
        <h2>커뮤니티</h2>
        <button class="write-button">작성하기</button> <br>
        <button class="write-button">악기 별</button>
        <button class="write-button">지역 별</button>
        <button class="write-button">페이 별</button>
        <button class="write-button">최신 순</button>
        <div class="posts">
            <div class="post">
                <h3>중요 알림 OKKY v4.4.0 모바일앱 릴리즈</h3>
                <p>약 2개월 전 · 523</p>
                <span>조회수: 2.8k · 댓글: 11 · 좋아요: 17</span>
            </div>
        </div>
    </main>
</div>
</body>
</html>