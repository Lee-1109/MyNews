<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>新闻信息管理员登陆界面</title>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <link rel="stylesheet" type="text/css" href="css/mouse.css"/>
</head>
<body>
<header>新闻信息管理系统-管理端</header>
<div class="user">
    <form  action="doLogin" method="post">
        <span id="loginSpan"></span>
        <table>
            <tr>
                <td><label>账 号:</label></td>
                <td>
                    <label>
                        <input class="input" type="text"  name="id" placeholder="用户名\手机号\邮箱"/>
                    </label>
                </td>
            </tr>
            <tr>
                <td><label>密 码:</label></td>
                <td><label>
                    <input class="input" type="password" name="password" placeholder="请输入密码"/>
                </label></td>
            </tr>
            <tr>
                <td><label>登陆类型:</label></td>
                <td>
                    <label>
                        <select  name="grants">
                            <option class="option" value="0">超级管理员</option>
                            <option class="option" value="1">系统管理员</option>
                            <option class="option" value="2">内容审核员</option>
                        </select>
                    </label>
                </td>
            </tr>
            <tr><td><input type="submit" name="user" value="登陆"/></td></tr>
        </table>
    </form>
</div>
</body>
</html>
