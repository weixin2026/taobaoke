<!DOCTYPE html>
<html class="x-admin-sm">
    <head>
        <title>welcome</title>
        <#include "/admin/common/common.ftl">
    </head>
    <body>
        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-body ">
                            <blockquote class="layui-elem-quote">欢迎管理员：
                                <span class="x-red">${(user.nickName)!}</span>！当前时间:
                                <span id="tm">
                                    <script>document.write(new Date().toLocaleString())</script>
                                </span>
                            </blockquote>
                        </div>
                    </div>
                </div>
                <div class="layui-col-md12">
                    <ul>
                        <li class="layui-timeline-item">
                            <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                            <div class="layui-timeline-content layui-text">
                                <h3 class="layui-timeline-title">未完待续...</h3>
                                <p>
                                    <br><em>无论它能走多远，抑或如何支撑？至少我曾倾注全心，无怨无悔 <i class="layui-icon"></i></em>
                                </p>
                            </div>
                        </li>


                        <li class="layui-timeline-item">
                            <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                            <div class="layui-timeline-content layui-text">
                                <h3 class="layui-timeline-title">2020年3月15日</h3>
                                <p>
                                    <br>增加普通分佣方案添加、修改、删除
                                    <br>增加订单跟踪、订单分佣（定向比例 > 普通分佣方案）、订单自动绑定、发送订单号绑定
                                    <br>增加订单列表、订单详情查看、修改绑定人
                                    <br>增加用户管理、用户详情查看、修改订单后六位、修改余额、用户标签、用户定向比例
                                    <br>增加欢迎页面的更新日志
                                    <br>增加提现列表、查看用户详情、删除
                                    <br>增加用户关注公众号后回复话术
                                <br>支持多公众号、多联盟（即授权多个淘宝联盟可以配置不同的公众号）配置，目前没有限制公众号数量。
                                </p>
                            </div>
                        </li>
                        
                    </ul>
                </div>
                <#--<div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">数据统计</div>
                        <div class="layui-card-body ">
                            <ul class="layui-row layui-col-space10 layui-this x-admin-carousel x-admin-backlog">
                                <li class="layui-col-md2 layui-col-xs6">
                                    <a href="javascript:;" class="x-admin-backlog-body">
                                        <h3>公众号数</h3>
                                        <p>
                                            <cite>66</cite></p>
                                    </a>
                                </li>
                                <li class="layui-col-md2 layui-col-xs6">
                                    <a href="javascript:;" class="x-admin-backlog-body">
                                        <h3>会员数</h3>
                                        <p>
                                            <cite>12</cite></p>
                                    </a>
                                </li>
                                <li class="layui-col-md2 layui-col-xs6">
                                    <a href="javascript:;" class="x-admin-backlog-body">
                                        <h3>回复数</h3>
                                        <p>
                                            <cite>99</cite></p>
                                    </a>
                                </li>
                                <li class="layui-col-md2 layui-col-xs6">
                                    <a href="javascript:;" class="x-admin-backlog-body">
                                        <h3>商品数</h3>
                                        <p>
                                            <cite>67</cite></p>
                                    </a>
                                </li>
                                <li class="layui-col-md2 layui-col-xs6">
                                    <a href="javascript:;" class="x-admin-backlog-body">
                                        <h3>文章数</h3>
                                        <p>
                                            <cite>67</cite></p>
                                    </a>
                                </li>
                                <li class="layui-col-md2 layui-col-xs6 ">
                                    <a href="javascript:;" class="x-admin-backlog-body">
                                        <h3>文章数</h3>
                                        <p>
                                            <cite>6766</cite></p>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="layui-col-sm6 layui-col-md3">
                    <div class="layui-card">
                        <div class="layui-card-header">下载
                            <span class="layui-badge layui-bg-cyan layuiadmin-badge">月</span></div>
                        <div class="layui-card-body  ">
                            <p class="layuiadmin-big-font">33,555</p>
                            <p>新下载
                                <span class="layuiadmin-span-color">10%
                                    <i class="layui-inline layui-icon layui-icon-face-smile-b"></i></span>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="layui-col-sm6 layui-col-md3">
                    <div class="layui-card">
                        <div class="layui-card-header">下载
                            <span class="layui-badge layui-bg-cyan layuiadmin-badge">月</span></div>
                        <div class="layui-card-body ">
                            <p class="layuiadmin-big-font">33,555</p>
                            <p>新下载
                                <span class="layuiadmin-span-color">10%
                                    <i class="layui-inline layui-icon layui-icon-face-smile-b"></i></span>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="layui-col-sm6 layui-col-md3">
                    <div class="layui-card">
                        <div class="layui-card-header">下载
                            <span class="layui-badge layui-bg-cyan layuiadmin-badge">月</span></div>
                        <div class="layui-card-body ">
                            <p class="layuiadmin-big-font">33,555</p>
                            <p>新下载
                                <span class="layuiadmin-span-color">10%
                                    <i class="layui-inline layui-icon layui-icon-face-smile-b"></i></span>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="layui-col-sm6 layui-col-md3">
                    <div class="layui-card">
                        <div class="layui-card-header">下载
                            <span class="layui-badge layui-bg-cyan layuiadmin-badge">月</span></div>
                        <div class="layui-card-body ">
                            <p class="layuiadmin-big-font">33,555</p>
                            <p>新下载
                                <span class="layuiadmin-span-color">10%
                                    <i class="layui-inline layui-icon layui-icon-face-smile-b"></i></span>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">系统信息</div>
                        <div class="layui-card-body ">
                            <table class="layui-table">
                                <tbody>
                                    <tr>
                                        <th>公众号动态配置版</th>
                                        <td>1.0.0</td></tr>
                                    <tr>
                                        <th>服务器地址</th>
                                        <td>IP地址</td></tr>
                                    <tr>
                                        <th>操作系统</th>
                                        <td>Windows</td></tr>
                                    <tr>
                                        <th>运行环境</th>
                                        <td>Java</td></tr>
                                    <tr>
                                        <th>JDK版本</th>
                                        <td>1.8</td></tr>
                                    <tr>
                                        <th>运行方式</th>
                                        <td>JAR</td></tr>
                                    <tr>
                                        <th>MYSQL版本</th>
                                        <td>5.7.23</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="layui-col-md12">
                    <div class="layui-card">
                        <div class="layui-card-header">开发团队</div>
                        <div class="layui-card-body ">
                            <table class="layui-table">
                                <tbody>
                                    <tr>
                                        <th>版权所有</th>
                                        <td>xiaoxx(xiaoxx)
                                            <a href="#" target="_blank">访问官网</a></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <style id="welcome_style"></style>
                <div class="layui-col-md12">
                    <blockquote class="layui-elem-quote layui-quote-nm">感谢layui,百度Echarts,jquery,本系统由x-admin提供技术支持。</blockquote>
                </div>-->
            </div>
        </div>
        <script type="text/javascript">
            layui.use(['layer'], function () {
                var $ = layui.$;
                setInterval(function() {
                    $('#tm').text(new Date().toLocaleString());
                }, 1000);
            });
        </script>
    </body>
</html>
