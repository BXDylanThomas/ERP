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
    <div >
        <div id="main">
            <br/>
            <span id="addpos"style="font-size: 20px;">添加职务</span>
            &emsp;
            <tr >
                <td></td>
                <td><select id="sel">
                    <option>选择部门</option>
                    <c:forEach items="${sessionScope.allDepartment}" var="d">
                        <option value="${d.id}">${d.name}</option>
                    </c:forEach>
                </select>
                </td>
                <td><input id="name" value="${p.name}" style="background: lightcyan;border: 1px black solid"></td>
                <td></td>
                <td><a href="javascript:void(0)"id="addsure"  class="send" style="height: 40px">确认添加</a></td>
            </tr>
            <br/><br/>
            &emsp;
            <span>查询部门：</span>
            <select id="select">
                <option>请选择</option>
                <c:forEach items="${sessionScope.allDepartment}" var="d">
                    <option value="${d.id}">${d.name}</option>
                </c:forEach>
            </select>
            <br/>
            <table>
                <tr>
                    <th><input type="checkbox" id="all"><label for="all">全选</label></th>
                    <th>部门名称</th>
                    <th>职务名称</th>
                    <th>创建时间</th>
                    <th></th>
                </tr>
                <c:if test="${position==null || empty position}">
                    <td colspan="5">没有数据</td>
                </c:if>
                <c:if test="${position!=null || not empty position}">
                    <c:forEach items="${position}" var="p">
                        <tr>
                            <td><input type="checkbox" class="check" value="${p.id}"></td>
                            <td>${p.department.name}</td>
                            <td><input value="${p.name}"disabled></td>
                            <td class="time">${p.createTime }</td>
                            <td><a href="javascript:void(0)"class="update">修改</a><input type="hidden" value="${p.id}"></td>
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
                <a href="queryALlPosition?current=1">首页</a>
                <a href="queryALlPosition?current=${prepages}">上一页</a>
                <c:forEach  var ="i" begin="1" end="${pages}">
                    <a href="queryALlPosition?current=${i}">${i}</a>
                </c:forEach>
                <a href="queryALlPosition?current=${nextpages}">下一页</a>
                &nbsp;<span>总共：<input type="text" value="${all}" readonly style="width:30px ">条数据</span>
            </div>
        </div>

    </div>
</div>
</div>
<script src="resource/js/jquery-3.3.1.js"></script>
<script src="resource/js/alert.js"></script>
<script src="resource/js/position.js"></script>
</body>
</html>