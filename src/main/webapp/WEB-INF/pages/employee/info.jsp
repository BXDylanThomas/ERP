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
    <link rel="stylesheet"  href="resource/css/table.css">
</head>
<body>
<div style="margin:0 auto;width: 80%">
<jsp:include page="base.jsp" />

    <div id="next" style="position: relative;left: 100px;top: 20px;">

        <table border="1" rules="all">
            <tr>
                <th colspan="4">个人信息</th>
            </tr>
            <tr>
                <th>部门</th>
                <td>${employee.position.department.name}</td>
                <th>职位</th>
                <td>${employee.position.name}</td>
            </tr>
            <tr>
                <th>姓名</th>
                <td>${employee.resume.name}</td>
                <th>性别</th>
                <td>${employee.resume.sex}</td>
            </tr>
            <tr>
                <th>出身年月</th>
                <td>${employee.resume.birth}</td>
                <th>状态：</th>
                <td>
                    <c:if test="${employee.empState==1}">
                        <span>离职</span>
                    </c:if>
                    <c:if test="${employee.empState==2}">
                        <span>正式员工</span>
                    </c:if>
                    <c:if test="${employee.empState==3}">
                        <span>试用期</span>
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>入职时间</th>
                <td>${employee.entryTime}</td>
                <th>基本工资</th>
                <td>${employee.resume.salary.money}</td>
            </tr>
            <tr>
                <th>联系电话</th>
                <td>${employee.resume.phone}</td>
                <th>邮箱</th>
                <td>${employee.resume.email}</td>
            </tr>
            <tr>
                <th>联系地址</th>
                <td colspan="3">${employee.resume.address}</td>
            </tr>
            <tr>
                <th>专业：</th>
                <td>${employee.resume.major}</td>
                <th>最高学历：</th>
                <td>${employee.resume.education}</td>
            </tr>
            <tr>
                <th colspan="4">工作经验：</th>
            </tr>
            <tr>
                <td colspan="4">
                    <input style="width: 100%;height: 100%;border: none" value=" ${employee.resume.exp}">
                </td>
            </tr>
        </table>

    </div>
</div>
</body>
</body>
</html>