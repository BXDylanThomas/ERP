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
    <link rel="stylesheet" href="resource/css/next.css">
    <link rel="stylesheet" href="resource/css/table.css">
    <script src="resource/js/jquery-3.3.1.js"></script>
    <script src="resource/js/traindepartment.js"></script>
    <style>
        input[type=text],input[type=date]{
           background: lightcyan;
            width: 100%;
            height: 100%;
            text-align: center;
        }
        td{
            width: 150px;
            height: 40px;
            text-align: center;
        }
    </style>
</head>
<body>
<div style="margin:0 auto;width: 80%">
<jsp:include page="../base.jsp" />

<div id="next">
    <div id="main">
        <br/><br/>

        <form method="post" action="toupdateTrainEmployee">
            <input type="hidden" value="${trains.id}" name="id">
                <table border="1" rules="all">
                      <tr>
                          <td colspan="4">员工培训</td>
                      </tr>
                      <tr>
                          <td colspan="4"rowspan="2" >
                              <b>姓名：</b>
                              <c:forEach items="${trainEmployee}" varStatus="ct" var="te">
                              <c:if test="${te.tId==trains.id}">
                                  ${te.employee.resume.name},
                              </c:if>
                          <c:if test="${ct.count %5==0}"></tr><tr></c:if>
                              </c:forEach>
                          </td>
                      </tr>
                      <tr></tr>
                      <tr>
                          <td>开始时间</td>
                          <td><input type="date" name="startTime" value="${trains.startTime}" ></td>
                          <td>结束时间</td>
                          <td><input type="date" name="endTime"  value="${trains.endTime}"  ></td>
                      </tr>
                      <tr>
                          <td>培训主题</td>
                          <td colspan="3"><input type="text" name="title" value="${trains.title}" ></td>
                      </tr>
                      <tr>
                          <td>培训地点</td>
                          <td colspan="3"><input type="text" name="address"  value="${trains.address}" ></td>
                      </tr>
                      <tr>
                          <td colspan="4">培训内容</td>
                      </tr>
                      <tr>
                          <td colspan="4" style="height: 100px">
                              <input type="text" value="${t.title}"  name="content">
                          </td>
                      </tr>
                </table>
            <input type="submit" value="确定" id="sub" class="send" style="position: relative;left: 200px;top: 20px;">
        </form>

    </div>


</div>
</div>
</body>
</html>