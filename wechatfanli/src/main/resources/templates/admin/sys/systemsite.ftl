<!DOCTYPE html>
<html class="x-admin-sm">

    <head>
        <title>系统设置</title>
        <#include "/admin/common/common.ftl">
    </head>
    <body style="background-color:#fff">
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form" lay-filter="example">
                    <input type="hidden" name="tokens" value="${tokens!}">
                    <input type="hidden" name="id" value="${(entity.id)!}">
                     
                    <div class="layui-form-item">
                          <label class="layui-form-label">
                              <span class="x-red">*</span>商品拉取key：
                         </label>
                        <div class="layui-input-inline">
                              <input type="text" name="apikey" required="" lay-verify="required"
                                autocomplete="off" class="layui-input" value="${(entity.apikey)!}" maxlength="100" >
                          </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class="x-red">*</span>查优惠券券key：
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" name="authkey" required="" lay-verify="required"
                              autocomplete="off" class="layui-input" value="${(entity.authkey)!}" maxlength="500">
                        </div>
                    </div>
                    
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class="x-red">*</span>淘宝授权ID：
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" name="taoauthid" required="" lay-verify="required"
                              autocomplete="off" class="layui-input" value="${(entity.taoauthid)!}" maxlength="500">
                        </div>
                    </div>
                    
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class="x-red">*</span>推广位PID：
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" name="pid" required="" lay-verify="required"
                              autocomplete="off" class="layui-input" value="${(entity.pid)!}" maxlength="500">
                        </div>
                    </div>
                    
                      
                    
                    <div class="layui-form-item">
                        <label class="layui-form-label"></label>
                        <button class="layui-btn" lay-filter="add" lay-submit="">提交</button>
                    </div>
              </form>
            </div>
        </div>
        <script type="text/javascript">
            layui.use(['form', 'layer'], function () {
                var form = layui.form;
                var layer = layui.layer;
                var $ = layui.$;
 
                form.on('submit(add)', function (data) {
                    $('.layui-form-item .layui-btn').prop('disabled', true);
                    $('.layui-form-item .layui-btn').text('提交中...');
                    var url = '/cms/system/addOrUpdate';
                    $.ajax({
                        type: 'post',
                        url: url,
                        data: data.field,
                        dataType: 'json',
                        success: function (data) {
                            if (data.code !== 0) {
                                $('.layui-form-item .layui-btn').prop('disabled', false);
                                $('.layui-form-item .layui-btn').text('提交');
                                layer.msg(data.msg);
                                return false;
                            }
                            xadmin.close();
                            layer.closeAll();
                            parent.reload();
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            $('.layui-form-item .layui-btn').prop('disabled', false);
                            $('.layui-form-item .layui-btn').text('提交');
                            layer.msg('系统异常');
                        }
                    });
                    return false;
                });
            });

        </script>
        <style type="text/css">
            .layui-form-label {
                width: 200px;
            }
        </style>
    </body>
</html>
