<!DOCTYPE html>
<html class="desktop landscape">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Cache-Control" content="max-age=600">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <meta name="viewport" content="initial-scale=1, width=device-width, maximum-scale=1, user-scalable=no">
    <meta name="viewport" content="initial-scale=1.0,user-scalable=no,maximum-scale=1" media="(device-height: 568px)">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="full-screen" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <meta name="format-detection" content="address=no">
    <title>【${s!}】相关所有优惠券 - ${web.webname!}</title>
    <meta name="keywords" content="${s!}">
    <meta name="description" content="为您提供${s!}相关优惠券信息。">
    <link rel="stylesheet" type="text/css" href="/static/m/css/style_v3.css">
    <link rel="stylesheet" type="text/css" href="/static/m/css/jp.bag.css">
    <link rel="stylesheet" type="text/css" href="/static/m/css/alert.css">
    <link rel="stylesheet" type="text/css" href="/static/m/css/top.css">
    <link rel="stylesheet" type="text/css" href="/static/m/css/cn666plus.css">
    <link rel="stylesheet" type="text/css" href="/static/m/css/amazeui.css">
</head>
<body>
    <div class="main">
        <#include "common/app_other.ftl">
        <div class="app">
            <header id="head" class="head">
                <div class="fixtop cmspic.judacdn.com">
                    <div id="t-find"><a href="javascript:;" onclick="window.history.go(-1)" class="btn btn-left btn-back" title="返回上一页"></a></div>
                    <div id="t-index">搜索"${s!}"相关的商品</div>
                    <div id="classify" style="float:right"><a href="javascript:;" class="btn btn-left btn-type"></a></div></div>
            </header>
            <div id="search-box">
                <form id="search-form" action="/search" method="get" onsubmit="return Checkdate(this);">
                    <div class="box-search">
                        <input type="text" name="s" x-webkit-speech="" autocomplete="off" value="${s!}">
                        <a href="javascript:;" class="del"><img src="/static/m/images/del.png"></a>
                    </div>
                    <button id="search-submit" type="submit"><img src="/static/m/images/search.png"></button>
                </form>
            </div>

            <div class="next-nav3">
                <#include "common/sort.ftl">
            </div>
            <div id="goods">
                <#include "common/list_item.ftl">
            </div>

            <div class="loading" id="loading">
                <span>正在加载中，请稍后...</span>
                <input type="hidden" id="totalPage" value="${goodsPage!}"/>
                <input type="hidden" id="currPage" value="${curr!}"/>
                <input type="hidden" id="mplink" value="${mplink!}"/>
            </div>

            <#include "common/side_right.ftl">

            <#include "common/footer.ftl">
        </div>
        <#include "common/nav.ftl">
    </div>
    <script type="text/javascript" src="/static/plugins/layui/layui.js"></script>
    <script type="text/javascript">
        // alert(document.documentElement.clientWidth);
        layui.use(['layer'], function () {
            var layer = layui.layer;
            var $ = layui.$;

            var fwh = document.documentElement.clientHeight;
            // console.log('fwh', fwh);
            var wh = document.documentElement.scrollHeight;
            // console.log('wh', wh);
            var totalPage = $('#totalPage').val() || 1;
            var nextPage = 1;
            var html = '';
            window.onscroll = function() {
                var currPage = $('#currPage').val() || 1;
                var sh = window.scrollY;
                if (sh >= 50) {
                    $('#back_top').show();
                } else {
                    $('#back_top').hide();
                }
                // console.log('sh', sh);
                // console.log('fwh + sh:', fwh + sh);
                // console.log('wh - 120:', wh - 120);
                if (fwh + sh >= wh - 120) {
                    if (nextPage === (parseInt(currPage) + 1)) {
                        return false;
                    }
                    if (parseInt(currPage) >= parseInt(totalPage)) {
                        return false;
                    }
                    $('.loading').show();
                    nextPage = parseInt(currPage) + 1;
                    var url = $('#mplink').val() + nextPage;
                    $.ajax({
                        type: 'get',
                        url: url,
                        dataType: 'json',
                        success: function (res) {
                            $('.loading').hide();
                            if (res.code !== 0) {
                                layer.msg(res.msg);
                                return false;
                            }
                            // console.log(res.data);
                            $('#totalPage').val(res.data.totalPage);
                            $('#currPage').val(nextPage);
                            $.each(res.data.data, function(index, goods) {
                                html += '<li>';
                                html += '    <a class="goods-a" href="/cate' + goods.fqcat + '/' + goods.itemid + '.html" rel="nofollow" target="_self">';
                                html += '        <img class="lazy" src="' + goods.itempic + '" alt="' + goods.itemtitle + ',有' + goods.couponmoney + '元券">';
                                html += '    </a>';
                                html += '    <a href="/cate' + goods.fqcat + '/' + goods.itemid + '.html" target="_self">';
                                html += '        <h3>';
                                if (goods.shoptype === 'B') {
                                    html += '       <i class="zg-b"></i>';
                                }
                                if (goods.shoptype === 'C') {
                                    html += '       <i class="zg-c"></i>';
                                }
                                html += '            ' + goods.itemtitle + ',领券下单仅需' + goods.itemendprice + '元';
                                html += '        </h3>';
                                html += '        <div class="list-price buy">';
                                html += '            <span class="price-new"><i>券后价:￥</i>' + goods.itemendprice + '</span>';
                                html += '            <i class="del">￥' + goods.itemprice + '</i>';
                                html += '        </div>';
                                html += '        <div class="list-price buy">';
                                html += '            <span class="good-btna" style="font-size:12px">已售:' + goods.itemsale + '</span>';
                                html += '        </div>';
                                html += '    </a>';
                                html += '    <div class="lingquan">';
                                html += '        <a href="/cate' + goods.fqcat + '/' + goods.itemid + '.html" rel="nofollow" target="_self" class="coupon">';
                                html += '            <span><font color="#fcff00">优惠券</font><br>' + goods.couponmoney + '元</span><b></b>';
                                html += '        </a>';
                                html += '    </div>';
                                html += '</li>';
                            });
                            $('.goods-list').append(html);
                            wh = document.documentElement.scrollHeight;
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            layer.msg('系统异常');
                        }
                    });
                }
            }

            $('#classify').click(function() {
                var box = document.createElement('div');
                box.style.cssText = 'position:fixed;top:0;left:0;width:100%;height:100%;background-color:#000;opacity:0.3;z-index:100';
                box.onclick = function() {
                    $('.app-other').css({'visibility': 'hidden', 'left': '-70%'});
                    document.body.removeChild(box);
                }
                document.body.appendChild(box);
                $('.app-other').css({'visibility': 'visible', 'left': 0, 'height': fwh+20});
            });
        });
    </script>
</body>
</html>