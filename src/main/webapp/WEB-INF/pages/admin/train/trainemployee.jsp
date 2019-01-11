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
    <link rel="stylesheet" href="resource/css/table.css">
    <link rel="stylesheet" href="resource/css/traininput.css">

    <script src="resource/js/jquery-3.3.1.js"></script>
    <script src="resource/js/trainemployee.js"></script>
    <style>
        td{
            width: 150px;
            height: 40px;
            text-align: center;
        }
        .title{
            margin: 20px;
            font-size: 25px;
        }
    </style>
</head>
<body>
<div style="margin:0 auto;width: 80%">
<jsp:include page="../base.jsp" />


<div id="next">
    <div id="main">
        <br/>
        <a href="toAddAllTrainEmployee" class="send">添加员工培训</a>  &emsp; &emsp;

       <select id="choice">
           <option value="-1" selected>请选择</option>
           <option value="1">已发布</option>
           <option value="0">未发布</option>
       </select><br/>
        <div style="position: relative;left: 100px;margin: 20px 0px">
            <c:if test="${trains==null || empty trains}">
                <span>没有数据</span>
            </c:if>
            <c:if test="${trains!=null || not empty trains}">
                <c:forEach items="${trains}" var="t">
                    <a href="querytrainemployeeone?id=${t.id}" class="title">${t.title}</a><br/>
                </c:forEach>
            </c:if>
        </div>

    </div>

    <div id="xia">
        <div id="page">
            <span>页数：</span>
            <a href="queryAllTrainEmployee?current=1">首页</a>
            <a href="queryAllTrainEmployee?current=${prepages}">上一页</a>
            <c:forEach  var ="i" begin="1" end="${pages}">
                <a href="queryAllTrainEmployee?current=${i}">${i}</a>
            </c:forEach>
            <a href="queryAllTrainEmployee?current=${nextpages}">下一页</a>
            &nbsp;<span>总共：<input type="text" value="${all}" readonly style="width:30px ">条数据</span>
        </div>
    </div>
</div>
</div>
</body>
</html>