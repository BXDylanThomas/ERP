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
    <link rel="stylesheet" href="resource/css/page.css">
    <link rel="stylesheet" href="resource/css/table.css">
    <script src="resource/js/jquery-3.3.1.js"></script>
    <script src="resource/js/recruitment.js"></script>
</head>
<body>
<div style="margin:0 auto;width: 80%">
<jsp:include page="base.jsp" />

<div id="next">
    <div >
        <form method="post" action="addRecruitment" id="f">
            <table border="1" rules="all">
                <tr>
                    <td colspan="3">招聘</td>
                </tr>
                <tr>
                    <td>部门：</td>
                    <td colspan="2">
                        <select id="department">
                            <option value="-1" selected>请选择部门</option>
                            <c:forEach items="${sessionScope.positions}" var="d">
                                <option value="${d.department.id}">${d.department.name}</option>
                            </c:forEach>
                            <otion>12</otion><otion>12</otion>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>职位：</td>
                    <td colspan="2">
                        <select id="position" name="posId">
                            <option>请选择职位</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td >标题</td>
                    <td colspan="2"><input type="text" name="title" required style="width: 100%;height: 100%"> </td>
                </tr>
                <tr>
                    <td colspan="3">招聘要求</td>
                </tr>
                <tr>
                    <td colspan="3"style="height: 50px">
                        <input name="content" required style="width: 100%;height: 100%">
                    </td>
                </tr>

                <tr>
                    <td>招聘人数：</td>
                    <td colspan="2"><input type="number" name="count" style="width: 100%" required>个</td>
                </tr>
            </table>
            <input type="submit" value="确认" id="sub" class="send" style="position: relative;left: 200px; top: 20px;">
        </form>
    </div>
</div>
</div>
</body>
</html>