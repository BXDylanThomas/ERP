$(function () {
    $("#sub").click(function () {

        if($(this).val()=="修改"){

            $(":text").css({"border":"solid red 1px","background":"lightcyan"})
            $(":text").removeAttr("readonly")
            $("textarea").css({"border":"solid red 1px","background":"lightcyan"})
            $("textarea").removeAttr("readonly")
            $(this).val("确定")
        }else{
            $("#f").submit();

        }
    })
})