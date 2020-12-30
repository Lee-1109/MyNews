<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<div align="center">
    <font size="2">共 ${page.totalPageCount} 页</font> <font size="2" color="red">第 ${page.pageNow} 页</font>
    <a href="${url}">首页</a>
    <c:choose>
        <c:when test="${page.pageNow - 1 > 0}">
            <a href="${url}?pageNow=${page.pageNow - 1}">上一页</a>
        </c:when>
        <c:when test="${page.pageNow - 1 <= 0}">
            <a href="${url}?pageNow=1">上一页</a>
        </c:when>
    </c:choose>

    <c:choose>
        <c:when test="${page.totalPageCount==0}">
            <a href="${url}?pageNow=${page.pageNow}">下一页</a>
        </c:when>
        <c:when test="${page.pageNow + 1 < page.totalPageCount}">
            <a href="${url}?pageNow=${page.pageNow + 1}">下一页</a>
        </c:when>
        <c:when test="${page.pageNow + 1 >= page.totalPageCount}">
            <a href="${url}?pageNow=${page.totalPageCount}">下一页</a>
        </c:when>
    </c:choose>

    <c:choose>
        <c:when test="${page.totalPageCount==0}">
            <a href="${url}?pageNow=${page.pageNow}">尾页</a>
        </c:when>
        <c:otherwise>
            <a href="${url}?pageNow=${page.totalPageCount}">尾页</a>
        </c:otherwise>
    </c:choose>
</div>
<!--分页查询end-->

