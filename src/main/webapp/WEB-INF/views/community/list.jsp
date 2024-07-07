<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Web Study</title>
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

    #post {
        background-color: #f9f9f9;
        padding: 20px;
        margin-bottom: 20px;
        border-radius: 5px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        cursor: pointer;
    }

    #post h3 {
        margin: 0 0 10px;
        font-size: 18px;
    }

    #post p {
        margin: 0 0 10px;
        font-size: 14px;
        color: #666;
    }
    .write {
        text-underline-mode: none;
        color: white;
    }

    #post span {
        font-size: 12px;
        color: #999;
    }
    .none {
        display: none;
    }

</style>
<body>
<div class="container">
    <header>
        <h1 style="cursor: pointer" onclick="window.location.href=`/`">Obligato</h1>
        <c:if test="${user != null}">
            <div>${user.name}님, 환영합니다!</div>
        </c:if>
        <nav>
            <ul>
                <c:if test="${user != null}">
                    <li><a href="users/my-page">마이페이지</a></li>
                    <li><a href="community/list">커뮤니티</a></li>
                    <li><a href="users/sign-out">로그아웃</a></li>
                </c:if>
                <c:if test="${user == null}">
                    <li><a href="users/sign-up">로그인</a></li>
                    <li><a href="community/list">커뮤니티</a></li>
                    <li><a href="users/register">회원가입</a></li>
                </c:if>
            </ul>
            <button>앱 다운로드</button>
        </nav>
    </header>
    <main>
        <h2>커뮤니티</h2>
        <button class="write-button write"><a href="/community/write" class="write">작성하기</a></button> <br>
        <button class="write-button">악기 별</button>
        <button class="write-button">지역 별</button>
        <button class="write-button">페이 별</button>
        <button class="write-button newest">최신 순</button>
        <button class="write-button oldest none">오래된 순</button>
        <div class="posts">
            <c:forEach var="list" items="${postList}">

                    <div id="post" data-bno="${list.postId}">
                        <h3>${list.title}</h3>
                        <p>${list.userName}</p>
                        <p>${list.createdAt}</p>
                        <span>조회수: ${list.viewCount} · 댓글: ${list.replyCount}</span>
                    </div>

            </c:forEach>
        </div>
    </main>
</div>

<script>

    addEventListener('click', e => {
        const bno = e.target.closest('#post').dataset.bno;
        window.location.href = '/community/detail?bno=' + bno;
    })

    document.addEventListener('DOMContentLoaded', () => {
        const $new = document.querySelector('.newest');
        const $old = document.querySelector('.oldest');

        // 현재 URL에서 sort 파라미터 확인
        const urlParams = new URLSearchParams(window.location.search);
        const sortParam = urlParams.get('sort');

        if (sortParam === 'newest') {
            $new.classList.add('none');
            $old.classList.remove('none');
        } else if (sortParam === 'oldest') {
            $old.classList.add('none');
            $new.classList.remove('none');
        }

        $new.addEventListener('click', e => {
            $new.classList.add('none');
            $old.classList.remove('none');
            window.location.href = '/community/list?sort=newest';
        });

        $old.addEventListener('click', e => {
            $old.classList.add('none');
            $new.classList.remove('none');
            window.location.href = '/community/list?sort=oldest';
        });
    });



</script>

</body>
</html>