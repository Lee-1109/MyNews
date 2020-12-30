<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 11360
  Date: 2020/12/28
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>权限管理</title>
    <link rel="stylesheet" type="text/css" href="css/inputStyle.css"/>
    <link rel="stylesheet" type="text/css" href="css/table.css"/>
    <link rel="stylesheet" type="text/css" href="css/grailLayout.css"/>
    <link rel="stylesheet" type="text/css" href="css/ol.css"/>
    <script rel="script" type="text/javascript"  src="js/delete.js"></script>
    <script rel="script" type="text/javascript"  src="js/verify.js"></script>
</head>
<body>

<div id="header">
    <h3 id="title">${sessionScope.grantName}:${sessionScope.nowUser.id}<a href="doLogout">【注销登陆】</a><hr></h3>
</div>
<div id="container">

        <div id="center" class="column">
            <!--条件查询框-->
            <form action="listAdminByCondition" method="post">
                <label>查询条件:<input class="input" name="condition" type="text" placeholder="请输入查询条件"/></label>
                <input class="input" type="submit" value="查询"/>
            </form>
            <div>
                <ol>
                    <li><img src="images/add.png" alt="添加"/><a href="#">添加管理员</a></li>
                    <li><img src="images/add.png" alt="批量添加"/><a href="#">批量添加</a></li>
                    <li><img src="images/delete.png" alt="批量删除"/><a href="#">批量删除</a></li>
                </ol>
            </div>
            <table>
                <tr class="tableHead">
                    <td>管理员账户名</td>
                    <td>管理员密码</td>
                    <td>权限</td>
                    <td colspan="2">操作</td>
                </tr>
            <c:if test="${empty admins}">
                <tr><td>暂无数据</td></tr>
            </c:if>
            <c:if test="${!empty admins}">
                <c:forEach items="${admins}" var="a">
                    <tr class="tableResult">
                        <td>${a.id}</td>
                        <td>${a.password}</td>
                        <c:if test="${a.grants == 0 }">
                            <td>超级管理员</td>
                        </c:if>
                        <c:if test="${a.grants == 1}">
                            <td>内容审核员</td>
                        </c:if>
                        <c:if test="${a.grants == 2}">
                            <td>系统业务员</td>
                        </c:if>
                        <td><a href="#" class="updateBtn" onclick="return verifyConfirm()">变更</a></td>
                        <td><a href="#" class="deleteBtn" onclick=" return deleteBtn('${a.id}')">删除</a></td>
                    </tr>
                </c:forEach>
            </c:if>
            </table>
            <%@include file="unitDivPage.jsp"%>
        </div>
    <div id="left" class="column">
        <ul>
            <li><a href="doLogin">返回主页</a></li>
            <li><a href="#">申请审核系统</a></li>
        </ul>
    </div>
    <div id="right" class="column"></div>
</div>
<div id="footer"></div>

</body>
</html>
