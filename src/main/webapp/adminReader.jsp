<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/12/29
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>用户管理</title>
    <link rel="stylesheet" type="text/css" href="css/table.css"/>
    <link rel="stylesheet" type="text/css" href="css/grailLayout.css"/>
    <link rel="stylesheet" type="text/css" href="css/ol.css"/>
    <link rel="stylesheet" type="text/css" href="css/inputStyle.css"/>
    <link rel="stylesheet" type="text/css" href="css/mouse.css"/>
    <script rel="script" type="text/javascript"  src="js/delete.js"></script>
</head>
<body>
<script rel="script" type="text/javascript"  src="js/mouse.js"></script>
<div id="header">
    <h3 id="title">${sessionScope.grantName}:${sessionScope.nowUser.id} <a href="doLogout">【注销登陆】</a><hr></h3>
</div>
<div id="container">
    <div id="center" class="column">
        <!--条件查询框-->
        <form action="adminReaderByCondition" method="post">
            <label>查询条件:<input class="input" type="text" name="condition" placeholder="请输入查询条件"/></label>
            <input class="input" type="submit" value="查询"/>
        </form>
        <div>
            <ol>
                <li><img src="images/add.png" alt="添加"/><a href="#">添加读者</a></li>
                <li><img src="images/add.png" alt="批量添加"/><a href="#">批量添加</a></li>
                <li><img src="images/delete.png" alt="批量删除"/><a href="#">批量删除</a></li>
            </ol>
        </div>
        <table>
            <tr class="tableHead">
                <td>用户账号</td>
                <td>用户名</td>
                <td>性别</td>
                <td>用户密码</td>
                <td>联系方式</td>
                <td colspan="2">操作</td>
            </tr>
            <c:if test="${empty readers}">
                <tr><td>暂无数据</td></tr>
            </c:if>
            <c:if test="${!empty readers}">
                <c:forEach items="${readers}" var="r">
                    <tr class="tableResult">
                        <td>${r.uid}</td>
                        <td>${r.username}</td>
                        <c:if test="${r.gender == 'f' }">
                            <td>女</td>
                        </c:if>
                        <c:if test="${r.gender == 'm'}">
                            <td>男</td>
                        </c:if>
                        <td>${r.password}</td>
                        <td>${r.tel}</td>
                        <td><a href="#" class="updateBtn">变更</a></td>
                        <td><a href="#" class="deleteBtn" onclick=" return deleteBtn('${r.uid}')">删除</a></td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
        <%@include file="unitDivPage.jsp"%>
    </div>
    <div id="left" class="column">
        <ul>
            <li><a href="doLogin">返回主页</a></li>
            <li><a href="adminPublish">报社信息管理</a></li>
            <li><a href="adminReader">读者信息管理</a></li>
            <li><a href="#">申请审核系统</a></li>
        </ul>
    </div>
    <div id="right" class="column">
    </div>
</div>
<div id="footer"></div>
</body>
</html>
