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
    <link rel="stylesheet" href="resource/css/employee.css">
    <link rel="stylesheet" href="resource/css/page.css">
    <script src="resource/js/jquery-3.3.1.js"></script>
    <script src="resource/js/employeeemp.js"></script>
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
                    <a href="toemployeeinfo">个人信息</a>
                </li>
                <li class="menu">
                    <a href="queryAllEmployeeemp"  id="a">员工查询</a>
                </li>
                <li class="menu">
                    <a href="queryAllEmployeeemp">查看考勤</a>
                </li>
                <li class="menu">
                    <a href="">查看培训</a>
                </li>
                <li class="menu">
                    <a href="">查看薪资</a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div id="next">
    <div id="main">
        <br/><br/>
        <div>
            <span>查询部门：</span>
            <select id="department">
                <option>请选择部门</option>
                <c:forEach items="${sessionScope.allDepartment}" var="d">
                    <c:if test="${depId==d.id}">
                        <option value="${d.id}" selected>${d.name}</option>
                    </c:if>
                    <c:if test="${depId!=d.id}">
                        <option value="${d.id}">${d.name}</option>
                    </c:if>
                </c:forEach>
            </select>
            &emsp;
            &emsp;<span>选择职位：</span>
            <select id="position" name="posId">
                <option>请选择职位</option>
                <c:forEach items="${sessionScope.allpositions}" var="p">
                    <c:if test="${posId==p.id}">
                        <option value="${p.id}" selected>${p.name}</option>
                    </c:if>
                    <c:if test="${posId!=p.id}">
                        <option value="${p.id}">${p.name}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
        <br/>
        <table>
            <tr>
                <th class="rul">部门名称</th>
                <th class="rul">职务名称</th>
                <th class="rul">姓名</th>
                <th class="rul">性别</th>
                <th class="rul">联系电话</th>
                <th class="=lg">联系地址</th>
                <th class="=lg">邮箱</th>
                <th class="rul">状态</th>
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
                        <td class="rul">${e.resume.phone}</td>
                        <td class="=lg">${e.resume.address}</td>
                        <td class="=lg">${e.resume.email}</td>
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
                    </tr>
                </c:forEach>
            </c:if>

        </table>
    </div>

    <div id="xia">
        <div id="page">
            <span>页数：</span>
            <a href="queryAllEmployeeByPosIdemp?posId=${posId}&current=1">首页</a>
            <a href="queryAllEmployeeByPosIdemp?posId=${posId}&current=${prepages}">上一页</a>
            <c:forEach  var ="i" begin="1" end="${pages}">
                <a href="queryAllEmployeeByPosIdemp?posId=${posId}&current=${i}">${i}</a>
            </c:forEach>
            <a href="queryAllEmployeeByPosIdemp?posId=${posId}&current=${nextpages}">下一页</a>
            &nbsp;<span>总共：<input type="text" value="${all}" readonly style="width:30px ">条数据</span>
        </div>
    </div>
</div>
</body>
</html>