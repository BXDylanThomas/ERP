<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <link rel="stylesheet"  href="resource/css/base.css">
    <link rel="stylesheet" href="resource/css/page.css">
    <link rel="stylesheet" href="resource/css/depposemp.css">
</head>
<body>

<%--base--%>
<div>
    <!--top-->
    <div id="top">
        <%--没有登录--%>
        <c:if test="${sessionScope.user==null}">
            <div class="welcome">
                <a href="returnRegister">免费注册</a>
                <a href="returnLogin">登录</a>
            </div>
        </c:if>
        <c:if test="${sessionScope.user!=null}">
            <div  class="welcome">
                <span>欢迎：${sessionScope.user.name}</span>
                <a href="exit">退出</a>
            </div>
        </c:if>
    </div>
    <div id="introduce"></div>
    <div id="guid">
        <div id="guid2">
            <ul>
                <li class="menu" >
                    <a href="returnVisitor" >主页</a>
                </li>
                <li class="menu">
                    <a href="visitorqueryAllRecruitment">查看招聘</a>
                </li>
                <li class="menu">
                    <a href="tovisitorInfo" id="a">个人信息</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div id="next" >
    <div id="main">
        <c:if test="${recruitmentRecords==null || empty recruitmentRecords}">
            <td colspan="3">没有面试邀请</td>
        </c:if>

        <c:if test="${recruitmentRecords!=null || not empty recruitmentRecords}">
            <table>
                <c:forEach items="${recruitmentRecords}" var="r">
                    <tr>
                        <th>部门：</th>
                        <td>${r.recruitment.positions.department.name}</td>
                        <th>职位：</th>
                        <td>${r.recruitment.positions.name}</td>
                        <th>面试时间：</th>
                        <td>${r.time}</td>
                        <th>基本工资：</th>
                        <td>${r.resume.salary.money}</td>
                        <td><a href="sureOffer?posId=${r.recruitment.positions.id}">接受邀请</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
    <div id="xia">
        <div id="page">
            <span>页数：</span>
            <a href="queryResumeaccId?current=1">首页</a>
            <a href="queryResumeaccId?current=${prepages}">上一页</a>
            <c:forEach  var ="i" begin="1" end="${pages}">
                <a href="queryResumeaccId?current=${i}">${i}</a>
            </c:forEach>
            <a href="queryResumeaccId?current=${nextpages}">下一页</a>
            &nbsp;<span>总共：<input type="text" value="${all}" readonly style="width:30px ">条数据</span>
        </div>
    </div>
</div>
</body>
</body>
</html>