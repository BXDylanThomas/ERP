<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <link rel="stylesheet" href="resource/css/next.css">
    <link rel="stylesheet" href="resource/css/button.css">
    <title></title>
    <style>
        #main a{
            margin: 10px 0px;
        }
    </style>
</head>
<body>
<div style="margin:0 auto;width: 80%">
    <jsp:include page="../base.jsp" />

    <div id="next">
        <div id="main" >
            <a href="toTrainDepartment" class="send">查看部门培训</a><br/>
            <a href="queryAllTrainEmployee" class="send">查看员工培训</a>
        </div>
    </div>
</div>
</body>

</html>