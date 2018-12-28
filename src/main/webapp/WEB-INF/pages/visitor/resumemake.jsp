<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <link rel="stylesheet"  href="resource/css/base.css">
    <link rel="stylesheet"  href="resource/css/table.css">
</head>
<body>

<%--base--%>
<div>
    <!--top-->
    <div id="top">
        <%--没有登录--%>
        <c:if test="${sessionScope.user==null}">
            <div class="welcome">
                <a href="returnRegister">免费注册</a>
                <a href="returnLogin">登录</a>
            </div>
        </c:if>
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
                <li class="menu" >
                    <a href="returnVisitor" >主页</a>
                </li>
                <li class="menu">
                    <a href="visitorqueryAllRecruitment">查看招聘</a>
                </li>
                <li class="menu" id="a">
                    <a href="tovisitorInfo">个人信息</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div id="next">
        <form method="post" action="addresumemake">
            <table border="1" rules="all">
                <tr>
                    <th colspan="4">简历</th>
                </tr>
                <tr>
                    <th>姓名：</th>
                    <td><input type="text" name="name" required ></td>
                    <th>性别：</th>
                    <td><input type="text" name="sex" required></td>
                </tr>
                <tr>
                    <th>出身年月：</th>
                    <td><input type="date" name="bir" required></td>
                    <th>联系电话：</th>
                    <td><input type="text" name="phone" required></td>
                </tr>
                <tr>
                    <th>专业：</th>
                    <td><input type="text" name="major" required></td>
                    <th>最高学历：</th>
                    <td><input type="text" name="education"required ></td>
                </tr>
                <tr>
                    <th>邮箱：</th>
                    <td colspan="3"><input type="text" name="email"required ></td>
                </tr>
                <tr>
                    <th>联系地址：</th>
                    <td colspan="3"><input type="text" name="address" required></td>
                </tr>
                <tr>
                    <th colspan="4">工作经验：</th>
                </tr>
                <tr>
                    <td colspan="4">
                        <input type="text" style="width:100%;height:150px" name="experience" required >
                    </td>
                </tr>
            </table>
            <input type="submit" value="确定" id="sub">
        </form>
</div>

</body>
</body>
</html>