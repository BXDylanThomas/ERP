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
    <link rel="stylesheet" href="resource/css/depposemp.css">
    <style>
        #next{
            position: relative;
            left: 300px;
            top: 20px;
        }
        #main span{
           font-size: 22px;
       }
    </style>
</head>
<body>
<div style="margin:0 auto;width: 80%">
    <jsp:include page="base.jsp" />
    <div id="next" >
        <div id="main">
            <c:if test="${recruitmentRecords==null || empty recruitmentRecords}">
                <span>没有面试邀请</span>
            </c:if>

            <c:if test="${recruitmentRecords!=null || not empty recruitmentRecords}">
                <table>
                    <c:forEach items="${recruitmentRecords}" var="r">
                        <tr>
                            <th>部门：</th>
                            <td>${r.recruitment.positions.department.name}</td>
                            <th>职位：</th>
                            <td>${r.recruitment.positions.name}</td>
                            <th>面试时间：</th>
                            <td>${r.time}</td>
                            <th>基本工资：</th>
                            <td>${r.resume.salary.money}</td>
                            <td><a href="sureOffer?id=${r.id}">接受邀请</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
        <div id="xia">
            <div id="page">
                <span>页数：</span>
                <a href="queryResumeaccId?current=1">首页</a>
                <a href="queryResumeaccId?current=${prepages}">上一页</a>
                <c:forEach  var ="i" begin="1" end="${pages}">
                    <a href="queryResumeaccId?current=${i}">${i}</a>
                </c:forEach>
                <a href="queryResumeaccId?current=${nextpages}">下一页</a>
                &nbsp;<span>总共：<input type="text" value="${all}" readonly style="width:30px ">条数据</span>
            </div>
        </div>
    </div>
</div>

</body>
</body>
</html>