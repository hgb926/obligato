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

    .write {
        text-underline-mode: none;
        color: white;
    }

    .post span {
        font-size: 12px;
        color: #999;
    }

    .post-detail {
        margin-bottom: 20px;
    }

    .post-detail h1 {
        font-size: 28px;
        margin-bottom: 10px;
    }

    .post-detail .metadata {
        font-size: 14px;
        color: #999;
        margin-bottom: 20px;
    }

    .post-detail .content {
        font-size: 16px;
        color: #333;
    }
    .home {
        cursor: pointer;
    }
    .back-btn {
        position: absolute;
        left: 80%;
        margin-top: 20px;
    }
    .delete-modify {
        position: relative;
        left: 80%;
        cursor: pointer;
    }


</style>
<body>
<div class="container">
    <header>
        <h1 class="home">Obligato</h1>
        <nav>
            <a href="../users/sign-up">로그인</a>
            <a href="../users/register">회원가입</a>
            <a href="/community/list">커뮤니티</a>
            <a href="#" class="download-button">앱 다운로드</a>
        </nav>
    </header>
    <main>
        <h2>커뮤니티</h2>
        <div class="post-detail">
            <h1>${post.title}</h1>
            <div class="metadata">
                작성자: ${post.userName}<br>
                작성일: ${post.createdAt}<br>
                조회수: ${post.viewCount}
                <div class="delete-modify">
                    <a class="delete" data-bno ='${post.postId}'>삭제</a>
                    <a class="modify">수정</a>
                </div>
                <hr>
            </div>
            <div class="content">
                ${post.content}
            </div>
            <div>
                <button class="back-btn" type="button" onclick="window.location.href= '/community/list'">목록</button>
            </div>
        </div>
    </main>
</div>

<script>
    document.querySelector('.home').addEventListener("click", e => {
        window.location.href = "http://localhost:8686/index"
    })

    let $delete = document.querySelector('.delete');
    $delete.addEventListener('click', e => {
        const bno = $delete.dataset.bno;
        console.log(bno)
        window.location.href = '/community/delete?bno=' + bno;
    })
    let $modify = document.querySelector('.modify');
    $modify.addEventListener('click', e => {
        const bno = $delete.dataset.bno;
        console.log(bno)
    })

</script>
</body>
</html>