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
    <link rel="stylesheet" href="resource/css/style2.css">
    <link rel="stylesheet" href="resource/css/page.css">
    <script src="resource/js/jquery-3.3.1.js"></script>
    <script src="resource/js/recruitment.js"></script>
    <style>
        #sub{
            position: relative;
            left: 300px;
            top: 8px;
            width:  300px;
            height: 80px;
            background: red;
            color: white;
            border: none;
            margin: 0px;
            padding: 0px;
        }
        td{
            width: 150px;
            height: 60px;
            text-align: center;
        }
        .button{
            font-size: 20px;
            background: #F22D00;
            color:white;
            -moz-border-radius: 2px;
            -webkit-border-radius: 2px;
            border-radius:2px;
        }
    </style>
    <script>
        $(function () {

            $("#sub").click(function () {
                if($("#position").val()!="-1")
                window.location.href = "employeeChangePosition?empId="+$("#empId").val()+"&posId="+$("#position").val()
            })
            $("#leave").click(function () {
                if($("#position").val()!="-1")
                    window.location.href = "employeeLeave?empId="+$("#empId").val()+"&reason="+$("#reason").val()
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
                    <a href="queryAllEmployee"  id="a">员工管理</a>
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
        <br/><br/>
        <c:if test="${employee.empState==3}">
            <a href="employeeRegular?empId=${employee.id}" class="button">转正</a>
        </c:if>

        &emsp;&emsp;<a href="queryCheckRecordEmpId?empId=${employee.id}" class="button">查看上月考勤</a>

        &emsp;&emsp;<a href="queryAdminPrizeRecordEmpId?empId=${employee.id}" class="button">查看历史奖惩</a><br/><br/>


        <table border="1" rules="all">
            <tr>
                <td colspan="4">
                    <input type="hidden" value="${employee.id}" id="empId">
                    调换岗位
                </td>
            </tr>
            <tr>
                <td>原先部门</td>
                <td>
                    ${employee.position.department.name}
                </td>
                <td>原先职位</td>
                <td>
                    ${employee.position.name}
                </td>
            </tr>
            <tr>
                <td>调换部门</td>
                <td>
                    <select id="department">
                        <option>选择部门</option>
                        <c:forEach items="${sessionScope.allDepartment}" var="d">
                            <option value="${d.id}">${d.name}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>调换职位</td>
                <td>
                    <select id="position" name="posId">
                        <option value="-1">请选择职位</option>
                    </select>
                </td>
            </tr>
        </table>
        <a id="sub" href="javascript:void(0)" class="button">确定</a><br/><br/>


        <table border="1" rules="all">
            <tr>
                <td colspan="4">离职申请表</td>
            </tr>
            <tr>
                <td rowspan="2">离职原因</td>
                <td rowspan="2" style="width: 300px"> <textarea style="max-width: 100%;max-height: 100%" required id="reason"></textarea></td>
            </tr>
            <tr></tr>
            <tr>
                <td colspan="4"><a id="leave" href="javascript:void(0)" class="button">确定</a><br/><br/></td>
            </tr>
        </table>

    </div>

</div>
</body>
</html>