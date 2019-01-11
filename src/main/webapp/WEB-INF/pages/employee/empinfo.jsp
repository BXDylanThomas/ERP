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
        <a href="toinfoemployee" class="send">信息详情</a>
        <a href="toemployeechangepass" class="send">修改密码</a>
    </div>
</div>
</body>
</body>
</html>