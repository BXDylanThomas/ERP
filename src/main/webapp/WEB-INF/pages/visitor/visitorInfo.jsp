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
    <link rel="stylesheet" href="resource/css/button.css"/>
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

<jsp:include page="base.jsp" />

<div id="next">
    <div>
        <a href="queryResume" class="send">查看简历</a><br/>
        <a href="queryResumeaccId" class="send">查看面试邀请</a>
    </div>
</div>

</div>
</body>
</html>