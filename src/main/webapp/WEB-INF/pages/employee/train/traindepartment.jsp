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
    <link rel="stylesheet" href="resource/css/page.css">
    <style>
        input{
            border: none;
        }
        #next{
            position: relative;
            left: 200px;
        }
        td,th{
            width: 200px;
            text-align: center;
        }
    </style>
</head>
<body>
<div style="margin:0 auto;width: 80%">
<jsp:include page="../base.jsp" />
    <div id="next">
        <div id="main">
            <br/>
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
                                <td colspan="2"></td>
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
                <a href="empQueryTrainDepartment?accId=${sessionScope.user.id}&current=1">首页</a>
                <a href="empQueryTrainDepartment?accId=${sessionScope.user.id}&current=${prepages}">上一页</a>
                <c:forEach  var ="i" begin="1" end="${pages}">
                    <a href="empQueryTrainDepartment?accId=${sessionScope.user.id}&current=${i}">${i}</a>
                </c:forEach>
                <a href="empQueryTrainDepartment?accId=${sessionScope.user.id}&current=${nextpages}">下一页</a>
                &nbsp;<span>总共：<input type="text" value="${all}" readonly style="width:30px ">条数据</span>
            </div>
        </div>

    </div>
</div>

</body>
</html>