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
</head>
<body>
<div style="margin:0 auto;width: 80%">
    <jsp:include page="base.jsp" />
    <div><img src="resource/image/imag1.jpg" style="width: 1210px;height: 600px"></div>
</div>
</body>
</html>