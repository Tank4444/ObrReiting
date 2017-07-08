<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
--%>
<html>
<head>
    <title>Добавление института</title>
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
            <c:if test="${!edit}">
                <form method="post" action="/inst/addInst">
                    <p><input type="text" name="name"> Название </p>
                    <p><input type="text" name="city"> Город </p>
                    <p><input type="text" name="address"> Адресс </p>
                    Кафедры:
                    <c:forEach items="${listChair}" var="chair">
                        <input type="checkbox" name="chair" value="${chair.id}">${chair.name}<br>
                    </c:forEach>
                    <p><input type="submit"></p>
                </form>
            </c:if>
            <c:if test="${edit}">
                <form method="post" action="/inst/editInst">
                    <input type="hidden" name="id" value="${inst.id}">
                    <p><input type="text" name="name" value="${inst.name}"> Название </p>
                    <p><input type="text" name="city" value="${inst.city}"> Город </p>
                    <p><input type="text" name="address" value="${inst.address}"> Адресс </p>
                    Кафедры:
                    <c:forEach items="${listChairs}" var="chair">
                        <c:if test="${chair.value eq 'yes'}">
                            <input type="checkbox" name="chair" value="${chair.key.id}" checked>${chair.key.name}<br>
                        </c:if>
                        <c:if test="${chair.value eq 'no'}">
                            <input type="checkbox" name="chair" value="${chair.key.id}">${chair.key.name}<br>
                        </c:if>
                    </c:forEach>
                    <p><input type="submit"></p>
                </form>
            </c:if>

        </div>
    </main>
</div>
</body>
</html>
