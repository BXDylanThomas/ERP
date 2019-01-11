
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
    <script src="resource/js/jquery-3.3.1.js"></script>
    <script src="resource/js/alert.js"></script>
    <script>
        $(function () {
            $("#cal").click(function () {
                var res=confirm("是否确定");
                if(res){
                    $.ajax({
                        type:"post",url:"toSalarycal",success:function (obj) {
                            if(obj==0){
                                jQuery.alertWindow("上月工资已经结算")
                            }else{
                                jQuery.alertWindow("结算成功")
                            }
                        }
                    })
                }

            })
        })
    </script>
    <style>
        #main a{
            margin: 10px 0px;
        }
    </style>
</head>
<body>
<div style="margin:0 auto;width: 80%">
    <jsp:include page="../base.jsp" />

    <div id="next">
        <div id="main" >
            <a href="javascript:void(0)" class="send" style="height: 40px" id="cal">结算上月工资</a>
            <br/><a href="queryAllReviewSalary" class="send" style="height: 40px" >查看工资复议</a>
        </div>
    </div>
</div>
</body>
</html>
