<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>LOGIN</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
</head>
<body>
<div class="container" style="width: 300px;">
    <c:url value="/j_spring_security_check" var="loginUrl" />
    <form action="${loginUrl}" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="form-control" name="j_username" placeholder="Email address" required autofocus value="login">
        <input type="password" class="form-control" name="j_password" placeholder="Password" required value="password">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
    </form>
</div>

</body>