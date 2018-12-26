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
    <link rel="stylesheet" href="resource/css/table.css">
    <link rel="stylesheet" href="resource/css/page.css">
    <script src="resource/js/jquery-3.3.1.js"></script>
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
                    <a href="">主页</a>
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
            <a href="toRecruitment" id="add">添加招聘</a>
            <c:if test="${recruitment==null || empty recruitment}">
                <td colspan="3">没有数据</td>
            </c:if>
            <c:if test="${recruitment!=null || not empty recruitment}">
                <c:forEach items="${recruitment}" var="r">
                    <table border="1" rules="all">
                        <tr>
                            <th colspan="3">招聘</th>
                            <td rowspan="10" style="width: 80px">
                                <a href="queryrecruitmentRecord?recId=${r.id}">查看简历</a><br/>
                                <a href="deleteRecruitment?id=${r.id}" onclick= "if(confirm( '是否确定！ ')==false)return   false; ">删除</a>
                            </td>
                        </tr>
                        <tr>
                            <th>部门：</th>
                            <td colspan="2">  ${r.positions.department.name} </td>
                        </tr>
                        <tr>
                            <th>职位：</th>
                            <td colspan="2"> ${r.positions.name}  </td>
                        </tr>
                        <tr>
                            <th >标题</th>
                            <td colspan="2">${r.title}</td>
                        </tr>
                        <tr>
                            <th colspan="3">招聘要求</th>
                        </tr>
                        <tr>
                            <td colspan="3">${r.content}</td>
                        </tr>
                        <tr></tr>
                        <tr></tr>
                        <tr>
                            <th>招聘人数：</th>
                            <td colspan="2">${r.count}个</td>
                        </tr>
                        <tr>
                            <th>招聘时间：</th>
                            <td colspan="2">${r.createTime}</td>
                        </tr>

                     </table>
                    <br/><br/>
                </c:forEach>
            </c:if>
        </div>

        <div id="page">
            <span>页数：</span>
            <a href="queryAllRecruitment?current=1">首页</a>
            <a href="queryAllRecruitment?current=${prepages}">上一页</a>
            <c:forEach  var ="i" begin="1" end="${pages}">
                <a href="queryAllRecruitment?current=${i}">${i}</a>
            </c:forEach>
            <a href="queryAllRecruitment?current=${nextpages}">下一页</a>
            &emsp;<span>总共：<input type="text" value="${all}" readonly style="width:30px ">条数据</span>
        </div>
    </div>
</div>
</body>
</html>