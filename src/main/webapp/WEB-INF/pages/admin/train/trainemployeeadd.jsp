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
    <link rel="stylesheet" href="resource/css/table.css">

</head>
<body>
<div style="margin:0 auto;width: 80%">
<jsp:include page="../base.jsp" />

<div id="next">
    <div id="main"  style="width: 800px;height: 500px;">
        <form action="addAllTrainEmployee" method="post">
            <table border="1" rules="all">
                <tr>
                    <td colspan="4">员工培训</td>
                </tr>
                <tr>
                    <td>开始时间</td>
                    <td><input type="date" name="startTime" required style="width: 100%;height: 100%"></td>
                    <td>结束时间</td>
                    <td><input type="date" name="endTime" required style="width: 100%;height: 100%"></td>
                </tr>
                <tr>
                    <td>培训主题</td>
                    <td colspan="3"><input type="text" name="title" required style="width: 100%;height: 100%"></td>
                </tr>
                <tr>
                    <td>培训地点</td>
                    <td colspan="3"><input type="text" name="address" required style="width: 100%;height: 100%"></td>
                </tr>
                <tr>
                    <td colspan="4">培训内容</td>
                </tr>
                <tr>
                    <td colspan="4">
                        <input type="text" name="content" style="width: 100%;height: 200px" required>
                    </td>
                </tr>
            </table>
            <input type="submit" value="选择员工" id="sub" class="send" style="position: relative;left: 300px;top: 20px;">
        </form>
    </div>
</div>

</div>
</body>
</html>