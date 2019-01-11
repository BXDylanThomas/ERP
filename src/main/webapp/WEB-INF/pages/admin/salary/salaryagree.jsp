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
    <link rel="stylesheet" href="resource/css/next.css">
    <link rel="stylesheet" href="resource/css/page.css">
    <script src="resource/js/jquery-3.3.1.js"></script>
    <script>
        $(function () {
            $("#agree").click(function () {
                window.location.href="salaryReviewSure?id="+$("#id").val()+"&empId="+$("#empId").val()+"&reason="+$("#reason").val()+"&money="+$("#money").val()
            })
        })
    </script>
    <style>
        td{
            width: 400px;
            height: 40px;
            text-align: center;
        }
    </style>
</head>
<body>
<div style="margin:0 auto;width: 80%">
    <jsp:include page="../base.jsp" />
    <div id="next">
        <input type="hidden" value="${id}" id="id">
        <input type="hidden" value="${empId}" id="empId">
        <table border="1" rules="all">
            <tr>
                <td colspan="3">薪资复议同意表</td>
            </tr>
            <tr> <td style="text-align: left" colspan="3">原因</td></tr>
            <tr>

                <td colspan="3" style="height: 200px"><input id="reason" required style="width: 100%;height: 100%"></td>
            </tr>
            <tr>
                <td>金额</td>
                <td colspan="2"><input type="number" id="money" required style="width: 100%;height: 100%"></td>
            </tr>
        </table>
        <a href="javascript:void(0)" id="agree" class="send"style="position: relative;left: 200px;top: 10px;">确定</a>
    </div>

</div>

</body>
</html>