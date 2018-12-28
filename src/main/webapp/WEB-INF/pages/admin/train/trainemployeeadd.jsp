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
                <li class="menu" id="a">
                    <a href="toTrain">培训管理</a>
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
    <div id="main">
        <form action="addAllTrainEmployee" method="post">
            <table border="1" rules="all">
                <tr>
                    <th colspan="4">员工培训</th>
                </tr>
                <tr>
                    <th>开始时间</th>
                    <td><input type="date" name="startTime" required></td>
                    <th>结束时间</th>
                    <td><input type="date" name="endTime" required></td>
                </tr>
                <tr>
                    <th>培训主题</th>
                    <td colspan="3"><input type="text" name="title" required></td>
                </tr>
                <tr>
                    <th>培训地点</th>
                    <td colspan="3"><input type="text" name="address" required></td>
                </tr>
                <tr>
                    <th colspan="4">培训内容</th>
                </tr>
                <tr>
                    <td colspan="4">
                        <input type="text" name="content" style="width: 100%;height: 200px" required>
                    </td>
                </tr>
            </table>
            <input type="submit" value="选择员工" id="sub">
        </form>
    </div>
</div>


</body>
</html>