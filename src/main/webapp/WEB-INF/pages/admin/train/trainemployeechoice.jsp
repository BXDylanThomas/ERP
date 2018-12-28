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
    <link rel="stylesheet" href="resource/css/base.css">
    <style>
        input[type=text]{
            border: none;
        }
        #sub{
            position: relative;
            left: 140px;
            top: 8px;
            width:  100px;
            height: 40px;
            background: red;
            color: white;
            border: none;
            margin: 0px;
            padding: 0px;
        }
    </style>
</head>
<body>
<div>
    <!--top-->
    <div id="top">
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
                <li class="menu">
                    <a href="returnEmployee">主页</a>
                </li>
                <li class="menu">
                    <a href="queryDepartment">部门管理</a>
                </li>
                <li class="menu">
                    <a href="queryALlPosition">职位管理</a>
                </li>
                <li class="menu">
                    <a href="queryAllEmployee">员工管理</a>
                </li>
                <li class="menu">
                    <a href="queryAllRecruitment">招聘管理</a>
                </li>
                <li class="menu" id="a">
                    <a href="toTrain">培训管理</a>
                </li>
                <li class="menu">
                    <a href="">查看考勤</a>
                </li>
                <li class="menu">
                    <a href="">薪资结算</a>
                </li>
                <li class="menu">
                    <a href="">查看奖惩记录</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div id="next"></div>
    <div id="main" style="position: relative;left: 600px;top: 40px;">

        <form action="addAllTrainEmployeeChoice" method="post">
            <c:forEach items="${employees}" varStatus="ct" var="e">
                <input type="checkbox" name="choice" value="${e.id}">
                <input type="text"value="${e.resume.name}">&emsp;
                <c:if test="${ct.count %5==0}"><br/></c:if>
            </c:forEach><br/>
            <input type="submit" value="确定添加" id="sub">
        </form>

    </div>
</body>
</html>