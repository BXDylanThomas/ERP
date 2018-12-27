$(function () {
    //查询某部门
    $("#department option").click(function () {
        window.location.href="queryAllEmployeeByDepIdemp?depId="+$("#department").val();
    })

    $("#position option").click(function () {
        window.location.href="queryAllEmployeeByPosIdemp?posId="+$("#position").val();
    })
})