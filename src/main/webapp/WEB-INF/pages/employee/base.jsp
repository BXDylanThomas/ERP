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
    <link rel="stylesheet" href="resource/css/qq.css">
    <link rel="stylesheet" href="resource/css/aa.css">
    <style>
        *{
            margin: 0px;
            padding: 0px;
        }
        #top{
            width: 100%;
            height: 30px;
            background: aliceblue;
            text-align: right;
        }
        .welcome{
            position: relative;
            left: -50px;
        }
    </style>
</head>
<body>

<div >
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
    <div  class="navbar navbar-default" >
        <div >
            <ul class="nav navbar-nav navbar-right margin-top cl-effect-2 title-custom" style="position: relative;left: -500px;" >
                <li><a href="returnEmployee"><span data-hover="首页">首页&emsp;</span></a></li>
                <li><a href="toemployeeinfo"><span data-hover="个人信息">个人信息&emsp;</span></a></li>
                <li><a href="queryAllEmployeeemp"><span data-hover="员工查询">员工查询&emsp;</span></a></li>
                <li><a href="queryCheckRecord"><span data-hover="查看考勤">查看考勤&emsp;</span></a></li>
                <li><a href="toEmpQueryTrain"><span data-hover="查看培训">查看培训&emsp;</span></a></li>
                <li><a href="toSalary"><span data-hover="查看薪资">查看薪资&emsp;</span></a></li>
            </ul>
        </div>
    </div>
</div>

</div>

</body>

</body>
</html>