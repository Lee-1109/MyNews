<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/12/28
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>${sessionScope.grantName}主页面</title>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <link rel="stylesheet" type="text/css" href="css/mouse.css"/>
</head>
<body>
<h3 id="title">${sessionScope.grantName}:${sessionScope.nowUser.id}<a href="doLogout">【注销登陆】</a><hr></h3>

<div class="container">
    <ul>
        <c:if test="${sessionScope.nowUser.grants <= 0}">
            <li><a href="adminGrant">管理员权限管理系统</a></li>
            <li><a href="#">管理员申请系统</a></li>
        </c:if>

        <!--系统管理员：可以修改用户信息，报社信息，但是不能修改自身权限-->
        <c:if test="${sessionScope.nowUser.grants == 1}">
            <li><a href="adminPublish">报社信息管理系统</a></li>
            <li><a href="adminReader">读者信息管理系统</a></li>
            <li><a href="#">审核申请系统</a></li>
            <li><a href="#">账号封禁/解封</a></li>
        </c:if>

        <!--内容审核员:仅审查文章内容 以及评论内容-->
        <c:if test="${sessionScope.nowUser.grants == 2}">
            <li><a href="adminEssay">文章审查</a></li>
            <li><a href="adminEssayReview">审查复核</a></li>
        </c:if>
    </ul>
</div>
</body>
</html>
