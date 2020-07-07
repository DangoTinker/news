$(document).ready(function () {
    //检测账号是否已经存在
    $("#semail").blur(function () {
        let email=$("#semail").val()
        $.ajax({
            type:"GET",
            url:'/checkUserEmail',
            async:true,
            data:{"email":email},
            dataType:"json",
            success:function (data) {
                let s=data.success
                if(s){
                    alert("账户已存在")
                }else{

                }
            },
            error:function () {
                console.log("请求失败")
            }
        })
        $("#signUp").click(function () {
            let email=$('#semail').val()
            let username=$('#sname').val()
            let password=$('#spassword').val()
            $.ajax({
                type:"GET",
                url:'/userSignUp',
                async:true,
                data:{"email":email,"username":username,"password":password},
                dataType:"json",
                success:function (data) {
                    let s=data.success
                    if(s){
                        alert("创建用户成功")
                        location.href="index.html"
                    }else{
                        alert("创建用户失败,请稍后重试")
                    }
                },
                error:function () {
                    console.log("请求失败")
                }
            })
        })
    })
})