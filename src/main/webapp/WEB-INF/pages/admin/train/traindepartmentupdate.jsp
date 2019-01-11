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
    <link rel="stylesheet" href="resource/css/table.css">
    <link rel="stylesheet" href="resource/css/button.css">
    <link rel="stylesheet" href="resource/css/next.css">
    <script src="resource/js/jquery-3.3.1.js"></script>
    <script src="resource/js/traindepartment.js"></script>
    <style>
        td{
            width: 150px;
            height: 40px;
            text-align: center;
        }
        input[type=text],input[type=date]{
            border: solid black 1px;
            background:lightcyan;
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body>
<div style="margin:0 auto;width: 80%">
<jsp:include page="../base.jsp" />

<div id="next">
    <div id="main">
        <br/>
            <form method="post" action="updatetraindepartment" id="f">
                <table border="1" rules="all">
                    <tr>
                        <td colspan="4">部门培训</td>
                    </tr>
                    <tr>
                        <td>部门</td>
                        <td>
                            <input type="hidden" value="${trainDepartment.id}" name="tdId">
                            <select name="depId">
                                <option>请选择部门</option>
                                <c:forEach items="${sessionScope.department}" var="d">
                                    <c:if test="${trainDepartment.depId==d.id}">
                                        <option value="${d.id}" selected>${d.name}</option>
                                    </c:if>
                                    <c:if test="${trainDepartment.depId!=d.id}">
                                        <option value="${d.id}">${d.name}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <input type="hidden" value="${trainDepartment.train.id}" name="id">
                        <td>开始时间</td>
                        <td><input type="date" name="startTime" value="${trainDepartment.train.startTime}" required></td>
                        <td>结束时间</td>
                        <td><input type="date" name="endTime"  value="${trainDepartment.train.endTime}"  required></td>
                    </tr>
                    <tr>
                        <td>培训主题</td>
                        <td colspan="3"><input type="text" name="title" value="${trainDepartment.train.title}" required ></td>
                    </tr>
                    <tr>
                        <td>培训地点</td>
                        <td colspan="3"><input type="text" name="address"  value="${trainDepartment.train.address}" required></td>
                    </tr>
                    <tr>
                        <td colspan="4">培训内容</td>
                    </tr>
                    <tr>
                        <td colspan="4" style="height: 100px">
                            <input type="text" name="content" value="${trainDepartment.train.title}" required>
                        </td>
                    </tr>
                </table>
                <input type="submit" value="确定" id="sub" class="send" style="position: relative;left: 200px;top: 20px;height: 44px;">
            </form>

    </div>

</div>
</div>
</body>
</html>