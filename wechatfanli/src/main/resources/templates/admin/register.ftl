<!doctype html>
<html class="x-admin-sm">
<head>
    <title>公众号管理系统</title>
    <#include "/admin/common/common.ftl">
    <link rel="stylesheet" href="/static/xadmin/css/login.css">
</head>
<body class="login-bg">

    <div class="login layui-anim layui-anim-up">
        <div class="message">公众号管理系统</div>
        <div id="darkbannerwrap"></div>

        <form method="post" class="layui-form">
            <input name="userName" placeholder="账号" type="text" lay-verify="required" class="layui-input">
            <hr class="hr15">
            <input name="password" lay-verify="required" placeholder="密码" type="password" class="layui-input">
            <hr class="hr15">
            <input name="nickName" lay-verify="required" placeholder="昵称" type="text" class="layui-input">
            <hr class="hr15">
            <input value="注册" lay-submit lay-filter="login" style="width:100%;" type="submit">
            <hr class="hr20">
            <span class="x-red">*默认注册用户只有公众号配置权限</span>
        </form>
    </div>

    <script type="text/javascript">
        layui.use(['form', 'layer'], function () {

            var form = layui.form;
            var layer = layui.layer;
            var $ = layui.$;

            form.on('submit(login)', function (data) {
                $("input[type='submit']").prop('disabled', true);
                $("input[type='submit']").val('注册中...');
                $.ajax({
                    type: 'post',
                    url: '/register',
                    data: data.field,
                    dataType: 'json',
                    success: function (data) {
                        if (data.code !== 1001) {
                            $("input[type='submit']").prop('disabled', false);
                            $("input[type='submit']").val('注册');
                            layer.msg(data.msg);
                            return false;
                        }
                        $("input[type='submit']").val('注册成功，正在跳转...');
                        location.href = '/login';
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        $("input[type='submit']").prop('disabled', false);
                        $("input[type='submit']").val('注册');
                        layer.alert('系统异常');
                    }
                });
                return false;
            });
        });
    </script>
</body>
</html>