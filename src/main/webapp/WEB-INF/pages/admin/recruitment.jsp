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
    <script src="resource/js/jquery-3.3.1.js"></script>
    <script src="resource/js/department.js"></script>
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
    <div id="introduce"><span>XXXXX公司</span></div>
    <div id="guid">
        <div id="guid2">
            <ul>
                <li class="menu">
                    <a href="">主页</a>
                </li>
                <li class="menu">
                    <a href="queryDepartment">部门管理</a>
                </li>
                <li class="menu">
                    <a href="queryALlPosition">职位管理</a>
                </li>
                <li class="menu">
                    <a href="">员工管理</a>
                </li>
                <li class="menu"  id="a">
                    <a href="queryAllRecruitment">招聘管理</a>
                </li>
                <li class="menu">
                    <a href="">培训管理</a>
                </li>
                <li class="menu">
                    <a href="">查看考勤</a>
                </li>
                <li class="menu">
                    <a href="">薪资结算</a>
                </li>
                <li class="menu">
                    <a href="">查看奖惩记录</a>
                </li>
            </ul>
        </div>
    </div>
</div>

<div id="next">
    <div >
        <div id="main">
            <a href="javascript:void(0)" id="add">添加招聘</a>
            <table>
                <tr>
                    <th>部门</th>
                    <th>职位</th>
                    <th>招聘主题</th>
                    <th>招聘要求</th>
                    <th>招聘人数</th>
                    <th>发布时间</th>
                    <th></th>
                </tr>

                <c:if test="${recruitment==null}">
                    <td colspan="3">没有数据</td>
                </c:if>
                <c:if test="${recruitment!=null}">
                    <c:forEach items="${recruitment}" var="r">
                        <tr>
                            <td>${r.positions.department.name}</td>
                            <td>${r.positions.name}</td>
                            <td>${r.title}</td>
                            <td>${r.content}</td>
                            <td>${r.count}</td>
                            <td>${r.createTime}</td>
                            <td><a href="deleteRecruitment?id=${r.id}" onclick= "if(confirm( '是否确定！ ')==false)return   false; ">删除</a></td>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>
        </div>

        <div id="page">
            <span>页数：</span>
            <a href="queryAllRecruitment?current=1">首页</a>
            <a href="queryAllRecruitment?current=${prepages}">上一页</a>
            <c:forEach  var ="i" begin="1" end="${pages}">
                <a href="queryAllRecruitment?current=${i}">${i}</a>
            </c:forEach>
            <a href="queryAllRecruitment?current=${nextpages}">下一页</a>
            &nbsp;<span>总共：<input type="text" value="${all}" readonly id="show">条数据</span>
        </div>
    </div>
</div>
</body>
</html>