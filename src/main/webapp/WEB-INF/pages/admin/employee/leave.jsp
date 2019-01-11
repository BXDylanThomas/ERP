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
    <link rel="stylesheet" href="resource/css/next.css">
    <link rel="stylesheet" href="resource/css/page.css">
    <style>
        td{
            width: 150px;
            height: 40px;
            text-align: center;
        }
    </style>
</head>
<body>
<div style="margin:0 auto;width: 80%">
    <jsp:include page="../base.jsp" />

    <div id="next">
        <div id="main">
            <table border="1" rules="all">
                <tr>
                    <td>姓名</td>
                    <td>入职时间</td>
                    <td>离职时间</td>
                    <td>离职原因</td>
                </tr>
                <c:if test="${EmployeeLeave==null || empty EmployeeLeave}">
                    <tr>
                        <td colspan="4">暂无数据</td>
                    </tr>
                </c:if>
                <c:if test="${EmployeeLeave!=null || not empty EmployeeLeave}">
                    <c:forEach items="${EmployeeLeave}" var="e">
                        <tr>
                            <td>${e.employee.resume.name}</td>
                            <td>${e.employee.entryTime}</td>
                            <td>${e.time}</td>
                            <td>${e.reason}</td>
                        </tr>
                    </c:forEach>

                </c:if>
            </table>
        </div>

        <div id="xia" style="position: relative;left: 100px">
            <div id="page">
                <span>页数：</span>
                <a href="queryemployeeleave?current=1">首页</a>
                <a href="queryemployeeleave?current=${prepages}">上一页</a>
                <c:forEach  var ="i" begin="1" end="${pages}">
                    <a href="queryemployeeleave?current=${i}">${i}</a>
                </c:forEach>
                <a href="queryemployeeleave?current=${nextpages}">下一页</a>
                &nbsp;<span>总共：<input type="text" value="${all}" readonly style="width:30px ">条数据</span>
            </div>
        </div>
    </div>
</div>
</body>
</html>