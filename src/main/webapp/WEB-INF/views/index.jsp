<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Web Study</title>
    <link rel="stylesheet" href="/assets/css/main.css">

    <style>
        .modal-wrap {
                display: none;
                position: fixed; /* 고정 위치 */
                z-index: 1; /* 우선순위 */
                left: 50%; /* 수평 중앙 */
                top: 50%; /* 수직 중앙 */
                transform: translate(-50%, -50%); /* 가운데 정렬 */
                width: 30%; /* 너비 */
                height: 30%; /* 높이 */
                overflow: auto;
                border: 1px solid black;
                border-radius: 20px;
                background: white;
        }
        .modal-top {
            height: 10%;
            justify-content: center;
            align-items: center;
            display: flex;
        }
        .modal-middle {
            height: 80%;
        }
        .modal-bottom {
            height: 10%;
        }
        .modal-middle div {
            height: 10%;
            border: black 1px solid;
        }

    </style>
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
            <button>글씨 크기 조절하기</button>
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
<div class="modal-wrap">
    <h2 class="modal-top" >
        글씨 크기를 조절하세요!
    </h2>
    <div class="modal-middle">
        <div class="font26" style="font-size: 28px">반갑습니다</div>
        <div class="font26" style="font-size: 26px">반갑습니다</div>
        <div class="font24" style="font-size: 24px">반갑습니다</div>
        <div class="font22" style="font-size: 22px">반갑습니다</div>
        <div class="font20" style="font-size: 20px">반갑습니다</div>
        <div class="font18" style="font-size: 18px">반갑습니다</div>
        <div class="font16" style="font-size: 16px">반갑습니다</div>
        <div class="font14" style="font-size: 14px">반갑습니다</div>
<%--        <div class="font12" style="font-size: 12px">반갑습니다</div>--%>
<%--        <div class="font10" style="font-size: 10px">반갑습니다</div>--%>
    </div>
    <div class="modal-bottom">
        <button>변경하기</button>
    </div>
</div>
</body>
</html>