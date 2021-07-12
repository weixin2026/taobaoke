<div id="afp" class="totop-tips">
    <p>
        请按键盘 <strong>CTRL + D</strong> 把高额优惠券网放入收藏夹，折扣信息一手掌握！
        <label id="nlraf" onclick="CloseNLRAF(true)" for="check_nlraf">
            <input style="display:none;" type="checkbox" id="check_nlraf"><a href="javascript:void(0)">不再提醒</a>
        </label>
        <a id="cafp" href="javascript:void(0)" onclick="CloseNLRAF(false)"></a>
        <a id="cafp" href="javascript:void(0)" onclick="CloseNLRAF(false)"><span class="closet"><em>x</em>关闭</span></a>
    </p>
</div>
<div id="toolbar">
    <div class="bar-con">
        <ul class="topNav fl">
            <li><a href="/">淘宝优惠券</a></li>
            <li><a href="/" target="_blank"><em class="icon-normal icon-phone"></em>淘宝优惠券手机端</a></li>
        </ul>
        <div class="right-show fr">
            <div class="union-login">　|</div>
            <!--
            <div class="login-show">
            <a href="/user/login.html" rel="nofollow">登录</a><a href="/user/index.html" rel="nofollow">用户中心</a>
            <a href="/user/register.html" rel="nofollow">免费注册</a>&#12288;|
            </div>
            -->
            <div class="other-show">
                <a href="tencent://message/?uin=1850644533&amp;Site=/&amp;Menu=yes" rel="nofollow" target="_blank">在线客服</a>
            </div>
        </div>
    </div>
</div>
<div class="header">
    <div class="area">
        <div class="logo logo1">
            <div class="fl">
                <a class="juan-logo fl" href="/" title="高额优惠券网">
                    <img src="/static/pc/images/59ef665a72701.jpg" alt="高额优惠券网">
                </a>
            </div>
        </div>
        <div class="protection" style="background: url(/static/pc/images/5be8e6ae5787b.png) no-repeat;"></div>
        <div class="search">
            <form action="/search" method="get" id="search" onsubmit="return check(this);">
                <input type="text" name="s" style="color:gray" autocomplete="off"
                       onblur="this.value==''?this.value=this.title:null"
                       onfocus="if(this.value=='输入标题或关键字查优惠券'||this.value==''){this.value=''};this.style.color='black';"
                       title="输入标题或关键字查优惠券" value="输入标题或关键字查优惠券" class="txt">
                <button type="submit" class="cur" id="waitMe_ex">搜索优惠券</button>
            </form>
        </div>
    </div>
    <div class="mainNav">
        <div class="nav">
            <ul class="navigation fl">
                <@navigation_list status="1">
                <#list navList as nav>
                    <li><a href="${nav.url!}">${nav.name!}</a></li>
                </#list>
                </@navigation_list>
            </ul>
        </div>
    </div>
</div>