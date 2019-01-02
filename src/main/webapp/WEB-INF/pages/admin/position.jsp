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
    <link rel="stylesheet" href="resource/css/depposemp.css">
    <link rel="stylesheet" href="resource/css/page.css">
    <style>
        input{
            background: white;
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
                    <a href="returnEmployee">主页</a>
                </li>
                <li class="menu" >
                    <a href="queryDepartment">部门管理</a>
                </li>
                <li class="menu" id="a">
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
    <div >
        <div id="main">
            <br/>
            <span id="addpos" >添加职务</span>
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
                <td><a href="javascript:void(0)"id="addsure">确认添加</a></td>
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
                    <td><a href="javascript:void(0)" id="del">删除</a></td>
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

<script src="resource/js/jquery-3.3.1.js"></script>
<script src="resource/js/position.js"></script>

</body>
</html>