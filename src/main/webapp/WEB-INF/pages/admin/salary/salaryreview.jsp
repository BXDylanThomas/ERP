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
    <link rel="stylesheet" href="resource/css/button.css">
    <link rel="stylesheet" href="resource/css/next.css">
    <link rel="stylesheet" href="resource/css/page.css">
    <style>
        td{
            width: 200px;
            height: 40px;
            text-align: center;
        }
    </style>
</head>
<body>
<div style="margin:0 auto;width: 80%">
    <jsp:include page="../base.jsp" />
    <div id="next">
        <c:if test="${salaryReviews==null || empty salaryReviews}">
            暂无数据
        </c:if>
        <c:if test="${salaryReviews!=null || not empty salaryReviews}">
            <table border="1" rules="all">
                <tr>
                    <td>姓名</td>
                    <td>原因</td>
                    <td>时间</td>
                    <td></td>
                </tr>
                    <c:forEach items="${salaryReviews}" var="s">
                    <tr>
                        <td>${s.employee.resume.name}</td>
                        <td>${s.reason}</td>
                        <td>${s.time}</td>
                        <td><a href="salaryReviewsAgree?id=${s.id}&empId=${s.empId}" class="send">同意</a>
                            &nbsp;<a href="salaryReviewsRefuse?id=${s.id}"  class="send">拒绝</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <div id="xia">
            <div id="page">
                <span>页数：</span>
                <a href="queryAllReviewSalary?current=1">首页</a>
                <a href="queryAllReviewSalary?current=${prepages}">上一页</a>
                <c:forEach  var ="i" begin="1" end="${pages}">
                    <a href="queryAllReviewSalary?current=${i}">${i}</a>
                </c:forEach>
                <a href="queryAllReviewSalary?current=${nextpages}">下一页</a>
                &nbsp;<span>总共：<input type="text" value="${all}" readonly style="width:30px ">条数据</span>
            </div>
        </div>
    </div>
</div>
</body>
</html>