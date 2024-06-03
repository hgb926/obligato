<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
  <title>로그인 - Obligato</title>
</head>
<style>
  body {
    margin: 0;
    font-family: Arial, sans-serif;
    background-color: #e0f7ff;
  }

  .container {
    width: 100%;
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
    text-align: center;
    background-color: #fff;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
    border-radius: 10px;
  }

  header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 10px 20px;
    background-color: #fff;
    border-bottom: 1px solid #eee;
  }

  header h1 {
    font-size: 2em;
    color: #333;
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

  main {
    padding: 50px 20px;
  }

  .login-form {
    max-width: 400px;
    margin: 0 auto;
    text-align: left;
  }

  .login-form h2 {
    font-size: 2em;
    margin-bottom: 20px;
  }

  .login-form label {
    display: block;
    margin-bottom: 8px;
    font-weight: bold;
  }

  .login-form input {
    width: 100%;
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
  }

  .login-form button {
    width: 100%;
    padding: 10px;
    background-color: #0073e6;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 1em;
  }

  .login-form button:hover {
    background-color: #005bb5;
  }
</style>
<body>
<div class="container">
  <header>
    <h1>Obligato</h1>
    <nav>
      <ul>
        <li><a href="/index">홈</a></li>
        <li><a href="register">회원가입</a></li>
        <li><a href="/community/list">커뮤니티</a></li>
      </ul>
      <button>앱 다운로드</button>
    </nav>
  </header>
  <main>
    <div class="login-form">
      <h2>로그인</h2>
      <form action="/users/sign-up" method="post">
        <label for="username">아이디</label>
        <input type="text" id="username" name="username" required>

        <label for="password">비밀번호</label>
        <input type="password" id="password" name="password" required>

        <button type="submit">로그인</button>
      </form>
    </div>
  </main>
</div>
</body>
</html>