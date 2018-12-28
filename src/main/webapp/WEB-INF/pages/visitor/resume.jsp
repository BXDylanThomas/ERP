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

    <style>
        input{
            border: none;
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
        <c:if test="${resume==null || empty resume}">
            <span>暂无简历，去<a href="toresumemake">添加</a></span>
        </c:if>
        <c:if test="${resume!=null || not empty resume}">
            <form method="post" action="updateresumemake" id="f">
                <input type="hidden" name="id" value="${resume.id}">
                <input type="hidden" name="accId" value="${resume.accId}">
                <table border="1" rules="all">
                    <tr>
                        <th colspan="4">简历</th>
                    </tr>
                    <tr>
                        <th>姓名：</th>
                        <td><input type="text" value="${resume.name}" name="name" readonly></td>
                        <th>性别：</th>
                        <td><input type="text" value="${resume.sex}" name="sex" readonly></td>
                    </tr>
                    <tr>
                        <th>出身年月：</th>
                        <td><input type="date" value="${resume.birth}" name="birth" readonly ></td>
                        <th>联系电话：</th>
                        <td><input type="text" value="${resume.phone}" name="phone" readonly></td>
                    </tr>
                    <tr>
                        <th>专业：</th>
                        <td><input type="text" value="${resume.major}" name="major" readonly></td>
                        <th>最高学历：</th>
                        <td><input type="text" value="${resume.education}" name="education" readonly></td>
                    </tr>
                    <tr>
                        <th>邮箱：</th>
                        <td colspan="3"><input type="text" value="${resume.email}" name="email" readonly></td>
                    </tr>
                    <tr>
                        <th>联系地址：</th>
                        <td colspan="3"><input type="text" value="${resume.address}" name="address" readonly></td>
                    </tr>
                    <tr>
                        <th colspan="4">工作经验：</th>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <textarea name="exp" required readonly>
                                    ${resume.exp}
                            </textarea>
                        </td>
                    </tr>
                </table>
                <div>
                    <input type="button" value="修改" id="sub">
                </div>
            </form>
        </c:if>
    </div>

    <script src="resource/js/jquery-3.3.1.js"></script>
    <script src="resource/js/resume.js"></script>
</body>
</html>