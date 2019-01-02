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
                    <a href="queryDepartment">部门管理</a>
                </li>
                <li class="menu">
                    <a href="queryALlPosition">职位管理</a>
                </li>
                <li class="menu">
                    <a href="queryAllEmployee">员工管理</a>
                </li>
                <li class="menu">
                    <a href="queryAllRecruitment">招聘管理</a>
                </li>
                <li class="menu">
                    <a href="toTrain">培训管理</a>
                </li>
                <li class="menu">
                    <a href="">薪资结算</a>
                </li>
            </ul>
        </div>
    </div>
</div>
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
</body>
</html>