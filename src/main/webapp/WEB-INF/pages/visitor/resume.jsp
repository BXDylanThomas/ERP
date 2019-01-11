<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>

    <link rel="stylesheet"  href="resource/css/table.css">
    <link rel="stylesheet" href="resource/css/button.css"/>
    <link rel="stylesheet" href="resource/css/layui.css"/>
    <style>
        input{
            border: none;
        }
        #next{
            position: relative;
            left: 100px;
            top: 20px;
        }
        .layui-form-label{
            width: 100px;
        }
        .layui-input-block{
            width: 500px;
        }
    </style>
</head>
<body>
<div style="margin:0 auto;width: 80%">

<jsp:include page="base.jsp" />

<div id="next">
        <c:if test="${resume==null || empty resume}">
            <div style="position: relative;left: 200px;top: 100px;">
                <span style="font-size: 22px">暂无简历，去<a href="toresumemake" class="send">添加</a></span>
            </div>
        </c:if>
        <c:if test="${resume!=null || not empty resume}">
            <form method="post" action="updateresumemake" id="f">
                <input type="hidden" name="id" value="${resume.id}">
                <input type="hidden" name="accId" value="${resume.accId}">
                <div class="layui-form-item">
                    <label class="layui-form-label">姓名</label>
                    <div class="layui-input-block">
                        <input type="text" name="name" lay-verify="required|title" value="${resume.name}" readonly autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">性别</label>
                    <div class="layui-input-block">
                        <input type="text" name="sex" lay-verify="required|title" value="${resume.sex}" readonly autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">出身年月</label>
                    <div class="layui-input-block">
                        <input type="text" name="birth" lay-verify="required|title" value="${resume.birth}" readonly   class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">最高学历</label>
                    <div class="layui-input-block">
                        <input type="text" name="education" lay-verify="required|title"value="${resume.education}" readonly  autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">专业</label>
                    <div class="layui-input-block">
                        <input type="text" name="major" lay-verify="required|title"value="${resume.major}" readonly  autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">联系电话</label>
                    <div class="layui-input-block">
                        <input type="text" name="phone" lay-verify="required|number"value="${resume.phone}" readonly lay-verType="tips" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">邮箱</label>
                    <div class="layui-input-block">
                        <input type="text" name="email" lay-verify="required|number"value="${resume.email}" readonly lay-verType="tips" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">联系地址</label>
                    <div class="layui-input-block">
                        <input type="text" name="address" lay-verify="required|title" value="${resume.address}" readonly autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">工作经验</label>
                    <div class="layui-input-block">
                        <input type="text" name="exp" lay-verify="required|title"  value="${resume.exp}"readonly autocomplete="off" class="layui-input" style="text-align: left">
                    </div>
                </div>
                <div>
                    <input type="button" value="修改" id="sub" class="send" style="position: relative;left: 80px">
                </div>
            </form>
        </c:if>
    </div>
</div>
    <script src="resource/js/jquery-3.3.1.js"></script>
    <script src="resource/js/resume.js"></script>
</body>
</html>