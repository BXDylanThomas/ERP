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
    <script src="resource/js/jquery-3.3.1.js"></script>
    <link rel="stylesheet" href="resource/css/button.css">
    <script type="text/javascript" src="resource/js/jquery-1.11.0.js" ></script>
    <script type="text/javascript" src="resource/js/circle_JT_min.js" ></script>
    <script>
        $(function () {
            $("button").click(function () {
                var result=$("#result").val()
                if(result==""){
                    window.location.href="goWork";
                }else{
                    window.location.href="goHome";
                }
            })
        })
    </script>
    <style>
       #next{
           position: relative;
           left: 500px;
       }
        #main{
            position: relative;
            left: 50px;
        }
    </style>
</head>
<body>
<div style="margin:0 auto;width: 80%">
    <jsp:include page="base.jsp" />
    <div id="next">
        <div id="dom"></div>

        <div id="main">
            <br/> <br/>
            <input type="hidden" value="${result}" id="result">
            <c:if test="${result==null}">
                <button value="上班打卡" class="send">上班打卡</button>
            </c:if>
            <c:if test="${result.offTime==null && result.workTime!=null}">
                <span  class="send" style="position: relative;left: -60px">上班时间：${result.workTime}</span><br/><br/>
                <button value="下班打卡" class="send">下班打卡</button>
            </c:if>
            <c:if test="${result.offTime!=null}">
                <span class="send" style="position: relative;left: -60px">上班时间：${result.workTime}</span><br/><br/>
                <span class="send" style="position: relative;left: -60px">下班时间：${result.offTime}</span>
            </c:if>
        </div>
    </div>
</div>
<script>
    $.circleJt({
        domId:'dom',//必须
        radius:100,//必须
        pbColor:'#00796b',//必需
        pbWidth:10,//非必需
        value:0,//必须
        totalValue:1000,//非必需
        percentage:true,//非必需
        fontSize:30,

        clock:true,//如果clock为真的时候，上述属性除value,totalValue,percentage均全都无效
        digitalWatch:true//以电子表形式显示
    });


</script>
</body>

</body>
</html>