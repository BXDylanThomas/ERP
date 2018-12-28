$(function () {


    //选择 是否发布
    $("#choice").change(function () {
        var tdid=$("#department")
        var state=$(this)
        if(state.val()=='1' || state.val()=='0'){
            //状态 =1 0   选择已经发布   如果部门没有选择   查询所有的培训  带状态
            //状态 =1 0  选择已经发布   有选择部门   查询所有的部门培训 带状态
            if(tdid.val()=="-1"){
                window.location.href="queryTrainDepartmentState?state="+$(this).val()+"&current=1";
            }else{
                window.location.href="queryTrainDepartmentDEPState?state="+$(this).val()+"&depId="+tdid.val()+"&current=1";
            }
        }
    })

    //选择查看部门 所有
    $("#department").change(function () {
        var state=$("#choice")
        if($(this).val()!='-1'){
            //如果 等于 -1 说明 查的是部门中所有的培训内容
            //如果 等于  1 说明 查的是部门中  是否 发布  的内容
            if(state.val()=='-1'){

                window.location.href="queryTrainDepartmentDEP?depId="+$(this).val()+"&current=1";
            }else{

                window.location.href="queryTrainDepartmentDEPState?state="+state.val()+"&depId="+$(this).val()+"&current=1";
            }
        }
    })

})