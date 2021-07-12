<!DOCTYPE html>
<html class="x-admin-sm">
    <head>
        <title>红包活动列表</title>
        <#include "/admin/common/common.ftl">
    </head>
    <body>
        <div class="x-nav">
          <span class="layui-breadcrumb">
            <a>首页</a>
            <a><cite>系统管理</cite></a>
            <a><cite>返利红包活动管理</cite></a>
          </span>
          <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" onclick="location.reload()" title="刷新">
            <i class="layui-icon layui-icon-refresh" style="line-height:30px"></i>
          </a>
        </div>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <form class="layui-form layui-col-space5">
                                <div class="layui-inline layui-show-xs-block">
                                    <input type="text" name="name"  placeholder="请输入活动名" autocomplete="off" class="layui-input">
                                </div>
                                
                                
                                <div class="layui-inline layui-show-xs-block">
                                    <button class="layui-btn" lay-submit="" lay-filter="sreach">搜索</button>
                                    <button class="layui-btn layui-btn-warm btn-reset" type="button">清空</button>
                                </div>
                            </form>
                        </div>
                        
                        <div class="layui-card-header">
                          <button class="layui-btn layui-btn-danger" event="delAll"><i class="layui-icon">&#xe640;</i>批量删除</button>
                          <button class="layui-btn" onclick="xadmin.open('添加返利红包活动','/cms/redenvelope/add/dispatch',700,500)">添加</button>
                        </div>
                        <div class="layui-card-body ">
                            <table class="layui-hide" id="x-table" lay-filter="l-f-table"></table>
                        </div>
                    </div>
                </div>
            </div>
        </div> 
    </body>
    <script type="text/javascript">
        var table = null;
        var $ = null;

        layui.use(['table', 'form', 'layer', 'laydate'], function () {

            table = layui.table;
            $ = layui.$;

            var form = layui.form;
            var layer = layui.layer;
            var laydate = layui.laydate;

            var wrapper_width = $('.lcontent').width();
 

            form.on('submit(sreach)', function (data) {
                reload(data.field);
                return false;
            });

            table.render({
                elem: '#x-table'
                , url: '/cms/redenvelope/pageList'
                , method: 'post'
                , width: wrapper_width
                , cols: [[
                    {type:'checkbox', fixed: 'left', unresize: true}
                    , {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left', unresize: true}
                    , {field: 'name', title: '活动名'}
                    , {field: 'type', title: '红包类型',templet: typeRender}
                    , {field: 'kl', title: '口令'}
                    , {field: 'content', title: '内容'}
                    , {field: 'createTime', title: '创建时间', templet: timeRender, width: 200}
                    , {title: '操作', templet: operateRender, width: 250, fixed: 'right', unresize: true}
                ]]
                , page: true
                , limit: 20
                , request: {
                    // pageName: 'page',
                    limitName: 'rows'
                }
                ,response: {
                    // statusName: 'code', //规定数据状态的字段名称，默认：code
                    // statusCode: 0, //规定成功的状态码，默认：0
                    // msgName: 'msg', //规定状态信息的字段名称，默认：msg
                    // countName: 'data.records', //规定数据总数的字段名称，默认：count
                    // dataName: 'data.rows' //规定数据列表的字段名称，默认：data
                    statusCode: 0
                }
                , parseData: function (res) { //res 即为原始返回的数据
                    return {
                        "code": res.code, //解析接口状态
                        "msg": res.msg, //解析提示文本
                        "count": res.data.records, //解析数据长度
                        "data": res.data.rows //解析数据列表
                    };
                }
                , id: 'x-i-table'
            });

            table.on('tool(l-f-table)', function (obj) {
                var data = obj.data;
                var layEvent = obj.event;
                
                if (layEvent === 'update') {
                    xadmin.open('修改配置', '/cms/redenvelope/update/dispatch?id=' + data.id, 700, 500);
                }
                
                if (layEvent === 'delete') {
                    layer.confirm('删除后不可恢复，确认删除？', function () {
                        del(data.id);
                    });
                }
            });

            function timeRender(d) {
                return timeFormat(d.createTime);
            }
            
            function typeRender(d) {
                if (d.type === 1) {
                    return '支付宝红包';
                }
                if (d.type === 2) {
                    return '饿了么红包';
                }
                return '未知';
            }

            function operateRender(d) {
                var update ='<button class="layui-btn layui-btn-sm layui-btn-warm" lay-event="update"><i class="layui-icon">&#xe642;</i>修改</button>';
                var del ='<button class="layui-btn layui-btn-sm layui-btn-danger" lay-event="delete"><i class="layui-icon">&#xe640;</i>删除</button>';
                return update + del;
            }

            function del(ids) {
                $.ajax({
                    type: 'post',
                    url: '/cms/redenvelope/deletes',
                    data: {
                        ids:ids
                    },
                    dataType: 'json',
                    success: function (data) {
                        layer.closeAll();
                        if (data.code !== 0) {
                            layer.msg(data.msg);
                            return false;
                        }
                        reload();
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        layer.closeAll();
                        layer.alert('系统异常');
                    }
                });
            }

            var active = {
                delAll: function () {
                    // 这里必须要用x-i-table，不能用x-table，也不能用l-f-table
                    var tableCheck = table.checkStatus('x-i-table');
                    var data = tableCheck.data;
                    if (data.length <= 0) {
                        layer.msg('请至少选择一条数据');
                        return false;
                    }
                    var deList = [];
                    data.forEach(function (n, i) {
                        deList.push(n.id);
                    });
                    layer.confirm('删除后不可恢复，确认删除？', function () {
                        del(deList+'');
                    });
                }
            };

            $('.layui-btn').on('click', function() {
                var event = $(this).attr('event');
                active[event] ? active[event].call(this) : '';
            });

            $('.btn-reset').on('click', function() {
                reset();
            });
        });

        function reset() {
            $('.layui-form.layui-col-space5 input, .layui-form.layui-col-space5 select').val('');
            reload(formJson());
        }

        function formJson() {
            var array = $('form').serializeArray();
            var json = {};
            $(array).each(function () {
                json[this.name] = this.value;
            });
            // console.log(json);
            // return JSON.stringify(json);
            return json;
        }

        function reload(param) {
            
            table.reload('x-i-table', {
                where: param || {}
                , page: {
                    curr: 1
                }
            });
        }
    </script>
</html>