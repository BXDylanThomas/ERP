<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <link rel="stylesheet" href="resource/css/button.css">
    <title></title>
    <style>
        #next a{
            position: relative;
            left: 310px;
            margin: 30px;
            width: 200px;
            height: 50px;
        }
    </style>
</head>
<body>
<div style="margin:0 auto;width: 80%">
<jsp:include page="../base.jsp" />
    <div id="next">
        <div id="main">
            <a href="empQueryTrainDepartment?accId=${sessionScope.user.id}&current=1" class="send">查看部门培训</a>
            <a href="empQueryTrainEmployee?accId=${sessionScope.user.id}&current=1" class="send">查看个人培训</a>
        </div>

    </div>
</div>
</body>

</body>
</html>