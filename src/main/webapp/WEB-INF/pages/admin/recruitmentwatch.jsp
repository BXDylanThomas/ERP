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
    <link rel="stylesheet" href="resource/css/watchresume.css">
    <link rel="stylesheet" href="resource/css/page.css">
    <script src="resource/js/jquery-3.3.1.js"></script>
    <script>
        $(function () {
            $("#add").click(function () {
                $("#fo").submit();
            })
        })
    </script>
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
                <li class="menu"  id="a">
                    <a href="queryAllRecruitment">招聘管理</a>
                </li>
                <li class="menu">
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
    <div >
        <div id="main">
            <c:if test="${recruitmentRecords==null || empty recruitmentRecords}">
                <td colspan="3">没有数据</td>
            </c:if>
            <c:if test="${recruitmentRecords!=null || not empty recruitmentRecords}">

                <c:forEach items="${recruitmentRecords}" var="r">
                    <table border="1" rules="all">
                        <tr>
                            <th colspan="4">简历</th>
                        </tr>
                        <tr>
                            <th>姓名：</th>
                            <td><input type="text" value="${r.resume.name}" name="name" readonly></td>
                            <th>性别：</th>
                            <td><input type="text" value="${r.resume.sex}" name="sex" readonly></td>
                        </tr>
                        <tr>
                            <th>出身年月：</th>
                            <td><input type="text" value="${r.resume.birth}" name="birth" readonly></td>
                            <th>联系电话：</th>
                            <td><input type="text" value="${r.resume.phone}" name="phone" readonly></td>
                        </tr>
                        <tr>
                            <th>专业：</th>
                            <td><input type="text" value="${r.resume.major}" name="major" readonly></td>
                            <th>最高学历：</th>
                            <td><input type="text" value="${r.resume.education}" name="education" readonly></td>
                        </tr>
                        <tr>
                            <th>邮箱：</th>
                            <td colspan="3"><input type="text" value="${r.resume.email}" name="email" readonly></td>
                        </tr>
                        <tr>
                            <th>联系地址：</th>
                            <td colspan="3"><input type="text" value="${r.resume.address}" name="address" readonly></td>
                        </tr>
                        <tr>
                            <th colspan="4">工作经验：</th>
                        </tr>
                        <tr>
                            <td colspan="4">
                            <textarea name="experien" required readonly>
                                    ${r.resume.exp}
                            </textarea>
                            </td>
                        </tr>
                    </table>
                    <div style="position: relative;left: 430px;top: -180px;">
                        <form action="sendoffer" method="post" id="fo">
                            <input type="hidden" value="${r.resume.id}" name="resId">
                            <input type="hidden" value="${r.id}" name="recRRId">
                            <label for="sa">基本工资：</label>
                            <input type="number"  name="money" required id="sa" style="width: 100px;height: 20px;border: 1px black solid" ><br/>
                            <a href="javascript:void(0)" id="add" style="position: relative;left: 55px;top: 10px;">邀请面试</a>
                        </form>
                    </div>
                </c:forEach>
            </c:if>
        </div>

        <div id="xia">
            <div id="page">
                <span>页数：</span>
                <a href="queryrecruitmentRecord?current=1">首页</a>
                <a href="queryrecruitmentRecord?current=${prepages}">上一页</a>
                <c:forEach  var ="i" begin="1" end="${pages}">
                    <a href="queryrecruitmentRecord?current=${i}">${i}</a>
                </c:forEach>
                <a href="queryrecruitmentRecord?current=${nextpages}">下一页</a>
                &nbsp;<span>总共：<input type="text" value="${all}" readonly style="width:30px ">条数据</span>
            </div>
        </div>

    </div>
</div>
</body>
</html>