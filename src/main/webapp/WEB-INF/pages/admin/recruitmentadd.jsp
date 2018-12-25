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
    <link rel="stylesheet" href="resource/css/recruitmentadd.css">
    <script src="resource/js/jquery-3.3.1.js"></script>
    <script src="resource/js/recruitment.js"></script>

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
        <form method="post" action="addRecruitment">
            <table border="1" rules="all">
                <tr>
                    <th colspan="3">招聘</th>
                </tr>
                <tr>
                    <th>部门：</th>
                    <td colspan="2">
                        <select id="department">
                            <option>请选择部门</option>
                            <c:forEach items="${sessionScope.positions}" var="d">
                                <option value="${d.department.id}">${d.department.name}</option>
                            </c:forEach>
                            <otion>12</otion><otion>12</otion>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>职位：</th>
                    <td colspan="2">
                        <select id="position" name="posId">
                            <option>请选择职位</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th >标题</th>
                    <td colspan="2"><input type="text" name="title" required> </td>
                </tr>
                <tr>
                    <th colspan="3">招聘要求</th>
                </tr>
                <tr>
                    <td colspan="3">
                      <textarea name="content" required> </textarea>
                    </td>
                </tr>
                <tr></tr>
                <tr></tr>
                <tr>
                    <th>招聘人数：</th>
                    <td colspan="2"><input type="text" name="count" required>个</td>
                </tr>
            </table>
            <input type="submit" value="确认" id="submit">
        </form>
    </div>
</div>

</body>
</html>