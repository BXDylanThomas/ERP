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
    <script src="resource/js/traindepartment.js"></script>
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
        <a href="toTrainDepartmentadd">添加部门培训</a> <br/> <br/>

        <span>查看部门：</span> &nbsp;
        <select id="department">
            <option value="-1">请选择部门</option>
            <c:forEach items="${sessionScope.department}" var="d">
                <c:if test="${depId==d.id}">
                    <option value="${d.id}" selected>${d.name}</option>
                </c:if>
                <c:if test="${depId!=d.id}">
                    <option value="${d.id}">${d.name}</option>
                </c:if>

            </c:forEach>
        </select>&nbsp;
       <select id="choice">
           <option value="-1"selected>请选择</option>
           <option value="1" >已发布</option>
           <option value="0" >未发布</option>
       </select><br/> <br/>
        <c:if test="${trainDepartment==null || empty trainDepartment}">
            <span>没有数据</span>
        </c:if>
        <c:if test="${trainDepartment!=null || not empty trainDepartment}">
            <c:forEach items="${trainDepartment}" var="t">
                <form method="post" action="updatetraindepartment" >
                    <table border="1" rules="all">
                        <tr>
                            <th colspan="4">部门培训</th>
                        </tr>
                        <tr>
                            <th>部门</th>
                            <td>
                                    ${t.department.name}
                            </td>
                            <th>状态</th>
                            <td>
                                <c:if test="${t.state==0}">
                                    <a href="publishtraindepartment?id=${t.id}" onclick= "if(confirm( '是否确定！ ')==false)return   false; ">去发布</a>
                                    &emsp;<a href="javascript:void(0)" class="subb">修改</a>
                                    &emsp;<a href="deletetraindepartment?id=${t.id}" onclick= "if(confirm( '是否确定！ ')==false)return   false; ">删除</a>
                                </c:if>
                                <c:if test="${t.state==1}">
                                    已发布
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <input type="hidden" value="${t.train.id}">
                            <th>开始时间</th>
                            <td><input type="date" name="startTime" value="${t.train.startTime}"readonly ></td>
                            <th>结束时间</th>
                            <td><input type="date" name="endTime"  value="${t.train.endTime}"  readonly></td>
                        </tr>
                        <tr>
                            <th>培训主题</th>
                            <td colspan="3"><input type="text" name="title" value="${t.train.title}" readonly></td>
                        </tr>
                        <tr>
                            <th>培训地点</th>
                            <td colspan="3"><input type="text" name="address"  value="${t.train.address}" readonly></td>
                        </tr>
                        <tr>
                            <th colspan="4">培训内容</th>
                        </tr>
                        <tr>
                            <td colspan="4">
                            <textarea type="text" name="content" style="width: 100%;height: 100px" readonly>
                                    ${t.train.title}
                            </textarea>
                            </td>
                        </tr>
                    </table>
                </form>

                <br/><br/>
            </c:forEach>
        </c:if>
    </div>

    <div id="xia">
        <div id="page">
            <span>页数：</span>
            <a href="queryTrainDepartmentDEP?current=1&depId=${depId}">首页</a>
            <a href="queryTrainDepartmentDEP?current=${prepages}&depId=${depId}">上一页</a>
            <c:forEach  var ="i" begin="1" end="${pages}">
                <a href="queryTrainDepartmentDEP?current=${i}&depId=${depId}">${i}</a>
            </c:forEach>
            <a href="queryTrainDepartmentDEP?current=${nextpages}&depId=${depId}">下一页</a>
            &nbsp;<span>总共：<input type="text" value="${all}" readonly style="width:30px ">条数据</span>
        </div>
    </div>
</div>

</body>
</html>