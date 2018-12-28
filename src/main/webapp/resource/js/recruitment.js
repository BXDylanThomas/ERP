$(function () {
    $("#department option").click(function () {
        var depId=$(this).val()
        if($(this).val()!="-1"){
            $.ajax({
                type:"post",url:"queryRe",
                data:"depId="+depId,
                success:function (obj) {
                    $("#position").empty()
                    for( var i in obj){
                        $("#position").append("<option value="+obj[i].id+">"+obj[i].name+"</option>")
                    }
                }
            })
        }
    })
})