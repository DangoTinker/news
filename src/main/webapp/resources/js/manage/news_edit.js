$(document).ready(function () {
    layui.use('table', function(){
        var table = layui.table;

        //监听单元格编辑
        //修改
        table.on('edit(test3)', function(obj){

            var value = obj.value //得到修改后的值
                ,data = obj.data //得到所在行所有键值
                ,field = obj.field; //得到字段

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
            layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
        });

        //监听
        //删除
        table.on('tool(text3)',function (obj) {

            var data = obj.data //得到所在行所有键值

            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    $.ajax({
                        type:"GET",
                        url:'',
                        async: true,
                        data:{"newsId":data.id},
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
                });
            }
        });


    });
})