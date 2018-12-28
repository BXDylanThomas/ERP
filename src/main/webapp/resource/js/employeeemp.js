$(function () {
    //查询某部门
    $("#department option").click(function () {
        if($(this).val()!='-1'){
            window.location.href="queryAllEmployeeByDepIdemp?depId="+$("#department").val();
        }

    })

    $("#position option").click(function () {
        if($(this).val()!='-1'){
            window.location.href="queryAllEmployeeByPosIdemp?posId="+$("#position").val();
        }
    })
})