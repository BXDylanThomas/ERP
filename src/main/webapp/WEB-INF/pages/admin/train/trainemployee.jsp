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
    <link rel="stylesheet" href="resource/css/table.css">
    <script src="resource/js/jquery-3.3.1.js"></script>
    <script src="resource/js/trainemployee.js"></script>
    <style>
        input{
            border: none;
        }
    </style>
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
                <li class="menu"  id="a">
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
    <div id="main">
        <br/>
        <a href="toAddAllTrainEmployee">添加员工培训</a> <br/> <br/>

       <select id="choice">
           <option value="-1" selected>请选择</option>
           <option value="1">已发布</option>
           <option value="0">未发布</option>
       </select><br/> <br/>
        <c:if test="${trains==null || empty trains}">
            <span>没有数据</span>
        </c:if>
        <c:if test="${trains!=null || not empty trains}">
            <c:forEach items="${trains}" var="t">
                <table border="1" rules="all">
                    <tr>
                        <th colspan="4">员工培训</th>
                    </tr>
                    <tr>
                        <td colspan="2"></td>
                        <th>状态</th>
                        <td>
                            <c:forEach items="${trainEmployee}" begin="1" end="1" var="te">
                                <c:if test="${te.tId==t.id}">
                                    <c:if test="${te.state==0}">
                                        <a href="publicshTrainEmployee?id=${t.id}" onclick= "if(confirm( '是否确定！ ')==false)return   false; ">去发布</a>
                                        &emsp;<a href="updateTrainEmployee?id=${t.id}">修改</a>
                                        &emsp;<a href="deleteTrainEmployee?id=${t.id}" onclick= "if(confirm( '是否确定！ ')==false)return   false; ">删除</a>
                                    </c:if>
                                    <c:if test="${te.state==1}">
                                        已发布
                                    </c:if>
                                </c:if>
                            </c:forEach>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4"rowspan="2" >
                            <b>姓名：</b>
                            <c:forEach items="${trainEmployee}" varStatus="ct" var="te">
                                <c:if test="${te.tId==t.id}">
                                    ${te.employee.resume.name},
                                </c:if>
                                <c:if test="${ct.count %5==0}"></tr><tr></c:if>
                            </c:forEach>
                        </td>
                    </tr>
                    <tr></tr>

                    <tr>
                        <th>开始时间</th>
                        <td><input type="date" name="startTime" value="${t.startTime}"readonly ></td>
                        <th>结束时间</th>
                        <td><input type="date" name="endTime"  value="${t.endTime}"  readonly></td>
                    </tr>
                    <tr>
                        <th>培训主题</th>
                        <td colspan="3"><input type="text" name="title" value="${t.title}" readonly></td>
                    </tr>
                    <tr>
                        <th>培训地点</th>
                        <td colspan="3"><input type="text" name="address"  value="${t.address}" readonly></td>
                    </tr>
                    <tr>
                        <th colspan="4">培训内容</th>
                    </tr>
                    <tr>
                        <td colspan="4">
                    <textarea type="text" name="content" style="width: 100%;height: 100px" readonly>
                            ${t.title}
                    </textarea>
                        </td>
                    </tr>
                </table>
                 <br/><br/>
            </c:forEach>
        </c:if>
    </div>

    <div id="xia">
        <div id="page">
            <span>页数：</span>
            <a href="queryAllTrainEmployee?current=1">首页</a>
            <a href="queryAllTrainEmployee?current=${prepages}">上一页</a>
            <c:forEach  var ="i" begin="1" end="${pages}">
                <a href="queryAllTrainEmployee?current=${i}">${i}</a>
            </c:forEach>
            <a href="queryAllTrainEmployee?current=${nextpages}">下一页</a>
            &nbsp;<span>总共：<input type="text" value="${all}" readonly style="width:30px ">条数据</span>
        </div>
    </div>
</div>

</body>
</html>