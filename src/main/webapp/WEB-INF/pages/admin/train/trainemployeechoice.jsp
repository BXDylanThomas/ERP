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
    <link rel="stylesheet" href="resource/css/button.css">
    <link rel="stylesheet" href="resource/css/next.css">
    <style>
        input[type=text]{
            border: none;
        }
    </style>
</head>
<body>
<div style="margin:0 auto;width: 80%">
    <jsp:include page="../base.jsp" />

    <div id="next">
        <div id="main" >

            <form action="addAllTrainEmployeeChoice" method="post">
                <c:forEach items="${employees}" varStatus="ct" var="e">
                    <input type="checkbox" name="choice" value="${e.id}">
                    <input type="text"value="${e.resume.name}">&emsp;
                    <c:if test="${ct.count %5==0}"><br/></c:if>
                </c:forEach><br/>
                <input type="submit" value="确定添加" id="sub" class="send" style="margin-top: 20px;position:relative;left: 100px;">
            </form>

        </div>
    </div>

</div>
</body>
</html>