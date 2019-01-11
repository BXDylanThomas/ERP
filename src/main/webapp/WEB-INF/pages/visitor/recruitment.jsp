<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <link rel="stylesheet" href="resource/css/page.css">
    <style>
        #next{
            position: relative;
            left: 300px;
            top: 20px;
        }
        .title{
            margin: 10px;
            font-size: 25px;
        }
    </style>
</head>
<body>
<div style="margin:0 auto;width: 80%">

    <jsp:include page="base.jsp" />

    <div id="next">
         <div>
            <c:if test="${recruitment==null}">
                <td colspan="3">没有数据</td>
            </c:if>
            <c:if test="${recruitment!=null}">
                <c:forEach items="${recruitment}" var="r">
                    <a href="visitorqueryOneRecruitment?id=${r.id}" class="title">${r.title}</a>
                    <br/>
                </c:forEach>
            </c:if>
        </div>
        <div id="xia">
            <div id="page">
                <span>页数：</span>
                <a href="visitorqueryAllRecruitment?current=1">首页</a>
                <a href="visitorqueryAllRecruitment?current=${prepages}">上一页</a>
                <c:forEach  var ="i" begin="1" end="${pages}">
                    <a href="visitorqueryAllRecruitment?current=${i}">${i}</a>
                </c:forEach>
                <a href="visitorqueryAllRecruitment?current=${nextpages}">下一页</a>
                &nbsp;<span>总共：<input type="text" value="${all}" readonly style="width:30px ">条数据</span>
            </div>
        </div>
    </div>
</div>
</body>

</html>