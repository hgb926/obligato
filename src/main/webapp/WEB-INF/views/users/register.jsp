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
        margin-top: 20px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    main h2 {
        font-size: 24px;
        margin-bottom: 20px;
    }

    form {
        display: flex;
        flex-direction: column;
    }

    form label {
        margin-bottom: 10px;
        font-size: 16px;
    }

    form input {
        margin-bottom: 20px;
        padding: 10px;
        font-size: 16px;
        border: 1px solid #ccc;
        border-radius: 5px;
        width: 30%;
    }

    form button {
        padding: 10px;
        font-size: 16px;
        background-color: #007bff;
        color: #ffffff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        width: 30%;
    }

    form button:hover {
        background-color: #0056b3;
    }
    /*.wrap {*/
    /*    display: flex;*/
    /*    justify-content: center;*/
    /*}*/
    .warning {
        color: red;
    }
    .success {
        color: skyblue;
    }
    .secondWrap {
        display: flex;
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
            <a href="sign-up">로그인</a>
            <a href="register">회원가입</a>
            <a href="../community/list">커뮤니티</a>
            <a href="#" class="download-button">앱 다운로드</a>
        </nav>
    </header>
    <main>
        <div class="wrap">
            <h2>회원가입</h2>
            <form action="/users/register" method="post">
                <label for="account">계정</label>
                <div class="secondWrap"><input type="text" id="account" name="account" required><span id="idMessage"></span></div>

                <label for="password">비밀번호</label>
                <div class="secondWrap"><input type="password" id="password" name="password" required><span id="pwMessage"></span></div>

                <label for="confirm-password">비밀번호 확인</label>
                <div class="secondWrap"><input type="password" id="confirm-password" name="confirm-password" required><span id="pwCheckMessage"></span></div>

                <label for="username">성명</label>
                <div class="secondWrap"><input type="text" id="username" name="username" required><span id="nameMessage"></span></div>

                <label for="email">이메일</label>
                <div class="secondWrap"><input type="email" id="email" name="email" required><span id="emailMessage"></span></div>

                <button type="submit">가입하기</button>
            </form>
        </div>
    </main>
</div>
<script>

    const $account = document.getElementById('account');
    const idMsg = document.getElementById('idMessage')
    $account.addEventListener('keyup', e => {
        if ($account.value.length < 4 || $account.value.length > 14) {
            idMsg.classList.remove('success')
            idMsg.classList.add('warning')
            idMsg.textContent = "계정명은 최소 4글자, 최대 14글자 입니다."
        } else {
            idMsg.classList.remove('warning')
            idMsg.classList.add('success')
            idMsg.textContent = "사용 가능한 ID입니다."
        }
    });

    const $name = document.getElementById('username');
    const nameMsg = document.getElementById('nameMessage')
    $name.addEventListener('keyup', e => {
        if ($name.value.length < 2 || $name.value.length > 6) {
            nameMsg.classList.remove('success')
            nameMsg.classList.add('warning')
            nameMsg.textContent = "실명은 최소 2글자, 최대 6글자 입니다."
        } else {
            nameMsg.classList.remove('warning')
            nameMsg.classList.add('success')
            nameMsg.textContent = "사용 가능한 이름입니다."
        }
    })
</script>
</body>
</html>