$(document).ready(function () {
    layui.use('table', function(){
        var table = layui.table;
        //监听表格复选框选择
        table.on('checkbox(demo)', function(obj){
            console.log(obj)
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
            var value = obj.value //得到修改后的值
                ,data = obj.data //得到所在行所有键值
                ,field = obj.field; //得到字段
            //修改
            $.ajax({
                type:"post",
                url:'',
                async: true,
                data:{"id":data.id,'field':field,"value":value},
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

            //删除
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    $.ajax({
                        type:"GET",
                        url:'/deleteAccess',
                        async: true,
                        data:{"accessId":data.accessId},
                        dataType: "json",
                        success:function (data) {
                            let s=data.success
                            if(s){
                                obj.del();
                            }else{
                               alert("删除失败")
                            }
                        },
                        error:function () {
                            console.log("请求失败")
                        }
                    })
                    layer.close(index);
                })
            }
        });

        var $ = layui.$, active = {
            getCheckData: function(){ //获取选中数据
                var checkStatus = table.checkStatus('power')
                    ,data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            }
            ,getCheckLength: function(){ //获取选中数目
                var checkStatus = table.checkStatus('power')
                    ,data = checkStatus.data;
                layer.msg('选中了：'+ data.length + ' 个');
            }
            ,isAll: function(){ //验证是否全选
                var checkStatus = table.checkStatus('power');
                layer.msg(checkStatus.isAll ? '全选': '未全选')
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
})