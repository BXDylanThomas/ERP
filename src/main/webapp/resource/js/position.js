$(function () {
    //查询某部门
    $("#select option").click(function () {
        if($(this).val()!="-1"){
           window.location.href="queryPosition?depId="+$("#select").val();
        }
    })

    $("#addsure").click(function () {
        var id=$("#sel");
        var name=$("#name")
        if(id!="-1"){
            $.ajax({
                type:"post",url:"addPosition",
                data:"depId="+id.val()+"&name="+name.val(),
                success:function (obj) {
                    if(obj==1){
                        alert("添加成功")
                        window.location.href="queryALlPosition";
                    }else{
                        alert("添加失败")
                    }
                }
            })
        }

    })

    //修改部门    更新部门名称
    $(".update").click(function () {
        var id=$(this).next();
        var name=$(this).parent().parent();
        if($(this).text()=="修改"){
            name.attr("id","aa")

            $("#aa :nth-child(3) :nth-child(1)").removeAttr("disabled");
            $("#aa :nth-child(3) :nth-child(1)").css({"border":"solid black 1px","background":"lightcyan"})
            $(this).text("确定")
        }else{
            $.ajax({
                type:"post",url:"updatePosition",
                data:"id="+id.val()+"&name="+$("#aa :nth-child(2) :nth-child(1)").val(),
                success:function (obj) {
                    if(obj==1){

                    }else{
                        alert("请确认，职位名称重复")
                    }
                }
            })
            $("#aa :nth-child(3) :nth-child(1)").attr("disabled","disabled");
            $("#aa :nth-child(3) :nth-child(1)").css({"border":"none","background":"white"})
            $("#aa").removeAttr("id")
            $(this).text("修改")

        }
    })

    //全选操作
    $("#all").click(function () {
        $(":checkbox").attr("checked",this.checked)
    })
    //删除操作
    $("#del").click(function () {
        var c=$(":checkbox");

        for (var i = 0; i < c.length; i++) {
            if(c[i].checked){
                //进行删除操作
                $.ajax({
                    type:"post",url:"deletePosition",data:"id="+c[i].value,async:false,
                    success:function (obj) {
                        if(obj==0){
                            alert("存在在职人员，不能删除部门")
                            return;
                        }
                    }
                })
            }
        }
        window.location.href="queryALlPosition";
    })

})