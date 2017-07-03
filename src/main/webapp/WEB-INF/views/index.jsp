<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <title>Образовательный рейтинг</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

</head>

<body>

    <div class="container">

        <div class="jumbotron" style="margin-top: 20px;">
            <h1>Образовательный рейтинг</h1>
            <p class="lead">
                Образовательный рейтинг - это ресурс где студенты могут оставлять отзывы о преподавателях, ВУЗах и т.д.
            </p>
            <sec:authorize access="!isAuthenticated()">
                <p><a class="btn btn-lg btn-success" href="<c:url value="/login" />" role="button">Войти</a></p>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <p>Ваш логин: <sec:authentication property="principal.username" /></p>
                <p><a class="btn btn-lg btn-danger" href="<c:url value="/logout" />" role="button">Выйти</a></p>

            </sec:authorize>
        </div>


        <div class="footer">
            <p>© Образовательный рейтинг 2017</p>
        </div>

    </div>
</body>
</html>
