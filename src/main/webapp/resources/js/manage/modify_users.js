$(document).ready(function () {
    layui.use(['form', 'layedit', 'laydate'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate;

        //日期
        laydate.render({
            elem: '#date'
        });
        laydate.render({
            elem: '#date1'
        });

        //创建一个编辑器
        var editIndex = layedit.build('LAY_demo_editor');

        //自定义验证规则
        form.verify({
            user_birth: function(value){
                if(value.length < 1){
                    return '生日不能为空';
                }
            },
            user_name: function(value){
                if(value.length < 1){
                    return '姓名不能为空';
                }
            }
            ,content: function(value){
                layedit.sync(editIndex);
            }
        });

        //监听提交
        form.on('submit(demo1)', function(data){
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })
            return false;
        });
        $("#sub").click(function () {
            let userName=$("#news_title").val()
            let userBirth=$("#news_category").val()
            let sex=$('input[name="sex"]').val()
            $.ajax({
                type:"POST",
                url:'',
                async: true,
                data:{"userName":userName,"userBirth":userBirth,"gender":sex},
                dataType: "json",
                success:function (data) {
                    let s=data.success
                    if(s){
                        alert("修改成功")
                    }else{
                        alert("修改失败")
                    }
                },
                error:function () {
                    console.log("请求失败")
                }
            })
        })
    });
})