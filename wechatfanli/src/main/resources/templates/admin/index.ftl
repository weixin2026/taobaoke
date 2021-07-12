<!doctype html>
<html class="x-admin-sm">
    <head>
        <title>CMS管理系统</title>
        <#include "/admin/common/common.ftl">
        <link rel="stylesheet" href="/static/xadmin/css/theme5.css">
        <script>
            // 是否开启刷新记忆tab功能
            var is_remember = false;
        </script>
    </head>
    <body class="index">
        <!-- 顶部开始 -->
        <div class="container">
            <div class="logo">
                <a href="/" target="_blank" >CMS管理系统</a>
            </div>
            <div class="left_open">
                <a><i title="展开左侧栏" class="iconfont">&#xe699;</i></a>
            </div>
            <ul class="layui-nav right" lay-filter="">
                <li class="layui-nav-item to-index">
                    <a href="/"  target="_blank">前台网站</a>
                </li>
            
                <li class="layui-nav-item">
                    <a href="javascript:;">${(user.nickname)!}</a>
                    <dl class="layui-nav-child">
                        <dd><a onclick="xadmin.open('个人信息','/cms/sysUser/profile/dispatch', 500, 400)">个人信息</a></dd>
                        <dd><a onclick="xadmin.open('修改密码','/cms/sysUser/pass/dispatch', 500, 400)">修改密码</a></dd>
                        <dd><a href="/cms/logout">退出系统</a></dd>
                    </dl>
                </li>
                 
                
                 
            </ul>
        </div>
        <!-- 顶部结束 -->
        <!-- 中部开始 -->
        <!-- 左侧菜单开始 -->
        <div class="left-nav">
            <div id="side-nav">
                <ul id="nav">
                        <li>
                            <a href="javascript:;">
                                <i class="iconfont left-nav-li" lay-tips="这是菜单">&#xe726;</i>
                                <cite>系统管理</cite>
                                <i class="iconfont nav_right">&#xe697;</i>
                            </a>
                            <ul class="sub-menu" style="display: block;">
                                 
                                <li>
                                    <a onclick="xadmin.open('CMS网站设置','/cms/website/toedit', 700, 580)">
                                        <i class="iconfont">&#xe6a7;</i>
                                        <cite>CMS网站设置</cite>
                                    </a>
                                </li>
                                <li>
                                    <a onclick="xadmin.open('系统参数设置','/cms/system/toedit',700,500)">
                                        <i class="iconfont">&#xe6a7;</i>
                                        <cite>系统参数设置</cite>
                                    </a>
                                </li>
                                
                                <li>
                                    <a onclick="xadmin.add_tab('系统用户管理','/cms/sysUser/list/dispatch')">
                                        <i class="iconfont">&#xe6a7;</i>
                                        <cite>系统用户管理</cite>
                                    </a>
                                </li>
                                
                                <li>
                                    <a onclick="xadmin.add_tab('超级省钱活动','/cms/savemoney/list/dispatch')">
                                        <i class="iconfont">&#xe6a7;</i>
                                        <cite>超级省钱活动</cite>
                                    </a>
                                </li>
                                
                                <li>
                                    <a onclick="xadmin.add_tab('返利红包活动','/cms/redenvelope/list/dispatch')">
                                        <i class="iconfont">&#xe6a7;</i>
                                        <cite>返利红包活动</cite>
                                    </a>
                                </li>
                                
                                
                                
                            </ul>
                        </li>
                         
                </ul>
            </div>
        </div>
        <!-- <div class="x-slide_left"></div> -->
        <!-- 左侧菜单结束 -->
        <!-- 右侧主体开始 -->
        <div class="page-content">
            <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
                <ul class="layui-tab-title">
                    <li class="home">
                        <i class="layui-icon">&#xe68e;</i>我的桌面</li></ul>
                <div class="layui-unselect layui-form-select layui-form-selected" id="tab_right">
                    <dl>
                        <dd data-type="this">关闭当前</dd>
                        <dd data-type="other">关闭其它</dd>
                        <dd data-type="all">关闭全部</dd></dl>
                </div>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        <iframe src='./welcome.html' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
                    </div>
                </div>
                <div id="tab_show"></div>
            </div>
        </div>
        <div class="page-content-bg"></div>
        <style id="theme_style"></style>
        <!-- 右侧主体结束 -->
        <!-- 中部结束 -->
    </body>
</html>
