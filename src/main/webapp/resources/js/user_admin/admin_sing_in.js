$(document).ready(function () {
    $("#username").blur(function () {
        let username=$("#username").val()
        $.ajax({
            type:"GET",
            url:'/checkAdminEmail',
            async: true,
            data:{"username":username},
            dataType: "json",
            success:function (data) {
                let s=data.success
                if(s){

                }else{
                    alert("用户不存在,")
                    $("#username").empty()
                }
            },
            error:function () {
                console.log("请求失败")
            }
        })
    })
    $("#send-btn").click(function () {
        let username=$("#username").val()
        let password=$("#password").val()
        $.ajax({
            type:"GET",
            url:'/adminSignIn',
            async: true,
            data:{"username":username,"password":password},
            dataType: "json",
            success:function (data) {
                let s=data.success
                if(s){
                    location.href="CompetenceControl.html"
                }else{
                    alert("用户不存在,登陆失败")
                    $("#username").empty()
                }
            },
            error:function () {
                console.log("请求失败")
            }
        })
    })
})