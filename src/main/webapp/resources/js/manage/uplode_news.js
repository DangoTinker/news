$(document).ready(function () {
    layui.use(['form'], function(){
        var form = layui.form

        //自定义验证规则
        form.verify({
            news_title: function(value){
                if(value.length < 1){
                    return '新闻标题不能为空';
                }
            },
            news_category: function(value){
                if(value.length < 1){
                    return '新闻类别不能为空';
                }
            },
            news_context: function(value){
                if(value.length < 1){
                    return '新闻内容不能为空';
                }
            },
            photo: function(value){
                if(value.length < 1){
                    return '图片url不能为空';
                }
            },
            content: function(value){
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

        //添加
        $("#sub").click(function () {
            let news_title=$("#news_title").val()
            let news_category=$("#news_category").val()
            let news_context=$("#news_context").val()
            let photo=$("#photo").val()
            $.ajax({
                type:"POST",
                url:'',
                async: true,
                data:{"newsName":news_title,"newsCategory":news_category,"newsContext":news_context,"photo":photo},
                dataType: "json",
                success:function (data) {
                    let s=data.success
                    if(s){

                    }else{
                        alert("添加失败")
                    }
                },
                error:function () {
                    console.log("请求失败")
                }
            })
        })
    });
})