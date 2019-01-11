<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <link rel="stylesheet" href="resource/css/button.css"/>
    <link rel="stylesheet" href="resource/css/layui.css"/>
    <link rel="stylesheet"  href="resource/css/table.css">

    <script>
        layui.use('jquery', function(){
            var $ = layui.jquery;
            var submit = function(){
                return false;
            };
            $('#test').on('submit', function(){
                return false
            });
            $('#test').on('submit', function(){
                return true
            });
        });
    </script>
    <style>
        #next{
            position: relative;
            left: 300px;
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

<div style="width: 800px;position: relative;left: 100px;top: 20px;">


    <form class="layui-form layui-form-pane1" action="addresumemake" lay-filter="first">
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input type="text" name="name" lay-verify="required|title" required placeholder="请输入姓名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="text" name="sex" lay-verify="required|title" required autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">出身年月</label>
            <div class="layui-input-block">
                <input type="date" name="bir" lay-verify="required|title" required  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">最高学历</label>
            <div class="layui-input-block">
                <input type="text" name="education" lay-verify="required|title" required placeholder="请输入最高学历" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">专业</label>
            <div class="layui-input-block">
                <input type="text" name="major" lay-verify="required|title" required placeholder="请输入专业" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">联系电话</label>
            <div class="layui-input-block">
                <input type="tel" name="phone" lay-verify="required|number" lay-verType="tips" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-block">
                <input type="email" name="email" lay-verify="email"  lay-verType="alert" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">联系地址</label>
            <div class="layui-input-block">
                <input type="text" name="address" lay-verify="required|title" required placeholder="请输入姓名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">工作经验</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入内容" class="layui-textarea" name="experience"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="*">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>

</div>
</div>
<script src="resource/js/layui.js"></script>
<!-- <script src="../build/lay/dest/layui.all.js"></script> -->

<script>

    layui.use('form', function(){
        var form = layui.form;

        //自定义验证规则
        form.verify({
            title: function(value){
                if(value.length < 5){
                    return '标题也太短了吧';
                }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,money: [
                /^\d+\.\b\d{2}\b$/
                ,'金额必须为小数保留两位'
            ]
        });

        //初始赋值
        form.val('first', {
            'title': '测试'
            ,'phone': 11111111111
            ,'email': 'xu@sentsin.com'
            ,'password': 123123
            //,'quiz': 2
            ,'interest': 3
            ,'like[write]': true
            //,'open': false
            ,'sex': '男'
            ,'desc': 'form 是我们非常看重的一块'
            ,xxxxxxxxx: 123
        });


        //事件监听
        form.on('select', function(data){
            console.log('select: ', this, data);
        });

        form.on('select(quiz)', function(data){
            console.log('select.quiz：', this, data);
        });

        form.on('select(interest)', function(data){
            console.log('select.interest: ', this, data);
        });



        form.on('checkbox', function(data){
            console.log(this.checked, data.elem.checked);
        });

        form.on('switch', function(data){
            console.log(data);
        });

        form.on('radio', function(data){
            console.log(data);
        });

        //监听提交
        form.on('submit(*)', function(data){
            console.log(data)
            alert(JSON.stringify(data.field));
            return false;
        });

    });

</script>

</body>
</html>

<%--<div id="next">
        <form method="post" action="addresumemake">
            <table border="1" rules="all">
                <tr>
                    <th colspan="4">简历</th>
                </tr>
                <tr>
                    <th>姓名：</th>
                    <td><input type="text" name="name" required ></td>
                    <th>性别：</th>
                    <td><input type="text" name="sex" required></td>
                </tr>
                <tr>
                    <th>出身年月：</th>
                    <td><input type="date" name="bir" required></td>
                    <th>联系电话：</th>
                    <td><input type="text" name="phone" required></td>
                </tr>
                <tr>
                    <th>专业：</th>
                    <td><input type="text" name="major" required></td>
                    <th>最高学历：</th>
                    <td><input type="text" name="education"required ></td>
                </tr>
                <tr>
                    <th>邮箱：</th>
                    <td colspan="3"><input type="text" name="email"required ></td>
                </tr>
                <tr>
                    <th>联系地址：</th>
                    <td colspan="3"><input type="text" name="address" required></td>
                </tr>
                <tr>
                    <th colspan="4">工作经验：</th>
                </tr>
                <tr>
                    <td colspan="4">
                        <input type="text" style="width:100%;height:150px" name="experience" required >
                    </td>
                </tr>
            </table>
            <input type="submit" value="确定"  class=".button">
        </form>
</div>--%>