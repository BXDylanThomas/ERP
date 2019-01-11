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
    <link rel="stylesheet" href="resource/css/page.css">
    <script src="resource/js/jquery-3.3.1.js"></script>
</head>
<body>
<div style="margin:0 auto;width: 80%">
<jsp:include page="base.jsp" />

<div id="next">
    <div >
        <div id="main">
            <a href="toRecruitment" id="add" class="send">添加招聘</a><br/><br/>
            <c:if test="${recruitment==null || empty recruitment}">
                <td colspan="3">没有数据</td>
            </c:if>
            <c:if test="${recruitment!=null || not empty recruitment}">
                <c:forEach items="${recruitment}" var="r">
                    <table border="1" rules="all">
                        <tr>
                            <td colspan="3">招聘</td>
                            <td rowspan="10" style="width: 80px">
                                <a href="queryrecruitmentRecord?recId=${r.id}" class="send" style="margin-bottom: 20px">查看简历</a>
                                <a href="deleteRecruitment?id=${r.id}" onclick= "if(confirm( '是否确定！ ')==false)return   false; " class="send">删除</a>
                            </td>
                        </tr>
                        <tr>
                            <td>部门：</td>
                            <td colspan="2">  ${r.positions.department.name} </td>
                        </tr>
                        <tr>
                            <td>职位：</td>
                            <td colspan="2"> ${r.positions.name}  </td>
                        </tr>
                        <tr>
                            <td >标题</td>
                            <td colspan="2">${r.title}</td>
                        </tr>
                        <tr>
                            <td colspan="3">招聘要求</td>
                        </tr>
                        <tr>
                            <td colspan="3">${r.content}</td>
                        </tr>
                        <tr></tr>
                        <tr></tr>
                        <tr>
                            <td>招聘人数：</td>
                            <td colspan="2">${r.count}个</td>
                        </tr>
                        <tr>
                            <td>招聘时间：</td>
                            <td colspan="2">${r.createTime}</td>
                        </tr>

                     </table>
                    <br/><br/>
                </c:forEach>
            </c:if>
        </div>

        <div id="page">
            <span>页数：</span>
            <a href="queryAllRecruitment?current=1">首页</a>
            <a href="queryAllRecruitment?current=${prepages}">上一页</a>
            <c:forEach  var ="i" begin="1" end="${pages}">
                <a href="queryAllRecruitment?current=${i}">${i}</a>
            </c:forEach>
            <a href="queryAllRecruitment?current=${nextpages}">下一页</a>
            &emsp;<span>总共：<input type="text" value="${all}" readonly style="width:30px ">条数据</span>
        </div>
    </div>
</div>
</div>
</body>
</html>