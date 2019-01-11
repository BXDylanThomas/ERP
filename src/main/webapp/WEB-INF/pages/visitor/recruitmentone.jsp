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
    <link rel="stylesheet" href="resource/css/table.css">
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
                        }else if(obj==-2){
                            alert("还没有简历")
                        }
                        else if(obj==0){
                            alert("已经投递")
                        }else{
                            alert("投递成功")
                        }
                    }
                })
            })
        })
    </script>
    <style>
        #next{
            position: relative;
            left: 300px;
            top: 20px;
        }
    </style>
</head>
<body>
<div style="margin:0 auto;width: 80%">
    <jsp:include page="base.jsp" />
    <div id="next">
        <table border="1" rules="all">
            <tr>
                <th colspan="3" >招聘信息</th>
                <td rowspan="10" style="width: 80px">
                    <a href="javascript:void(0)" class="send">投递简历</a>
                    <input type="hidden" value="${recruitment.id}" >
                </td>
            </tr>
            <tr>
                <th>部门</th>
                <td colspan="2">  ${recruitment.positions.department.name} </td>
            </tr>
            <tr>
                <th>职位</th>
                <td colspan="2"> ${recruitment.positions.name}  </td>
            </tr>
            <tr>
                <th >标题</th>
                <td colspan="2">${recruitment.title}</td>
            </tr>
            <tr>
                <th colspan="3">要求</th>
            </tr>
            <tr>
                <td colspan="3">${recruitment.content}</td>
            </tr>
            <tr></tr>
            <tr></tr>
            <tr>
                <th>招聘人数：</th>
                <td colspan="2">${recruitment.count}个</td>
            </tr>
            <tr>
                <th>发布时间</th>
                <td colspan="2">${recruitment.createTime}</td>
            </tr>

        </table>
    </div>

</div>

</body>
</html>