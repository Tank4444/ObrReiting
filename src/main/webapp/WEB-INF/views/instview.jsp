<%@ page import="java.util.List" %>
<%@ page import="ru.chuikov.ObrReiting.entity.Institute" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
--%>
<html>
<head>
    <title>Информация о институте</title>
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
            <p>Уникальный номер: ${inst.id}</p>
            <p>Название института: ${inst.name}</p>
            <p>Город: ${inst.city}</p>
            <p>Адрес: ${inst.address}</p>
            <p>Кафедры: </p>
            <ul class="mdl-list">
                <c:forEach var="chair" items="${listChairs}">
                    <li class="mdl-list_item">${chair.name}</li>
                </c:forEach>
            </ul>

            <div class="mdl-grid">
                <c:forEach var="el" items="${listReview}">
                    <div class="mdl-card mdl-shadow--4dp mdl-cell mdl-cell--4-col">
                        <div class="mdl-card__title">
                            <h2 class="mdl-card__title-text">${el.user.login}</h2>
                        </div>
                        <div class="mdl-card__supporting-text">
                            ${el.text}
                            <hr>
                            <c:forEach items="${listRating}" var="rat">
                                <c:if test="${rat.user.login eq el.user.login}">
                                    Оценка: ${rat.mark}
                                </c:if>
                            </c:forEach>
                        </div>

                    </div>
                </c:forEach>

                <div class="mdl-card mdl-shadow--4dp mdl-cell mdl-cell--4-col">
                    <div class="mdl-card__title">
                        <h2 class="mdl-card__title-text">Добавить новый отзыв</h2>
                    </div>
                    <div class="mdl-card__actions">
                        <a href="/instReview/add/${inst.id}">Добавить</a>
                    </div>
                </div>
            </div>


        </div>
    </main>
</div>
</body>
</html>