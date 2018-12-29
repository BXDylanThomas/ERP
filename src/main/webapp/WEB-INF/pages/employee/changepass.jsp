<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
    <link rel="stylesheet" href="resource/css/base.css">
    <script src="resource/js/jquery-3.3.1.js"></script>
    <script>
        $(function () {
            var a1=false;
            var a2=false;
            var a3=false;
            $("#p1").blur(function () {
                $.ajax({
                    type: "post", url: "getPass",success:function (obj) {
                        if( obj== $("#p1").val()){
                            $("#sp1").empty()
                            $("#sp1").append("<img src=\"resource/image/2.png\">")
                             a1=true;
                        }else{
                            $("#sp1").empty()
                            $("#sp1").append("<img src=\"resource/image/3.png\">")
                             a1=false;
                        }
                    }
                })
            })
            $("#p2").blur(function () {
                $("#sp2").empty()
                $("#sp2").append("<img src=\"resource/image/2.png\">");
                 a2=true;
            })
            $("#p3").blur(function () {
                if( $("#p2").val()== $("#p3").val()){
                    $("#sp3").empty()
                    $("#sp3").append("<img src=\"resource/image/2.png\">")
                     a3=true;
                }else{
                     a2=false;
                    $("#sp3").empty()
                    $("#sp3").append("<img src=\"resource/image/3.png\">")
                }
            })
            $("#add").click(function () {
                if(a1 && a2 && a3){
                    window.location.href="changePass?pass="+$("#p2").val();
                }
            })
        })
    </script>
    <style>
        td{
            width: 150px;
            height: 30px;
            line-height: 30px;
        }
        input{
            width: 100%;
            height: 100%;
        }
        span{
            position: relative;
            left: 10px;
        }
        #add{
            position: relative;
            left: 140px;
            top: 20px;
        }
    </style>
</head>
<body>
    <div>
        <!--top-->
        <div id="top">
            <c:if test="${sessionScope.user!=null}">
                <div  class="welcome">
                    <span>欢迎：${sessionScope.user.name}</span>
                    <a href="exit">退出</a>
                </div>
            </c:if>
        </div>
        <div id="introduce"></div>
        <div id="guid">
            <div id="guid2">
                <ul>
                    <li class="menu">
                        <a href="returnEmployee">主页</a>
                    </li>
                    <li class="menu">
                        <a href="toemployeeinfo" id="a">个人信息</a>
                    </li>
                    <li class="menu">
                        <a href="queryAllEmployeeemp">员工查询</a>
                    </li>
                    <li class="menu">
                        <a href="">查看考勤</a>
                    </li>
                    <li class="menu">
                        <a href="toEmpQueryTrain">查看培训</a>
                    </li>
                    <li class="menu">
                        <a href="">查看薪资</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div id="next">

        <table>
            <tr>
                <td> <label for="p1">请输入原始密码：</label></td>
                <td><input type="password" name="password" id="p1" required></td>
                <td><span id="sp1"></span></td>
            </tr>
            <tr>
                <td> <label for="p2">请输入新密码：</label></td>
                <td><input type="password" name="password" id="p2" required></td>
                <td><span id="sp2"></span></td>
            </tr>
            <tr>
                <td> <label for="p3">请确认密码：</label></td>
                <td><input type="password" name="password" id="p3" required></td>
                <td><span id="sp3"></span></td>
            </tr>

        </table>
        <a id="add" href="javascript:void(0)">确定</a>

    </div>
</body>
</body>
</html>