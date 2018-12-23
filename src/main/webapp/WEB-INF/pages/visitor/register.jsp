<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <script src="resource/js/jquery-3.3.1.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册账号</title>
    <meta name="description" content="Custom Login Form Styling with CSS3" />
    <meta name="keywords" content="css3, login, form, custom, input, submit, button, html5, placeholder" />
    <meta name="author" content="Codrops" />
    <link rel="stylesheet" type="text/css" href="resource/css/style.css" />

    <!--[if lte IE 7]><style>.main{display:none;} .support-note .note-ie{display:block;}</style><![endif]-->
    <style>
        .container{
            position: relative;
            top:200px;
        }
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
        input,span{
            position: relative;
            left: -40px;
        }
    </style>
    <script src="resource/js/jquery-3.3.1.js"></script>
    <script>
        $(function () {
            var flag=false;
            $("#login").blur(function () {
                $.ajax({
                    type:"post",url:"checkname",data:"name="+$("#login").val(),
                    success:function (obj) {
                        if(obj==1){
                            flag=true;
                        }else{
                            flag=false;
                            alert("用户名已经存在")
                        }
                    }
                })
            })
            $("#password2").blur(function () {
                var p2=$(this).val();
                var p1=$("#password").val()
                if(p1==p2){
                    flag=true;
                }else{
                    flag=false;
                    alert("2次密码不一样")
                }
            })
            $("#register").click(function () {
                if(flag){
                    $("#fo").submit();
                }
            })
        })
    </script>
</head>
<body>

<div class="container">

    <section class="main">
        <form class="form-3" action="register" method="post" id="fo">
            <p class="clearfix">
                <label for="login">用户名：</label>
                <input type="text" name="name" id="login" placeholder="请输入用户名" required>
                <span id="name1" style="display: none"></span><br/>
            </p>

            <p class="clearfix">
                <label for="password">请输入密码:</label>
                <input type="password" name="password" id="password" placeholder="请输入密码" required><br/>
                <label for="password">请确认密码:</label>
                <input type="password" id="password2" placeholder="请确认密码" required>
                <span id="p2" style="display: none"></span>
            </p><br/>

            <p class="clearfix">
                <input type="button" value="注册"  id="register" style="position: relative;left: 60px"><br>
                <a href="returnLogin"  style="color: #0273dd;font-size: 20px">去登录</a>
            </p>

        </form>
    </section>

</div>
</body>
</html>