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
    <link rel="stylesheet" href="resource/css/employee.css">
    <link rel="stylesheet" href="resource/css/page.css">
    <script src="resource/js/jquery-3.3.1.js"></script>
    <script src="resource/js/employee.js"></script>
</head>
<body>
<div style="margin:0 auto;width: 80%">
<jsp:include page="../base.jsp" />
<div id="next">
    <div id="main">
        <br/><br/>
        <div>
            <span>查询部门：</span>
            <select id="department">
                <option value="-1" selected>请选择部门</option>
                <c:forEach items="${sessionScope.allDepartment}" var="d">
                    <option value="${d.id}">${d.name}</option>
                </c:forEach>
            </select>
            &emsp;
            &emsp;<span>选择职位：</span>
            <select id="position" name="posId">
                <option value="-1" selected>请选择职位</option>
            </select>
            &emsp;<a href="queryemployeeleave" class="send">查看离职员工</a>
        </div>

        <br/>
        <table>
            <tr>
                <th class="rul">部门名称</th>
                <th class="rul">职务名称</th>
                <th class="rul">姓名</th>
                <th class="rul">性别</th>
                <th class="rul">入职时间</th>
                <th class="rul">状态</th>
                <th class="rul">出生年月</th>
                <th class="rul">联系电话</th>
                <th class="=lg">联系地址</th>
                <th class="=lg">邮箱</th>
                <th></th>
            </tr>
            <c:if test="${employees==null || empty employees}">
                <td colspan="5">没有数据</td>
            </c:if>
            <c:if test="${employees!=null || not empty employees}">
                <c:forEach items="${employees}" var="e">
                    <tr>
                        <td class="rul">${e.position.department.name}</td>
                        <td class="rul">${e.position.name}</td>
                        <td class="rul">${e.resume.name}</td>
                        <td class="rul">${e.resume.sex}</td>
                        <td class="rul">${e.entryTime}</td>
                        <td class="rul">
                            <c:if test="${e.empState==1}">
                                <span>离职</span>
                            </c:if>
                            <c:if test="${e.empState==2}">
                                <span>正式员工</span>
                            </c:if>
                            <c:if test="${e.empState==3}">
                                <span>试用</span>
                            </c:if>
                        </td>
                        <td class="rul">${e.resume.birth}</td>
                        <td class="rul">${e.resume.phone}</td>
                        <td class="=lg">${e.resume.address}</td>
                        <td class="=lg">${e.resume.email}</td>

                        <td class="rul">
                            <a href="admintoempmanager?empId=${e.id}">管理</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>

        </table>
    </div>

    <div id="xia">
        <div id="page">
            <span>页数：</span>
            <a href="queryAllEmployee?current=1">首页</a>
            <a href="queryAllEmployee?current=${prepages}">上一页</a>
            <c:forEach  var ="i" begin="1" end="${pages}">
                <a href="queryAllEmployee?current=${i}">${i}</a>
            </c:forEach>
            <a href="queryAllEmployee?current=${nextpages}">下一页</a>
            &nbsp;<span>总共：<input type="text" value="${all}" readonly style="width:30px ">条数据</span>
        </div>
    </div>
</div>
</div>
</body>
</html>