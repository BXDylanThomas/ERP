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
    <link rel="stylesheet" href="resource/css/next.css">
    <link rel="stylesheet" href="resource/css/button.css">
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
<div style="margin:0 auto;width: 80%">
<jsp:include page="base.jsp" />

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
                                <input type="text" name="exp" required readonly value="${r.resume.exp}" style="width: 100%;height: 100%;">
                            </td>
                        </tr>
                    </table>
                    <div style="position: relative;left: 430px;top: -140px;">
                        <form action="sendoffer" method="post" id="fo">
                            <input type="hidden" value="${r.resume.id}" name="resId">
                            <input type="hidden" value="${r.id}" name="recRRId">
                            <label for="sa">基本工资：</label>
                            <input type="number"  name="money" required id="sa" style="width: 100px;height: 20px;border: 1px black solid" ><br/>
                            <a href="javascript:void(0)" id="add" class="send" style="position: relative;left: 55px;top: 10px;">邀请面试</a>
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
</div>
</body>
</html>