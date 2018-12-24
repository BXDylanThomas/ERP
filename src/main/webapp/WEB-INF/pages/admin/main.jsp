<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
</head>
<body>

        <form action="addDepartment" method="post">
            <label for="name">部门名称：</label><input required type="text" name="name" id="name">
            <label for="description">描述：</label><input required type="text" name="description" id="description">
            <input type="submit" value="确定" >
        </form>


        <c:if test="${res}">
            ${departments}
        </c:if>
        <c:if test="${!res}">
           123
        </c:if>

        <a href="queryDepartment">查询</a>
        ${departments}
</body>
</html>