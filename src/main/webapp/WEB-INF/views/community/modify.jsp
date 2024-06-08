<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>게시글 수정</title>
</head>
<style>
    nav {
        display: flex;
        align-items: center;
    }

    nav ul {
        list-style: none;
        padding: 0;
        display: flex;
        gap: 15px;
        margin: 0;
    }

    nav ul li {
        display: inline;
    }

    nav ul li a {
        text-decoration: none;
        color: #0073e6;
        font-weight: bold;
    }

    nav button {
        background-color: #0073e6;
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        cursor: pointer;
        margin-left: 20px;
    }
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

    main {
        background-color: #ffffff;
        padding: 40px;
        margin: 20px 0;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    main h2 {
        font-size: 24px;
        margin-bottom: 20px;
    }

    .form-group {
        margin-bottom: 20px;
    }

    .form-group label {
        display: block;
        font-weight: bold;
        margin-bottom: 5px;
    }

    .form-group input[type="text"],
    .form-group textarea {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 16px;
    }

    .form-group textarea {
        height: 200px;
    }

    button {
        background-color: #007bff;
        color: #ffffff;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        font-size: 16px;
        cursor: pointer;
        margin-right: 10px;
    }

    button:hover {
        background-color: #0056b3;
    }

    button[type="button"] {
        background-color: #6c757d;
    }

    button[type="button"]:hover {
        background-color: #5a6268;
    }
</style>
<body>
<div class="container">
    <header>
        <h1>Obligato</h1>
        <c:if test="${user != null}">
            <div>${user.name}님, 환영합니다!</div>
        </c:if>
        <nav>
            <ul>
                <li><a href="users/my-page">마이페이지</a></li>
                <li><a href="community/list">커뮤니티</a></li>
                <li><a href="users/sign-out">로그아웃</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <h2>게시글 수정</h2>
        <form action="/community/modify" method="post">
            <input type="hidden" name="postId" value="${post.postId}">
            <div class="form-group">
                <label for="title">제목</label>
                <input type="text" id="title" name="title" value="${post.title}" required>
            </div>
            <div class="form-group">
                <label for="username">작성자</label>
                <input type="text" id="username" name="username" value="${post.userName}" readonly>
            </div>
            <div class="form-group">
                <label for="content">내용</label>
                <textarea id="content" name="content" required>${post.content}</textarea>
            </div>
            <button type="submit">수정하기</button>
            <button type="button" onclick="window.location.href='/community/list'">취소</button>
        </form>
    </main>
</div>

<script>
    // 수정 로직 해보자~~
</script>
</body>
</html>