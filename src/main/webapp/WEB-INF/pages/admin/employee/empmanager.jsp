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
    <link rel="stylesheet" href="resource/css/style2.css">
    <link rel="stylesheet" href="resource/css/page.css">
    <script src="resource/js/jquery-3.3.1.js"></script>
    <script src="resource/js/recruitment.js"></script>
    <style>
        td{
            width: 150px;
            height: 60px;
            text-align: center;
        }
    </style>
    <script>
        $(function () {

            $("#sub").click(function () {
                if($("#position").val()!="-1")
                window.location.href = "employeeChangePosition?empId="+$("#empId").val()+"&posId="+$("#position").val()
            })
            $("#leave").click(function () {
                    window.location.href = "employeeLeave?empId="+$("#empId").val()+"&reason="+$("#reason").val()
            })
        })
    </script>
</head>
<body>
<div style="margin:0 auto;width: 80%">
<jsp:include page="../base.jsp" />

<div id="next">
    <div id="main">
        <br/><br/>
        <c:if test="${employee.empState==3}">
            <a href="employeeRegular?empId=${employee.id}" class="send">转正</a>
        </c:if>

        &emsp;&emsp;<a href="queryCheckRecordEmpId?empId=${employee.id}" class="send">查看上月考勤</a>

        &emsp;&emsp;<a href="queryAdminPrizeRecordEmpId?empId=${employee.id}" class="send">查看历史奖惩</a><br/><br/>


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
        <a id="sub" href="javascript:void(0)" class="send" style="position: relative;left:270px; top: 20px;margin-bottom: 40px">确定</a><br/><br/>


        <table border="1" rules="all">
            <tr>
                <td colspan="4">离职表</td>
            </tr>
            <tr>
                <td rowspan="2">离职原因</td>
                <td rowspan="2" style="width: 300px;height: 150px;"><input style="width: 100%;height: 100%"required id="reason"></td>
            </tr>
            <tr></tr>
        </table>
        <a id="leave" href="javascript:void(0)" class="send" style="position: relative;left:200px; top: 20px;margin-bottom: 40px">确定</a>
    </div>
</div>
</div>
</body>
</html>