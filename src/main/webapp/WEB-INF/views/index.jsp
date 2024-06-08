<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Web Study</title>
    <link rel="stylesheet" href="/assets/css/main.css">

</head>
<body>
<div class="container">
    <header>
        <h1>Obligato</h1>
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
        <div class="hero">

            <h2>오브리 구인 구직 사이트</h2>
            <p>조건에 맞는 오브리를 검색해보세요!</p>
            <button>앱 다운로드</button>
        </div>
    </main>
</div>
</body>
</html>