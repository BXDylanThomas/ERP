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
    <link href="resource/css/base.css">
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
    <div id="introduce"><span>XXXXX公司</span></div>
    <div id="guid">
        <div id="guid2">
            <ul>
                <li class="menu">
                    <a href="returnVisitor">主页</a>
                </li>
                <li class="menu">
                    <a href="">查看招聘</a>
                </li>
                <li class="menu"  id="a">
                    <a href="">个人信息</a>
                    <ul id="query">
                        <li class="menu"><a href="">查看简历</a></li>
                        <li class="menu"><a href="">查看面试邀请</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>

</body>
</html>