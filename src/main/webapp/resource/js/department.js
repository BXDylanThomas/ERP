$(function () {
    $("#add").click(function () {
        var add = $("#ad");
        $("#add").css("pointer-events", "none");

          add.before("<tr>" +
              "<td></td>" +
              "<td><input type='text'id='newadd' required> </td>" +
              "<td></td>"+
              "<td><a href='javascript:void(0)' id='add3' >确定添加</a></td>"+
              "</tr>");
        $("#newadd").css({"border":"solid black 1px","background":"lightcyan"})

        $("#add3").click(function () {
            $.ajax({
                type: "post", url: "addDepartment",
                data: "name=" + $("#newadd").val(),
                success: function (obj) {
                    if(obj==1){
                        window.location.href="queryDepartment"
                    }else{
                        alert("添加失败,部门名重复")
                    }
                }
            })
        })
    })

    //修改部门    更新部门名称
    $(".update").click(function () {
        var id=$(this).next();
        var name=$(this).parent().parent();
        if($(this).text()=="修改"){
            name.attr("id","aa")

            $("#aa :nth-child(2) :nth-child(1)").removeAttr("disabled");
            $("#aa :nth-child(2) :nth-child(1)").css({"border":"solid black 1px","background":"lightcyan"})
            $(this).text("确定")
        }else{

            $.ajax({
                type:"post",url:"updateDepartment",
                data:"id="+id.val()+"&name="+$("#aa :nth-child(2) :nth-child(1)").val(),
                success:function (obj) {
                    if(obj==1){
                    }else{
                        alert("请确认，部门名称重复")
                    }
                }
            })
            $("#aa :nth-child(2) :nth-child(1)").attr("disabled","disabled");
            $("#aa :nth-child(2) :nth-child(1)").css({"border":"none","background":"white"})
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
                    type:"post",url:"deleteDepartment",data:"id="+c[i].value,async:false,
                    success:function (obj) {
                        if(obj==0){
                            alert("存在职位，不能删除部门")
                            return;
                        }
                    }
                })
            }
        }
        window.location.href="queryDepartment";
    })

})