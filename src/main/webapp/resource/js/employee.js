$(function () {
    //查询某部门
    $("#department option").click(function () {
        window.location.href="queryAllEmployeeByDepId?depId="+$("#department").val();
    })

    $("#position option").click(function () {
        window.location.href="queryAllEmployeeByPosId?posId="+$("#position").val();
    })
})