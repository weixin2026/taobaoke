<!doctype html>
<html  class="x-admin-sm">
<head>
	<title>CMS管理系统</title>
	<#include "/admin/common/common.ftl">
    <link rel="stylesheet" href="/static/xadmin/css/login.css">
</head>
<body class="login-bg">

    <div class="login layui-anim layui-anim-up">
        <div class="message">CMS管理系统</div>
        <div id="darkbannerwrap"></div>

        <form method="post" class="layui-form" >
            <input name="username" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" value="admin">
            <hr class="hr15">
            <input name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input" value="admin">
            <hr class="hr15">
            <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
            <hr class="hr20" >
           <!-- <a href="/register" style="text-decoration:underline;color:#2196f3">注册账号</a> -->
        </form>
    </div>

    <script type="text/javascript">
       
        if(window.parent != window){
	         window.parent.location.reload(true);
	    }
    
        layui.use(['form', 'layer'], function () {

            var form = layui.form;
            var layer = layui.layer;
            var $ = layui.$;

            form.on('submit(login)', function (data) {
                $("input[type='submit']").prop('disabled', true);
                $("input[type='submit']").val('登录中...');
                $.ajax({
                    type: 'post',
                    url: '/cms/login',
                    data: data.field,
                    dataType: 'json',
                    success: function (data) {
                        if (data.code !== 0) {
                            $("input[type='submit']").prop('disabled', false);
                            $("input[type='submit']").val('登录');
                            layer.msg(data.msg);
                            return false;
                        }
                        $("input[type='submit']").val('登录成功，正在跳转...');
                        location.href = '/cms/index';
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        $("input[type='submit']").prop('disabled', false);
                        $("input[type='submit']").val('登录');
                        layer.alert('系统异常');
                    }
                });
                return false;
            });
        });
    </script>
</body>
</html>