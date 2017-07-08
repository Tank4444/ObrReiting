<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Образовательный рейтинг</title>
    <script src="<c:url value="/mdl/material.min.css" />"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="<c:url value="/mdl/material.min.css" />">
</head>
<body>
<!-- Always shows a header, even in smaller screens. -->
<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
    <header class="mdl-layout__header">
        <div class="mdl-layout__header-row">
            <!-- Title -->
            <span class="mdl-layout-title">Образовательный рейтинг</span>
            <!-- Add spacer, to align navigation to the right -->
            <div class="mdl-layout-spacer"></div>
            <!-- Navigation. We hide it in small screens. -->
            <nav class="mdl-navigation mdl-layout--large-screen-only">
                <a class="mdl-navigation__link" href="/">Главная</a>
                <a class="mdl-navigation__link" href="/inst">Найти институт</a>
                <a class="mdl-navigation__link" href="/teacher">Найти преподавателя</a>
                <a class="mdl-navigation__link" href="/reg">Регистрация</a>
                <a class="mdl-navigation__link" href="/us">О нас</a>
            </nav>
        </div>
    </header>
    <main class="mdl-layout__content">
        <div class="page-content"><!-- Your content goes here -->
            <form method="post" action="/reg">
                <p><input type="text" name="login"> Login </p>
                <p><input type="password" name="password"> Password </p>
                <p><input type="text" name="mail"> Mail </p>
                <p><input type="submit"></p>
            </form>
        </div>
    </main>
</div>
</body>
</html>
