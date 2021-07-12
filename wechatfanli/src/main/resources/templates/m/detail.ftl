<!DOCTYPE html>
<html class="desktop landscape">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Cache-Control" content="max-age=600">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <meta name="viewport" content="initial-scale=1, width=device-width, maximum-scale=1, user-scalable=no">
    <meta name="viewport" content="initial-scale=1.0,user-scalable=no,maximum-scale=1" media="(device-height: 568px)">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="full-screen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <meta name="format-detection" content="address=no">
    <title>${goods.itemtitle!}-${web.webname!}</title>
    <meta name="keywords" content="${goods.itemtitle!}">
    <meta name="description" content="${goods.itemtitle!},${goods.itemdesc!}">
    <link type="text/css" rel="stylesheet" href="/static/m/css/style_v3.css">
    <link type="text/css" rel="stylesheet" href="/static/m/css/jp.bag.css">
    <link type="text/css" rel="stylesheet" href="/static/m/css/alert.css">
    <link type="text/css" rel="stylesheet" href="/static/m/css/top.css">
    <link type="text/css" rel="stylesheet" href="/static/m/css/alert.css">
    <link type="text/css" rel="stylesheet" href="/static/m/css/global.css">
    <link type="text/css" rel="stylesheet" href="/static/m/css/amazeui.css">
    <link type="text/css" rel="stylesheet" href="/static/m/css/copytkl.css">
