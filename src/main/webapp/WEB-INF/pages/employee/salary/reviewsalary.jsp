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
    <link rel="stylesheet" href="resource/css/button.css">
    <script src="resource/js/jquery-3.3.1.js"></script>
    <script>
        $(function () {
            $("#add").click(function () {
                window.location.href="reviewSalary?reason="+$("#reason").val()
            })
        })
    </script>
    <style>
        th,td{
            width: 600px;
            height: 50px;
            text-align: center;
        }
        table{
            top: 20px;
        }
        #next{
            position: relative;
            left: 200px;
            top: 20px;
        }
    </style>
</head>
<body>
<div style="margin:0 auto;width: 80%">
<jsp:include page="../base.jsp" />
    <div id="next">
            <table border="1" rules="all">
                <tr >
                    <th>工资复议申请单</th>
                </tr>
                <tr>
                    <td style="text-align: left">申请人：${sessionScope.user.name}</td>
                </tr>
                <tr>
                    <td style="height: 300px"><textarea style="max-width:600px;max-height: 300px;min-height: 300px;min-width: 600px" id="reason"></textarea></td>
                </tr>
            </table>
            <a href="javascript:void(0)" id ="add" class="send" style="position: relative;left: 250px;top: 10px;">确定</a>
    </div>
</div>
</body>

</body>
</html>