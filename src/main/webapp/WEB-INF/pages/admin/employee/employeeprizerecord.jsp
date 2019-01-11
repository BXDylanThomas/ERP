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
    <link rel="stylesheet" href="resource/css/next.css">
    <link rel="stylesheet" href="resource/css/page.css">
    <style>
        td,th{
            width: 120px;
            height: 40px;
            line-height: 40px;
            text-align: center;
        }
    </style>
</head>
<body>
<div style="margin:0 auto;width: 80%">
<jsp:include page="../base.jsp" />

<div id="next">
        <div id="main">
            <br/> <br/>
            <table border="1" rules="all">
                <tr>
                    <th style="width: 200px">时间</th>
                    <th>原因</th>
                    <th>金额</th>
                </tr>
                <c:if test="${prizeRecords==null || empty prizeRecords}">
                    <tr>
                        <td colspan="3">没有数据</td>
                    </tr>
                </c:if>
                <c:if test="${prizeRecords!=null && not empty prizeRecords}">
                    <c:forEach items="${prizeRecords}" var="p">
                        <tr>
                            <td style="width: 200px">${p.time}</td>
                            <td >${p.reason}</td>
                            <td >${p.money}</td>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>

            <div id="xia">
                <div id="page">
                    <span>页数：</span>
                    <a href="queryAdminPrizeRecordEmpId?current=1">首页</a>
                    <a href="queryAdminPrizeRecordEmpId?current=${prepages}">上一页</a>
                    <c:forEach  var ="i" begin="1" end="${pages}">
                        <a href="queryAdminPrizeRecordEmpId?current=${i}">${i}</a>
                    </c:forEach>
                    <a href="queryAdminPrizeRecordEmpId?current=${nextpages}">下一页</a>
                    &nbsp;<span>总共：<input type="text" value="${all}" readonly style="width:30px ">条数据</span>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>