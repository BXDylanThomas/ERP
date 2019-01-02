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
                <li class="menu">
                    <a href="toTrain">培训管理</a>
                </li>
                <li class="menu">
                    <a href="">薪资结算</a>
                </li>
            </ul>
        </div>
    </div>
</div>
    <div id="next">
        <div id="main">
            <table border="1" rules="all">
                <tr>
                    <c:forEach items="${max}" var="day" varStatus="i">

                    <td>
                            ${day}<br/>
                        <c:set var="flag" value="false"/>
                        <c:if test="${checkRecords!=null && not empty checkRecords}">
                            <c:forEach items="${checkRecords}" var="c">
                                <c:if test="${c.workTime.split('-')[2].split(' ')[0]==day}">

                                    <c:set var="flag" value="true"/>
                                    <c:if test="${c.workState==4 || c.offState==4}">
                                        旷工&nbsp;
                                    </c:if>
                                    <c:if test="${c.workState!=4 && c.offState!=4}">
                                        <c:if test="${c.overTime==1}">
                                            加班&nbsp;
                                        </c:if>
                                        <c:if test="${c.workState==1 &&c.offState==1}">
                                            正常
                                        </c:if>
                                        <c:if test="${c.workState==1 && c.offState==3}">
                                            早退
                                        </c:if>
                                        <c:if test="${c.workState==2 && c.offState==1}">
                                            迟到
                                        </c:if>
                                        <c:if test="${c.workState==2 && c.offState==3}">
                                            迟到&nbsp;早退
                                        </c:if>
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </c:if>
                        <c:if test="${flag==false}">
                            旷工
                        </c:if>
                    </td>

                    <c:if test="${i.count%7==0}">
                </tr><tr>
                </c:if>

                </c:forEach>
            </tr>
            </table>


        </div>

    </div>
</body>

</body>
</html>