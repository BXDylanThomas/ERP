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
                        <a href="toemployeeinfo" id="a">个人信息</a>
                    </li>
                    <li class="menu">
                        <a href="queryAllEmployeeemp">员工查询</a>
                    </li>
                    <li class="menu">
                        <a href="queryCheckRecord">查看考勤</a>
                    </li>
                    <li class="menu">
                        <a href="toEmpQueryTrain">查看培训</a>
                    </li>
                    <li class="menu">
                        <a href="">查看薪资</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div id="next">
        <br/><a href="toinfoemployee">信息详情</a>
        <br/><br/><br/><a href="toemployeechangepass">修改密码</a>
    </div>
</body>
</body>
</html>