</head>
<body>
    <div class="main">
        <#include "common/app_other.ftl">
        <div class="app">
            <header class="head" id="head">
                <div class="fixtop">
                    <div id="t-find"><a class="btn btn-left btn-back" href="javascript:;" onclick="window.history.go(-1)" title="返回上一页"></a></div>
                    <div id="t-index">领${goods.couponmoney!}元券，券后${goods.itemendprice!}元</div>
                    <div id="classify" style="float:right"><a href="javascript:;" class="btn btn-left btn-type"></a></div>
                </div>
            </header>
            <div id="item">
                <div class="item-good">
                    <div class="img_show">
                        <ul id="target" class="clear">
                            <li><img src="${goods.itempic!}"></li>
                        </ul>
                    </div>
                    <div class="goodsname">
                        <#if goods.shoptype == "B">
                            <span style="color:#ffffff;border:1px solid #c20000;padding:-1px;margin-right:5px;padding-top:0;border-radius:3px;background:#c20000;font-size:12px;">天猫</span>
                        </#if>
                        <#if goods.shoptype == "C">
                            <span style="color:#ffffff;border:1px solid #c20000;padding:-1px;margin-right:5px;padding-top:0;border-radius:3px;background:#c20000;font-size:12px;">淘宝</span>
                        </#if>
                        <span style="color:#ffffff;border:1px solid #c20000;padding:-1px;margin-right:5px;padding-top:0;border-radius:3px;background:#c20000;font-size:12px;">包邮</span>${goods.itemtitle!}
                    </div>
                    <div class="goodsprice">
                        <span class="trueprice">券后价￥${goods.itemendprice!}</span>
                        <span style="font-size:12px;color:#555555;text-decoration:line-through;padding-right:10px">原价 ￥${goods.itemprice!}</span>
                    </div>
                    <div class="recommend-wrapper">
                        <div class="text" style="border-bottom:1px solid #f5f5f5;">
                            <h1 style="color:#444;text-align:left;font-size:14px;line-height:20px;font-family: Sans-Serif;">先领券再下单，此商品可省&nbsp;<font color="#fc6f03">${goods.couponmoney!}</font>&nbsp;元</h1>
                        </div>
                    </div>
                    <div class="better_change">
                        <h3>卖点推荐</h3>
                        <ul class="better_show clear">${goods.itemdesc!}</ul>
                    </div>
                    <div class="better_change">
                        <h3>精挑细选</h3>
                        <ul class="better_show clear">
                            <li>
                                <div class="better_info"><i class="xp"></i><span>新品特价</span></div>
                            </li>
                            <li>
                                <div class="better_info"><i class="xs"></i><span>限时特卖</span></div>
                            </li>
                            <li>
                                <div class="better_info"><i class="cx"></i><span>诚信品牌</span></div>
                            </li>
                            <li>
                                <div class="better_info"><i class="tj"></i><span>人气推荐</span></div>
                            </li>
                            <li class="last">
                                <div class="better_info"><i class="by"></i><span>全国包邮</span></div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="bady-part">
                <div id="bady-tab" class="bady-tab clear">
                    <ul>
                        <li style="width: 50%;text-align:center;" class="active">同类热门推荐</li>
                        <li style="width: 50%;text-align:center;" id="get_desc" data-type="${goods.shoptype!}" data-itemid="${goods.itemid!}">查看图文详情</li>
                    </ul>
                </div>
            </div>
            <div class="tab1">
                <div class="normal item-recommend clear">
                    <ul class="goods-list clear" id="goods_block">
                        <#list guessGoodsList as g>
                        <li>
                            <a class="goods-a" href="/cate${g.fqcat!}/${g.itemid!}.html" target="_self">
                                <img class="lazy" src="${g.itempic!}" style="display: block;">
                            </a>
                            <a href="/cate${g.fqcat!}/${g.itemid!}.html" target="_self">
                                <h3>${g.itemtitle!}</h3>
                                <div class="list-price buy">
                                    <span class="price-new"><i>￥</i>${g.itemendprice!}</span>
                                    <span class="qhj">券后价</span>
                                    <#if g.shoptype == "B">
                                        <span class="good-btn">天猫</span>
                                    </#if>
                                    <#if g.shoptype == "C">
                                        <span class="good-btn">淘宝</span>
                                    </#if>
                                </div>
                            </a>
                            <div class="lingquan">
                                <a href="/cate${g.fqcat!}/${g.itemid!}.html" target="_self" class="coupon">
                                    <span>优惠券<br>${goods.couponmoney!}元</span><b></b>
                                </a>
                            </div>
                        </li>
                        </#list>
                    </ul>
                </div>
            </div>
            <div class="tab2" style="display:none"></div>

            <!--底部tab-->
            <div class="nbmenu">
                <div class="nbnav nb-btn1">
                    <a href="/"><p class="icon"></p><p class="text">首页</p></a>
                </div>
                <div class="nbnav nb-btn2" id="fxtkl" type="1">
                    <a href="javascript:;"><p class="icon"></p><p class="text">文案</p></a>
                </div>
                <a rel="nofollow" style="color: #ffffff;font-size: 14px;font-weight:normal;letter-spacing:0;" href="/su/cate${goods.fqcat!}/${goods.itemid!}.html">
                    <div class="nbnav2 nb-btn3">直接领券购买</div>
                </a>
                <div class="nbnav2 nb-btn4" id="wxtkl" type="0">
                    <a href="javascript:;" class="goodsget" style="color: #ffffff;font-size: 14px;font-weight:normal;letter-spacing:0;">淘口令领券</a>
                </div>
            </div>

            <#--tkl-->
            <div class="tkl-div" id="tkl-div">
                <div class="tkl-div-header">
                    <p>复制淘口令</p>
                    <i>X</i>
                </div>
                <div class="tkl-div-body">
                    <div class="tkl-div-body-top">
                        正在生成淘口令...
                    </div>
                    <div class="tkl-div-body-middle">
                        <p>可领￥${goods.couponmoney!}劵</p>
                        <p>1、手机无【手机淘宝】者，可选择浏览器购买方式哦！</p>
                        <p>2、请尽快领券并下单，避免优惠券抢完、失效或涨价！</p>
                    </div>
                    <div class="tkl-div-body-bottom">
                        <button id="copytkl" data-clipboard-action="copy" data-clipboard-target=".tkl-div-body-top">一键复制</button>
                    </div>
                </div>
            </div>

            <#include "common/side_right.ftl">

            <#include "common/footer.ftl">
        </div>
    </div>
    <script type="text/javascript" src="/static/plugins/layui/layui.js"></script>
    <script type="text/javascript" src="/static/plugins/clipboard.js"></script>
    <script type="text/javascript">
    layui.use(['layer'], function () {
        var layer = layui.layer;
        var $ = layui.$;

        $('#bady-tab li').on('click', function () {
            $(this).addClass('active').siblings().removeClass('active');
            $(".tab1,.tab2").hide();
            $(".tab" + ($(this).index() + 1)).show();
        });

        $('#get_desc').click(function() {
            var getfan =layer.load();
            var itemid = $(this).attr('data-itemid');
            // https://h5api.m.taobao.com/h5/mtop.taobao.detail.getdesc/6.0/?data={"id":"601193092292","type":"1","f":""}
            $.ajax({
                url: "https://h5api.m.taobao.com/h5/mtop.taobao.detail.getdesc/6.0/?data=%7B%22id%22%3A%22" + itemid + "%22%2C%22type%22%3A%221%22%2C%22f%22%3A%22%22%7D",
                timeout: 1000,
                tryCount: 0,
                dataType: 'jsonp',
                jsonp: 'callback',
                success: function (result) {
                    layer.close(getfan);
                    if (result.ret[0] === "SUCCESS::调用成功") {
                        var img = result.data.pcDescContent;
                        var image = [];
                        var imgReg = /<img.*?(?:>|\/>)/gi;
                        var srcReg = /src=[\'\"]?([^\'\"]*)[\'\"]?/i;
                        var arr = img.match(imgReg);
                        for (var i = 0; i < arr.length; i++) {
                            var src = arr[i].match(srcReg);
                            if (src[1]) {
                                if (src[1].indexOf("spaceball") !== -1) {
                                    image[i] = ""
                                } else {
                                    image[i] = "<img src='" + src[1] + "' style='width:100%;max-width:100%'>"
                                }
                            }
                        }
                        $('.tab2').html(image);
                        $('.tab1').hide();
                        $(".tab2").fadeIn();
                    }
                },
                error: function (xhr, textStatus, errorThrown) {
                    this.tryCount++;
                    //try again
                    $.ajax(this);
                    return false;
                }
            });
        });

        $('.tkl-div .tkl-div-header i').click(function() {
            $('.tkl-div').hide();
        });

        $('#fxtkl, #wxtkl').click(function() {
            openTklDialog('tkl-div');
            fillTkl($(this).attr('type'));
        });

        function fillTkl(type) {
            $('.tkl-div-body-top').html('正在生成淘口令...');
            $.ajax({
                type: 'get',
                url: '/getTkl?itemid=${goods.itemid!}&type=' + type,
                dataType: 'json',
                success: function (res) {
                    if (res.code !== 0) {
                        layer.msg(res.msg);
                        return false;
                    }
                    $('.tkl-div-body-top').html(res.data);
                    $("#copytkl").css("background-color", "#f54d23");
                    $('#copytkl').text("一键复制");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    layer.msg('系统异常');
                }
            });
        }

        function openTklDialog(id) {
            var box = document.getElementById(id);
            var w = document.documentElement.clientWidth;
            var h = document.documentElement.clientHeight;
            // var width = box.offsetWidth;
            var width = w - 80;
            // var height = box.offsetHeight;
            var height = 300;
            var left = (w - width) / 2;
            var top = (h - height) / 2;
            box.style.position = 'fixed';
            box.style.left = left + 'px';
            box.style.top = top + 'px';
            box.style.display = 'block';
            box.style.width = width + 'px';
        }

        window.onscroll = function() {
            var h = window.scrollY;
            // console.log(h);
            if (h >= 50) {
                $('#back_top').show();
            } else {
                $('#back_top').hide();
            }
        }

        var clipandroid = new Clipboard('#copytkl');
        clipandroid.on('success', function (e) {
            $("#copytkl").css("background-color", "#039024");
            $('#copytkl').text("复制成功");
            e.clearSelection();
        });
        clipandroid.on('error', function (e) {
            $("#copytkl").css("background-color", "#f54d23");
            $('#copytkl').text("复制失败，请手动复制");
        });
    });
</script>
</body>
</html>