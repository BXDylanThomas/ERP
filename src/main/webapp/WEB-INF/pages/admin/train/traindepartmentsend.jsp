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
    <link rel="stylesheet" href="resource/css/button.css">
    <link rel="stylesheet" href="resource/css/table.css">
    <link rel="stylesheet" href="resource/css/traininput.css">

    <script src="resource/js/jquery-3.3.1.js"></script>
    <script src="resource/js/traindepartment.js"></script>
    <style>
        #main a{
            margin: 10px 0px;
        }
        .title{
            margin: 10px;
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
        <a href="toTrainDepartmentadd" class="send">添加部门培训</a>  &emsp; &emsp;

        <span>查看部门：</span> &nbsp;
        <select id="department">
            <option value="-1" selected>请选择部门</option>
            <c:forEach items="${sessionScope.department}" var="d">
                <option value="${d.id}">${d.name}</option>
            </c:forEach>
        </select>&nbsp;
       <select id="choice">
           <option value="-1">请选择</option>
           <c:if test="${state==1}">
               <option value="1" selected>已发布</option>
               <option value="0" >未发布</option>
           </c:if>
           <c:if test="${state==0}">
               <option value="1">已发布</option>
               <option value="0" selected>未发布</option>
           </c:if>
       </select><br/> <br/>
        <div style="position: relative;left: 50px;margin: 10px 0px">
            <c:if test="${trainDepartment==null || empty trainDepartment}">
                <span>没有数据</span>
            </c:if>
            <c:if test="${trainDepartment!=null || not empty trainDepartment}">
                <c:forEach items="${trainDepartment}" var="t">
                    <a href="queryDepartmentone?id=${t.id}" class="title">${t.train.title}</a>
                </c:forEach>
            </c:if>
        </div>
    </div>

    <div id="xia" style="position: relative; top: 20px;">
        <div id="page">
            <span>页数：</span>
            <a href="queryTrainDepartmentState?current=1&state=${state}">首页</a>
            <a href="queryTrainDepartmentState?current=${prepages}&state=${state}">上一页</a>
            <c:forEach  var ="i" begin="1" end="${pages}">
                <a href="queryTrainDepartmentState?current=${i}&state=${state}">${i}</a>
            </c:forEach>
            <a href="queryTrainDepartmentState?current=${nextpages}&state=${state}">下一页</a>
            &nbsp;<span>总共：<input type="text" value="${all}" readonly style="width:30px ">条数据</span>
        </div>
    </div>
</div>
</div>
</body>
</html>