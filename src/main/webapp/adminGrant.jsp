<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>权限管理</title>
    <link rel="stylesheet" type="text/css" href="css/inputStyle.css"/>
    <link rel="stylesheet" type="text/css" href="css/table.css"/>
    <link rel="stylesheet" type="text/css" href="css/grailLayout.css"/>
    <link rel="stylesheet" type="text/css" href="css/ol.css"/>
    <link rel="stylesheet" type="text/css" href="css/mouse.css"/>
    <script rel="script" type="text/javascript"  src="js/delete.js"></script>
    <script rel="script" type="text/javascript"  src="js/verify.js"></script>
    <script charset="UTF-8" rel="script" type="text/javascript"  src="js/createTable.js"></script>
    <script>
        var count = 0;
        function updateVerify(mid){
            let a_id = document.getElementById(mid);
            let grant_td = document.getElementById("td"+mid);//获取对应的点击标签
            if(count%2){
                grant_td.innerHTML="<select>" +
                    "<option>admin</option>" +
                    "<option>staff</option>" +
                    "</select>";
                a_id.innerHTML ="<a href='#' onclick='updateVerify(mid)'>confirm</a>";
                count++;
            }else {
                grant_td.innerHTML="更新后权限";
                a_id.innerHTML ="<a href='#' onclick='updateVerify(mid)'>update</a>";
                count++;
            }
            return false;
        }
    </script>
</head>
<body>
<script rel="script" type="text/javascript"  src="js/mouse.js"></script>
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
            <!--获取连接请求-->
            <form action="deleteAdminList" method="post">
                <div>
                    <ol>
                        <!--单个添加-->
                        <li><img src="images/add.png" alt="添加"/><a href="#" onclick="return createAddAdminTable()">添加管理员</a></li>
                        <!--批量添加-->
                        <li><img src="images/add.png" alt="批量添加"/><a href="#" onclick="my()">批量添加</a></li>
                        <!--批量删除 删除当前页面的所有管理员-->
                        <li><img src="images/delete.png" alt="批量删除"/><input type="submit" value="批量删除" onclick="return verifyConfirm()"/></li>
                    </ol>
                </div>
                <!--信息预留表格-->
                <table id="holder"></table>
                <!--管理员信息显示表格-->
                <table>
                    <tr class="tableHead">
                        <td>管理员账户名</td>
                        <td>管理员密码</td>
                        <td>权限</td>
                        <td colspan="2">操作</td>
                    </tr>
                    <!--管理员列表为空-->
                <c:if test="${empty admins}">
                    <tr><td>暂无数据</td></tr>
                </c:if>

                <c:if test="${!empty admins}">
                    <c:forEach items="${admins}" var="a" varStatus="index">
                        <tr class="tableResult">
                            <!--用于批量提交数据-->
                            <td><input type="hidden" name="adminList[${index.index}].id" value="${a.id}"/>${a.id}</td>
                            <td>${a.password}</td>
                            <c:if test="${a.grants == 0 }">
                                <td id="td${a.id}">超级管理员</td>
                            </c:if>
                            <c:if test="${a.grants == 1}">
                                <td id="td${a.id}">内容审核员</td>
                            </c:if>
                            <c:if test="${a.grants == 2}">
                                <td id="td${a.id}">系统业务员</td>
                            </c:if>
                            <td><a href="#" class="updateBtn" id="${a.id}" onclick="return updateVerify('${a.id}')">变更</a></td>
                            <td><a href="#" class="deleteBtn" onclick=" return deleteBtn('${a.id}')">删除</a></td>
                        </tr>
                    </c:forEach>
                </c:if>
                </table>
            </form>
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
