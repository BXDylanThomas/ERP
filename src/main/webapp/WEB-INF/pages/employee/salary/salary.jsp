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
    <style>
        th,td{
            width: 100px;
            height: 30px;
            line-height: 30px;
            text-align: center;
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
        <table border="1" rules="all" >
            <tr>
                <th>出勤天数</th>
                <th>基本工资</th>
                <th>绩效</th>
                <th>加班工资</th>
                <th>奖励</th>
                <th>惩罚</th>
                <th>社保</th>
                <th>实发</th>
                <th></th>
            </tr>
            <c:if test="${ticket==null || empty ticket }">
                <tr>
                    <td colspan="8">暂无</td>
                </tr>
            </c:if>
            <c:if test="${ticket!=null && not empty ticket }">
                <c:forEach items="${ticket}" var="t">
                    <tr>
                        <td>${t.day}</td>
                        <td>${t.base}</td>
                        <td>${t.performance}</td>
                        <td>${t.ot}</td>
                        <td>${t.prize}</td>
                        <td>${t.punish}</td>
                        <td>${t.social}</td>
                        <td>${t.sum}</td>
                        <th><a href="toReviewSalary">复议</a></th>
                    </tr>

                </c:forEach>
            </c:if>
        </table>
    </div>
</div>
</body>

</body>
</html>