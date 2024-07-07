<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Web Study</title>
</head>
<link rel="stylesheet" href="/assets/css/main.css">
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        margin: 0;
        padding: 0;
    }

    .main-content {
        width: 50%;
        margin: 0 auto;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h1 {
        font-size: 24px;
        color: #333;
    }

    p {
        font-size: 14px;
        color: #666;
    }

    .form-group {
        margin-bottom: 15px;
    }

    label {
        display: block;
        font-weight: bold;
        margin-bottom: 5px;
    }

    input[type="text"], select, textarea, input[type="date"], input[type="number"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 14px;
        box-sizing: border-box;
    }

    textarea {
        height: 150px;
        resize: vertical;
    }

    .captcha {
        display: flex;
        align-items: center;
        margin-bottom: 15px;
    }

    .captcha input[type="checkbox"] {
        margin-right: 10px;
    }

    button {
        display: inline-block;
        padding: 10px 20px;
        color: #fff;
        background-color: #007bff;
        border: none;
        border-radius: 4px;
        font-size: 16px;
        cursor: pointer;
    }

    button:hover {
        background-color: #0056b3;
    }

</style>
<body>
<div class="container">
    <header>
        <h1 style="cursor: pointer" onclick="window.location.href=`/`">Obligato</h1>

            <div>${user.name}님, 환영합니다!</div>
        <nav>
            <ul>

                    <li><a href="users/my-page">마이페이지</a></li>
                    <li><a href="community/list">커뮤니티</a></li>
                    <li><a href="users/sign-out">로그아웃</a></li>


            </ul>
            <button>앱 다운로드</button>
        </nav>
    </header>
    <main>
        <div class="main-content">
            <h1>함께 할 때 더 즐거운 순간</h1>
            <form action="/community/write" method="post">

                <label>
                    # 악기 <br>
                    <select name="instruments">
                        <option value="flute">flute</option>
                        <option value="oboe">oboe</option>
                        <option value="clarinet">clarinet</option>
                        <option value="bassoon">bassoon</option>
                        <option value="horn">horn</option>
                        <option value="trumpet">trumpet</option>
                        <option value="trombone">trombone</option>
                        <option value="baseTrombone">base-trombone</option>
                        <option value="tuba">tuba</option>
                    </select>
                </label>
                <label>
                    # 지역 <br>
                    <select name="location">
                        <option value="seoul">서울</option>
                        <!-- 경기도 도시들 -->
                        <option value="suwon">수원</option>
                        <option value="ilsan">일산</option>
                        <option value="yongin">용인</option>
                        <option value="seongnam">성남</option>
                        <option value="bucheon">부천</option>
                        <option value="ansan">안산</option>
                        <option value="anyang">안양</option>
                        <option value="gumdan">검단</option>
                        <option value="namyangju">남양주</option>
                        <option value="hwaseong">화성</option>
                        <option value="pyeongtaek">평택</option>
                        <option value="uiejeongbu">의정부</option>
                        <option value="paju">파주</option>
                        <option value="siheung">시흥</option>
                        <option value="gimpo">김포</option>
                        <option value="gwangmyeong">광명</option>
                        <option value="gunpo">군포</option>
                        <option value="ic">의왕</option>
                        <option value="hanam">하남</option>
                        <option value="yongin">용인</option>
                        <option value="guri">구리</option>
                        <option value="an">안성</option>
                        <option value="ic">이천</option>
                        <option value="yaju">여주</option>
                        <!-- 그 외 주요 도시 -->
                        <option value="busan">부산</option>
                        <option value="incheon">인천</option>
                        <option value="daegu">대구</option>
                        <option value="daejeon">대전</option>
                        <option value="gwangju">광주</option>
                        <option value="ulsan">울산</option>
                        <option value="jeonju">전주</option>
                        <option value="cheongju">청주</option>
                        <option value="pohang">포항</option>
                        <option value="jeju">제주</option>
                        <option value="changwon">창원</option>
                    </select>
                </label>

                <label>
                    # 페이 <br>
                    <input type=number placeholder="페이를 입력하세요.">
                </label>



                <label for="date-picker"># 날짜</label>
                <input type="date" id="date-picker" name="date">


                <div class="form-group">
                    <label for="title">제목</label>
                    <input type="text" id="title" name="title" placeholder="제목을 입력해주세요.">
                </div>

                <div class="form-group">
                    <label for="writer">작성자</label>
                    <input type="text" id="writer" name="userName" placeholder="작성자 이름을 입력해주세요." value="${user.userName}" readonly>
                </div>

                <div class="form-group">
                    <label for="content">본문</label>
                    <textarea id="content" name="content" placeholder="내용을 입력해주세요."></textarea>
                </div>

                <button type="submit">등록</button>
            </form>
        </div>
    </main>
</div>

    <%--    <p>남녀노소할것없이 지식공유를 통하여 OKKY에서 다양한 사람들과 협업을 하거나 정보를 서로 나눠보세요.</p>--%>

    <%--        <div class="form-group">--%>
    <%--            <label for="topic">토픽</label>--%>
    <%--            <select id="topic">--%>
    <%--                <option value="">토픽을 선택해주세요.</option>--%>
    <%--            </select>--%>
    <%--        </div>--%>
<%--    <form action="/community/write" method="post">--%>


<%--        <div class="form-group">--%>
<%--            <label for="title">제목</label>--%>
<%--            <input type="text" id="title" name="title" placeholder="제목을 입력해주세요.">--%>
<%--        </div>--%>

<%--        <div class="form-group">--%>
<%--            <label for="writer">작성자 이름</label>--%>
<%--            <input type="text" id="writer" name="userName" placeholder="작성자 이름을 입력해주세요.">--%>
<%--        </div>--%>

<%--        <div class="form-group">--%>
<%--            <label for="content">본문</label>--%>
<%--            <textarea id="content" name="content" placeholder="내용을 입력해주세요."></textarea>--%>
<%--        </div>--%>

<%--        <button type="submit">등록</button>--%>
<%--    </form>--%>

</body>
</html>