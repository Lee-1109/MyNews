<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>文章复核</title>
    <link rel="stylesheet" type="text/css" href="css/table.css"/>
    <link rel="stylesheet" type="text/css" href="css/grailLayout.css"/>
    <link rel="stylesheet" type="text/css" href="css/ol.css"/>
    <link rel="stylesheet" type="text/css" href="css/inputStyle.css"/>
    <link rel="stylesheet" type="text/css" href="css/mouse.css"/>
    <script rel="script" type="text/javascript"  src="js/delete.js"></script>
    <script rel="script" type="text/javascript"  src="js/verify.js"></script>
</head>
<body>

<div id="header">
    <h3 id="title">${sessionScope.grantName}:${sessionScope.nowUser.id} <a href="doLogout">【注销登陆】</a><hr></h3>
</div>
<div id="container">
    <div id="center" class="column">
        <!--条件查询框-->
        <form action="#" method="post">
            <label>查询条件:<input class="input" type="text" placeholder="请输入查询条件"/></label>
            <input class="input" type="submit" value="查询"/>
        </form>
        <form action="#" method="post">
            <ol>
                <li><img src="images/delete.png" alt="批量恢复"/><input type="submit" value="批量恢复"/></li>
                <li><img src="images/delete.png" alt="批量删除"/><input type="submit" value="批量删除"/></li>
            </ol>
            <table>
                <tr class="tableHead">
                    <td>文章编号</td>
                    <td>文章标题</td>
                    <td>来源</td>
                    <td>违规详情</td>
                    <td>处理人</td>
                    <td>处理时间</td>
                    <td colspan="3">操作</td>
                </tr>
                <c:if test="${empty essays}">
                    <tr><td>暂无数据</td></tr>
                </c:if>
                <c:if test="${!empty essays}">
                    <c:forEach items="${essays}" var="e" varStatus="index">
                        <tr class="tableResult">
                            <!--用于批量提交数据-->
                            <td><input type="hidden" name="essayList[${index.index}].aid"/>${e.aid}</td>
                            <td>${e.title}</td>
                            <td>${e.publishName}</td>
                            <td>敏感词汇</td>
                            <td>${e.doAdminName}</td>
                            <td>${e.verifyTime}</td>
                            <td><a href="#" class="detailBtn" onclick="run('${e.title}','${e.content}')">详情</a></td>
                            <td><a href="deleteEssayReview?aid=${e.aid}" class="deleteBtn" onclick=" return deleteBtn('${e.nid}')">删除</a></td>
                            <td><a href="passEssayReview?aid=${e.aid}" class="passBtn">恢复</a></td>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>
        </form>
        <%@include file="unitDivPage.jsp"%>
    </div>

    <div id="left" class="column">
        <ul>
            <li><a href="doLogin">主页</a></li>
            <li><a href="doLogout">注销登陆</a></li>
            <li><a href="adminEssayReview">审查复核系统</a></li>
        </ul>
    </div>
    <div id="right" class="column">
    </div>
</div>
<div id="footer"></div>
</body>
</html>
