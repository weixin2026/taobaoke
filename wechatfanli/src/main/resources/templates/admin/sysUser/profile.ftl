<!DOCTYPE html>
<html class="x-admin-sm">
    <head>
        <title>个人信息</title>
        <#include "/admin/common/common.ftl">
    </head>
    <body style="background-color:#fff">
        <div class="layui-fluid">
            <div class="layui-row">
                <form class="layui-form">
                    <input type="hidden" name="tokens" value="${tokens!}">
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            <span class="x-red">*</span>昵称：
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" name="nickname" value="${(sysUser.nickname)!}" required="" lay-verify="required" autocomplete="off" class="layui-input" maxlength="20">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            手机号码：
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" name="phonenumber" value="${(sysUser.phonenumber)!}" required="" autocomplete="off" class="layui-input" maxlength="11">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">
                            邮箱：
                        </label>
                        <div class="layui-input-inline">
                            <input type="text" name="email" required="" value="${(sysUser.email)!}" autocomplete="off" class="layui-input" maxlength="50">
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
                    var id = $("input[name='id']").val();
                    $.ajax({
                        type: 'post',
                        url: '/cms/sysUser/profile',
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
                            parent.location.reload();
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
    </body>
</html>
