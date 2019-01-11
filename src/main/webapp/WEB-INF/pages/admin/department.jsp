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
    <link rel="stylesheet" href="resource/css/depposemp.css">
    <link rel="stylesheet" href="resource/css/button.css">
    <link rel="stylesheet" href="resource/css/page.css">
    <script src="resource/js/jquery-3.3.1.js"></script>
    <script src="resource/js/alert.js"></script>
    <script src="resource/js/department.js"></script>
    <style>
        #next{
            position: relative;
            left: 200px;
        }
        th,td{
            text-align: center;
        }
    </style>
</head>
<body>
<div style="margin:0 auto;width: 80%">
<jsp:include page="base.jsp" />
<div id="next">

    <div id="main">

        <br/>
        <span id="addpos" style="font-size: 20px;" >添加职务</span> &emsp;
        &emsp;
        <tr >
            <td></td>
            <td><input type='text'id='newadd' required style="background: lightcyan;border: 1px black solid"> </td>
            <td></td>
            <td><a href="javascript:void(0)" id='add3' class="send" style="height: 40px">确认添加</a></td>
        </tr>
        <br/><br/>

        <table>
            <tr>
                <th><input type="checkbox" id="all"><label for="all">全选</label></th>
                <th>部门名称</th>
                <th>创建时间</th>
                <th></th>

            </tr>
            <c:if test="${department==null || empty department}">
                <td colspan="4">没有数据</td>
            </c:if>
            <c:if test="${department!=null || not empty department  }">
                <c:forEach items="${department}" var="d">
                    <tr>
                        <td><input type="checkbox" class="check" value="${d.id}"></td>
                        <td><input value="${d.name}" disabled></td>
                        <td class="time">${d.createTime}</td>
                        <td><a href="javascript:void(0)" class="update">修改</a><input type="hidden" value="${d.id}"></td>
                    </tr>
                </c:forEach>
            </c:if>

            <tr id="ad">
                <td><a href="javascript:void(0)" id="del" class="send"  style="height: 40px">删除</a></td>
            </tr>
        </table>
    </div>
    <div id="xia">
        <div id="page">
            <span>页数：</span>
            <a href="queryDepartment?current=1">首页</a>
            <a href="queryDepartment?current=${prepages}">上一页</a>
            <c:forEach  var ="i" begin="1" end="${pages}">
                <a href="queryDepartment?current=${i}">${i}</a>
            </c:forEach>
            <a href="queryDepartment?current=${nextpages}">下一页</a>
            &nbsp;<span>总共：<input type="text" value="${all}" readonly style="width:30px ">条数据</span>
        </div>
    </div>

</div>
</div>


</body>
</html>