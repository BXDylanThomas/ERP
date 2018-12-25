<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <link rel="stylesheet"  href="resource/css/base.css">
    <link rel="stylesheet" href="resource/css/page.css">
    <link rel="stylesheet" href="resource/css/vrec.css">
    <script src="resource/js/jquery-3.3.1.js"></script>
    <script>
        $(function () {
            $(".send").click(function () {
                $.ajax({
                    type:"post",url:"sendresumemake",
                    data:"recId="+$(this).next().val(),
                    success:function (obj) {
                        if(obj==-1){
                            window.location.href="login"
                        }else if(obj==0){
                            alert("已经投递")
                        }else{
                            alert("投递成功")
                        }
                    }
                })
            })
        })
    </script>
</head>
<body>

<%--base--%>
<div>
    <!--top-->
    <div id="top">
        <%--没有登录--%>
        <c:if test="${sessionScope.user==null}">
            <div class="welcome">
                <a href="returnRegister">免费注册</a>
                <a href="returnLogin">登录</a>
            </div>
        </c:if>
        <c:if test="${sessionScope.user!=null}">
            <div  class="welcome">
                <span>欢迎：${sessionScope.user.name}</span>
                <a href="exit">退出</a>
            </div>
        </c:if>
    </div>
    <div id="introduce"><span>XXXXX公司</span></div>
    <div id="guid">
        <div id="guid2">
            <ul>
                <li class="menu">
                    <a href="returnVisitor">主页</a>
                </li>
                <li class="menu"  id="a">
                    <a href="visitorqueryAllRecruitment">查看招聘</a>
                </li>
                <li class="menu" >
                    <a href="tovisitorInfo">个人信息</a>

                </li>
            </ul>
        </div>
    </div>
</div>

<div id="next" style="position: relative;left: 500px;top: 10px;">
         <div>
            <a href="toRecruitment">添加招聘</a>
            <c:if test="${recruitment==null}">
                <td colspan="3">没有数据</td>
            </c:if>
            <c:if test="${recruitment!=null}">
                <c:forEach items="${recruitment}" var="r">
                    <table border="1" rules="all">
                        <tr>
                            <th colspan="3">招聘</th>
                            <td rowspan="10" style="width: 80px">
                                <a href="javascript:void(0)" class="send">投递简历</a>
                                <input type="hidden" value="${r.id}" >
                            </td>
                        </tr>
                        <tr>
                            <th>部门：</th>
                            <td colspan="2">  ${r.positions.department.name} </td>
                        </tr>
                        <tr>
                            <th>职位：</th>
                            <td colspan="2"> ${r.positions.name}  </td>
                        </tr>
                        <tr>
                            <th >标题</th>
                            <td colspan="2">${r.title}</td>
                        </tr>
                        <tr>
                            <th colspan="3">招聘要求</th>
                        </tr>
                        <tr>
                            <td colspan="3">${r.content}</td>
                        </tr>
                        <tr></tr>
                        <tr></tr>
                        <tr>
                            <th>招聘人数：</th>
                            <td colspan="2">${r.count}个</td>
                        </tr>
                        <tr>
                            <th>招聘时间：</th>
                            <td colspan="2">${r.createTime}</td>
                        </tr>

                    </table>
                    <br/><br/>
                </c:forEach>
            </c:if>
        </div>

        <div id="page">
            <span>页数：</span>
            <a href="visitorqueryAllRecruitment?current=1">首页</a>
            <a href="visitorqueryAllRecruitment?current=${prepages}">上一页</a>
            <c:forEach  var ="i" begin="1" end="${pages}">
                <a href="visitorqueryAllRecruitment?current=${i}">${i}</a>
            </c:forEach>
            <a href="visitorqueryAllRecruitment?current=${nextpages}">下一页</a>
            &nbsp;<span>总共：<input type="text" value="${all}" readonly id="show">条数据</span>
        </div>

</div>
</body>

</html>