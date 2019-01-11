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
    <link rel="stylesheet" href="resource/css/button.css">

    <script src="resource/js/jquery-3.3.1.js"></script>

    <script>
        $(function(){
            var raid = $("#raid");

            setInterval(function(){
                move(0);
            },40);

            function move(num){
                var time = new Date();
                raid.html(time.getFullYear()+"年"+(time.getMonth()+1)+"月"+(time.getDate())+"日");
                raid.append(time.toTimeString().split(" ")[0]);
            }
        });
    </script>

    <style>
        table{
            margin-top: 20px;
        }
        td{
            width: 100px;
            height: 100px;
            text-align: center;
        }
        #next{
            position: relative;
            left: 300px;
        }
        #raid{
            font-size: 15px;
        }
    </style>
</head>
<body>
<div style="margin:0 auto;width: 80%">
<jsp:include page="base.jsp" />
    <div id="next">
        <br/>
        <div id="raid"></div>
        <br/>
        <span style="font-size: 20px">上月考勤</span>&emsp; <a href="queryPrizeRecordEmpId" class="send"> 查看历史奖惩</a><br/>
        <table border="1" rules="all">
            <tr>
                <c:forEach items="${max}" var="day" varStatus="i">

                    <td>
                        ${day}<br/>
                        <c:set var="flag" value="false"/>
                        <c:if test="${checkRecords!=null && not empty checkRecords}">
                        <c:forEach items="${checkRecords}" var="c">
                            <c:if test="${c.workTime.split('-')[2].split(' ')[0]==day}">

                                <c:set var="flag" value="true"/>
                                <c:if test="${c.workState==4 || c.offState==4}">
                                    旷工&nbsp;
                                </c:if>
                                <c:if test="${c.workState!=4 && c.offState!=4}">
                                    <c:if test="${c.overTime==1}">
                                        加班&nbsp;
                                    </c:if>
                                    <c:if test="${c.workState==1 &&c.offState==1}">
                                        正常
                                    </c:if>
                                    <c:if test="${c.workState==1 && c.offState==3}">
                                        早退
                                    </c:if>
                                    <c:if test="${c.workState==2 && c.offState==1}">
                                        迟到
                                    </c:if>
                                    <c:if test="${c.workState==2 && c.offState==3}">
                                        迟到&nbsp;早退
                                    </c:if>
                                </c:if>
                            </c:if>
                        </c:forEach>
                        </c:if>
                        <c:if test="${flag==false}">
                            旷工
                        </c:if>
                    </td>

                    <c:if test="${i.count%7==0}">
                    </tr><tr>
                    </c:if>

                 </c:forEach>
             </tr>
        </table>

    </div>
</div>
</body>

</body>
</html>