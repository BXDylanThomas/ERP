<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>用户登录</title>
    <meta name="description" content="Custom Login Form Styling with CSS3" />

    <meta name="keywords" content="css3, login, form, custom, input, submit, button, html5, placeholder" />
    <meta name="author" content="Codrops" />
    <link rel="stylesheet" type="text/css" href="resource/css/style.css" />

    <style>
        body {
            background: #563c55 url(resource/image/bg3.jpg) no-repeat center top;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            background-size: cover;
        }
        .container > header h1,
        .container > header h2 {
            color: #fff;
            text-shadow: 0 1px 1px rgba(0,0,0,0.7);
        }
        .container{
            position: relative;
            top:200px;
        }
    </style>
</head>
<body>

<div class="container">

    <section class="main">
        <form class="form-3" method="post" action="adminLogin">
            <p class="clearfix">
                <label for="login">用户名：</label>
                <input type="text" name="name" id="login" placeholder="请输入用户名">
            </p>
            <p class="clearfix">
                <label for="password">密码：</label>
                <input type="password" name="password" id="password" placeholder="请输入密码">
            </p>
            <p class="clearfix">
                <input type="submit" name="submit" value="登录" style="position: relative;left: 60px">
            </p>
        </form>
    </section>
</div>

</body>
</html>