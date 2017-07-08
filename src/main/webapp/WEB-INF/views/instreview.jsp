<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
--%>
<html>
<head>
    <title>Отзывы об институте</title>
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
            <span class="mdl-layout-title">Добавление института</span>
            <!-- Add spacer, to align navigation to the right -->
            <div class="mdl-layout-spacer"></div>
            <!-- Navigation. We hide it in small screens. -->
            <nav class="mdl-navigation mdl-layout--large-screen-only">
                <a class="mdl-navigation__link" href="/">Главная</a>
                <a class="mdl-navigation__link" href="/inst">Найти институт</a>
                <a class="mdl-navigation__link" href="/teacher">Найти преподавателя</a>
                <a class="mdl-navigation__link" href="/us">О нас</a>
            </nav>
        </div>
    </header>
    <main class="mdl-layout__content">
        <div class="page-content" align="center"><!-- Your content goes here -->
            <form method="post" action="/instReview/add/${inst.id}">
                <p>
                    <div class="mdl-textfield mdl-js-textfield">
                        <label class="mdl-textfield__label" for="sample1">Текст...</label>
                        <textarea class="mdl-textfield__input" type="text" rows= "10" id="sample1" name="text"></textarea>
                    </div>
                </p>
                <p>
                    <div class="mdl-textfield mdl-js-textfield">
                        <label class="mdl-textfield__label" for="sample2">Логин</label>
                        <input class="mdl-textfield__input" type="text" id="sample2" name="login">
                    </div>
                </p>
                <p>
                    <div class="mdl-textfield mdl-js-textfield">
                        <label class="mdl-textfield__label" for="sample3">Пароль</label>
                        <input class="mdl-textfield__input" type="password" id="sample3" name="password">
                    </div>
                </p>
                <p>
                    Оценка:
                </p>
                <p>
                    <input class="mdl-slider mdl-js-slider" type="range" name="mark"
                           min="0" max="10" value="5" tabindex="0">
                </p>
                <p>
                    <input type="submit">
                </p>
            </form>
        </div>
    </main>
</div>
</body>
</html>
