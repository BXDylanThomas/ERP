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
    <script src="resource/js/jquery-3.3.1.js"></script>
    <script>
        $(function () {
            $("button").click(function () {
                var result=$("#result").val()
                if(result==1){
                    window.location.href="goWork";
                }else{
                    window.location.href="goHome";
                }
            })
        })
    </script>
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
                    <a href="returnEmployee" id="a">主页</a>
                </li>
                <li class="menu">
                    <a href="toemployeeinfo">个人信息</a>
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
        <div id="main">
            <br/> <br/>
            <input type="hidden" value="${result}" id="result">

            <c:if test="${result==1}">
                <button value="上班打卡">上班打卡</button>
            </c:if>
            <c:if test="${result==2}">
                <button value="下班打卡">下班打卡</button>
            </c:if>
            <c:if test="${result==3}">
               下班成功
            </c:if>
        </div>

    </div>
</body>

</body>
</html>