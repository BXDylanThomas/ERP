$(function () {


    //选择 是否发布
    $("#choice").change(function () {
        var state=$(this)
        if(state.val()=='1' || state.val()=='0'){
             window.location.href="queryAllTrainEmployeeByState?state="+$(this).val()+"&current=1";
        }
    })
})