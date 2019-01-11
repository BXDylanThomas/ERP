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
    <style>
        td{
            width: 150px;
            height: 40px;
            text-align: center;
        }
        input{
            border: none;
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body>
<div style="margin:0 auto;width: 80%">
    <jsp:include page="../base.jsp" />

    <div id="next">
        <div id="main" >
            <form method="post" action="updatetraindepartment" >
                 <table border="1" rules="all">
                        <tr>
                            <td colspan="4">部门培训</td>
                        </tr>
                        <tr>
                            <td>部门</td>
                            <td>
                                ${t.department.name}
                            </td>
                            <td>状态</td>
                            <td style="width: 350px">
                                <c:if test="${t.state==0}">
                                    <a href="publishtraindepartment?id=${t.id}"class="send" onclick= "if(confirm( '是否确定！ ')==false)return   false; ">去发布</a>
                                    &emsp;<a href="toupdatetraindepartment?id=${t.id}" class="send">修改</a>
                                    &emsp;<a href="deletetraindepartment?id=${t.id}" class="send" onclick= "if(confirm( '是否确定！ ')==false)return   false; ">删除</a>
                                </c:if>
                                <c:if test="${t.state==1}">
                                    已发布
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <input type="hidden" value="${t.train.id}">
                            <td>开始时间</td>
                            <td><input type="date" name="startTime" value="${t.train.startTime}"readonly ></td>
                            <td>结束时间</td>
                            <td><input type="date" name="endTime"  value="${t.train.endTime}"  readonly ></td>
                        </tr>
                        <tr>
                            <td>培训主题</td>
                            <td colspan="3"><input type="text" name="title" value="${t.train.title}" readonly ></td>
                        </tr>
                        <tr>
                            <td>培训地点</td>
                            <td colspan="3"><input type="text" name="address"  value="${t.train.address}" readonly ></td>
                        </tr>
                        <tr>
                            <td colspan="4">培训内容</td>
                        </tr>
                        <tr>
                            <td colspan="4">
                                <input type="text" name="content" value="${t.train.title}" readonly>
                            </td>
                        </tr>
                    </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>