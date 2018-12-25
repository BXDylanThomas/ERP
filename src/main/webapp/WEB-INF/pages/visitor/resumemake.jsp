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
    <link rel="stylesheet"  href="resource/css/resume.css">
    <style>
        input{
            background: lightcyan;
        }
        td{
            padding: 1px;
        }
    </style>
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
    <div id="introduce"><span>XXXXX公司</span></div>
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
                    <td><input type="text" name="birth" required></td>
                    <th>联系电话：</th>
                    <td><input type="text" name="phone" required></td>
                </tr>
                <tr>
                    <th>专业：</th>
                    <td><input type="text" name="major" required></td>
                    <th>最高学历：</th>
                    <td><input type="text" name="education" required></td>
                </tr>
                <tr>
                    <th>邮箱：</th>
                    <td colspan="3"><input type="text" name="email" required></td>
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
                        <textarea style="width: 500px" name="experience" required>

                        </textarea>
                    </td>
                </tr>
            </table>

            <input type="submit" value="确定" id="sub">
        </form>
</div>

</body>
</body>
</html>