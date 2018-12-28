$(function () {
    //查询某部门
    $("#department option").click(function () {
        if($(this).val()!="-1"){
            window.location.href="queryAllEmployeeByDepId?depId="+$("#department").val();
        }
    })

    $("#position option").click(function () {
        if($(this).val()!="-1") {
            window.location.href = "queryAllEmployeeByPosId?posId=" + $("#position").val();
        }
    })
})