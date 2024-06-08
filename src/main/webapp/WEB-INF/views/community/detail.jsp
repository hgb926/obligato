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

    .none {
        display: none;
    }

    .delete-modal {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        width: 30%;
        height: 20%;
        position: fixed;
        z-index: 9999;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
        cursor: pointer;

    }

    .modal-top {
        width: 40%;
        height: 30%;
        background: #EFF8FF;
        justify-content: center;
        display: flex;
        align-items: center;
        z-index: 9999;
        padding: 20px;
    }

    .modal-bottom {
        width: 40%;
        display: flex;
        justify-content: space-evenly;
        background: white;
        z-index: 9999;
        padding: 20px;
    }
    .modal-bottom .yes {
        padding: 20px;
        border-radius: 50%;
        color: white;
        background: #007bff;
        z-index: 9999;
        cursor: pointer;
    }
    .modal-bottom .no {
        padding: 20px;
        border-radius: 50%;
        color: white;
        background: red;
        z-index: 9999;
        cursor: pointer;
    }
    .lay-out {
        width: 100%;
        height: 100vh;
        background: rgba(0, 0, 0, 0.7);
        position: fixed;
        left: 0;
        top: 0;
        z-index: 9998;
    }
    .none {
        display: none;
    }


</style>
<body>
<div class="lay-out none"></div>
<div class="container">
    <header>
        <h1 class="home">Obligato</h1>
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
                    <li><a href="/users/sign-up">로그인</a></li>
                    <li><a href="community/list">커뮤니티</a></li>
                    <li><a href="/users/register">회원가입</a></li>
                </c:if>
            </ul>
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
                <c:if test="${user.userName eq post.userName}">
                <div class="delete-modify">
                    <a class="delete" data-bno ='${post.postId}'>삭제</a>
                    <a class="modify" data-bno ='${post.postId}'>수정</a>
                </div>
                </c:if>
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

    <div class="delete-modal none">
        <div class="modal-top">
            정말 삭제하시겠습니까?
        </div>
        <div class="modal-bottom">
            <div class="yes">예</div>
            <div class="no">아니오</div>
        </div>
    </div>
</div>

<script>

    const $layOut = document.querySelector('.lay-out');
    const $deleteModal = document.querySelector('.delete-modal');
    const $yes = document.querySelector('.yes');
    const $no = document.querySelector('.no');
    const $deleteButtons = document.querySelectorAll('.delete');
    const $modify = document.querySelector('.modify')

    $deleteButtons.forEach($delete => {
        $delete.addEventListener('click', e => {
            $layOut.classList.remove('none');
            $deleteModal.classList.remove('none');

            const bno = e.target.dataset.bno;
            console.log(bno)

            $yes.addEventListener('click', () => {
                window.location.href = '/community/delete?bno=' + bno;
            });

            $no.addEventListener('click', () => {
                $layOut.classList.add('none');
                $deleteModal.classList.add('none');
            });
        });
    });

    $modify.addEventListener('click', e => {
        const bno = e.target.dataset.bno;
        window.location.href = '/community/modify?bno=' + bno;

    })



</script>
</body>
</html>