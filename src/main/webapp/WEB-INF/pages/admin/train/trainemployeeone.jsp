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

    <script src="resource/js/jquery-3.3.1.js"></script>
    <script src="resource/js/trainemployee.js"></script>
    <style>
        td{
            width: 150px;
            height: 40px;
            text-align: center;
        }
        input{
            border: none;
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body>
<div style="margin:0 auto;width: 80%">
<jsp:include page="../base.jsp" />


<div id="next">
    <div id="main">
        <table border="1" rules="all">
            <tr>
                <td colspan="4">员工培训</td>
            </tr>
            <tr>
                <td>状态</td>
                <td  style="width: 350px" colspan="2">
                    <c:set var="flag" value="true"></c:set>
                    <c:forEach items="${trainEmployee}" var="te">
                        <c:if test="${flag}">
                            <c:if test="${te.tId==t.id}">
                                <c:if test="${te.state==0}">
                                    <a href="publicshTrainEmployee?id=${t.id}" class="send" onclick= "if(confirm( '是否确定！ ')==false)return   false; ">去发布</a>
                                    &emsp;<a href="updateTrainEmployee?id=${t.id}" class="send">修改</a>
                                    &emsp;<a href="deleteTrainEmployee?id=${t.id}" class="send" onclick= "if(confirm( '是否确定！ ')==false)return   false; ">删除</a>
                                </c:if>
                                <c:if test="${te.state==1}">
                                    已发布
                                </c:if>
                                <c:set var="flag" value="false"></c:set>
                            </c:if>
                        </c:if>
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td colspan="4"rowspan="2" >
                    <b>姓名：</b>
                    <c:forEach items="${trainEmployee}"  varStatus="ct"  var="te">
                        <c:if test="${te.tId==t.id}">
                            ${te.employee.resume.name},
                        </c:if>
                    </c:forEach>
                </td>
            </tr>
            <tr></tr>

            <tr>
                <td>开始时间</td>
                <td><input type="date" name="startTime" value="${t.startTime}"readonly ></td>
                <td>结束时间</td>
                <td><input type="date" name="endTime"  value="${t.endTime}"  readonly></td>
            </tr>
            <tr>
                <td>培训主题</td>
                <td colspan="3"><input type="text" name="title" value="${t.title}" readonly></td>
            </tr>
            <tr>
                <td>培训地点</td>
                <td colspan="3"><input type="text" name="address"  value="${t.address}" readonly></td>
            </tr>
            <tr>
                <td colspan="4">培训内容</td>
            </tr>
            <tr>
                <td colspan="4">
            <textarea type="text" name="content" style="width: 100%;height: 100px" readonly>
                    ${t.content}
            </textarea>
                </td>
            </tr>
        </table>

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