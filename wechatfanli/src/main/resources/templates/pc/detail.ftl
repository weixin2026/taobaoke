<!DOCTYPE html>
<html class="jp-pc w1200 desktop landscape">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Cache-Control" content="max-age=600">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <title>${goods.itemtitle!}-${web.webname!}</title>
    <meta name="keywords" content="${goods.itemtitle!}">
    <meta name="description" content="${goods.itemtitle!},${goods.itemdesc!}">
    <!--公共cssjs-->
    <#include "common/jscss.ftl">
    <!--私有cssjs-->
    <link type="text/css" rel="stylesheet" href="/static/pc/css/view.css">
    <#--<script type="text/javascript" src="/static/js/end.js"></script>-->
</head>
<body>
    <#include "common/header.ftl">
    <div class="main w1200">
        <div class="place-explain">
            您的位置：<a target="_blank" href="/static">${web.webname!}</a>
            &nbsp;&gt;&nbsp;
            <a target="_blank" href="/cate${goods.fqcat!}" title="${cate.name!}" >${cate.name!}</a>
            &nbsp;&gt;&nbsp;
            <a class="bady-xx-seo" href="/cate${goods.fqcat!}/${goods.itemid!}.html">${goods.itemtitle!}</a>
            <div style="float:right">
                <#--share-->
            </div>
        </div>
        <div class="w1200">
            <div class="container fl">
                <div class="product clear">
                    <div class="product-pic fl">
                        <a href="/cate${goods.fqcat!}/${goods.itemid!}.html" target="_blank">
                            <img src="${goods.itempic!}" alt="${goods.itemtitle!}">
                        </a>
                    </div>
                    <div class="product-info fl">
                        <h3><a href="/cate${goods.fqcat!}/${goods.itemid!}.html" target="_blank" >${goods.itemtitle!}</a></h3>
                        <p class="body_price clear">
                            <span class="price_f fl buy">券后价<em class="price-ico">￥</em><em class="price">${goods.itemendprice!}&nbsp;</em></span>
                            <a href="/su/cate${goods.fqcat!}/${goods.itemid!}.html" target="_blank" class="quanurl" style="zoom: 0.8;">领券购买立减<em>15</em>元</a>
                        </p>
                        <span style="color:#3CB371;line-height:20px;padding-bottom:20px">${goods.itemdesc!}</span>
                        <p class="old_price clear">
                            原价：<em class="price">${goods.itemprice!}元</em>${goods.discount!}折
                            <span>距离结束：</span>
                            <span class="buy_time" id="end_date_0" data-time="1576425599">
                                <em id="d">0</em>天
                                <em id="h">02</em>时
                                <em id="m">05</em>分
                                <em id="s">46</em>秒
                            </span>
                        </p>
                        <p class="btn">
                            <a href="/cate${goods.fqcat!}/${goods.itemid!}.html" target="_blank"  class="go_btn fl buy">
                                <span style="font-family:'微软雅黑',serif;font-size:30px;">领券购买</span>
                            </a>
                        </p>
                        <div class="other_info clear">
                            <div class="keyword fl">
                                <a href="/" target="_blank"><span>坚果</span></a>
                                <a href="/" target="_blank"><span>坚果</span></a>
                                <a href="/" target="_blank"><span>坚果</span></a>
                            </div>
                            <div class="two-dime-box two-item-box">
                                <div class="dimension goodsinfor" style="display:block;">
                                    <p style="line-height:18px;"> 手机淘宝扫码领券</p>
                                    <center>
                                        <div id="tbcode"><img src="/static/pc/images/img" width="110"></div>
                                    </center>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="product-comment">
                    <a name="desc" id="desc" href="javascript:;">&nbsp;</a>
                    <div class="bady-tab bady-tab01">
                        <ul>
                            <li style="border-right: none">
                                <a href="#desc" class="badyactive"><span id="tabtxt">商品图文详情（加载完毕，请您查阅）</span></a>
                                <div class="bady-line-top"></div>
                            </li>
                        </ul>
                    </div>

                    <#if (taobaoImageList?? && taobaoImageList?size>0) >
                        <div style="display: block;" class="information comment jp1">
                            <div class="descimg">
                                <#list taobaoImageList as img>
                                <img src="${img!}" alt="${goods.itemtitle!}" style="width:100%;max-width:100%">
                                </#list>
                            </div>
                        </div>
                    <#else>
                        <div>
                        <#if guessGoodsList??>
                        <#list guessGoodsList as g>
                            猜你喜欢每行3个展示商品
                        </#list>
                        </#if>
                        </div>
                    </#if>
                </div>
                <div class="gobuy fr buy">
                    <p class="price fl">
                        <em class="yang">￥</em><span class="jd-current">${goods.itemendprice!}</span>/包邮
                    </p>
                    <a href="/cate${goods.fqcat!}/${goods.itemid!}.html" target="_blank"  class="btn fl"><span style="font-family:微软雅黑;font-size:20px;">领券购买</span></a>
                </div>

                <div>
                     <#if tags??>
                            <#list tags as tag>
                                 <a href="${web.domainname!}${tag.link!}" >${tag.name!}</a>
                            </#list>
                     </#if>
                </div>

            </div>
            <div class="hot_box fr">
                <div class="hot_goods">
                    <h3>
                        <div class="line"></div>
                        <div class="line-txt">HOT同类热卖</div>
                    </h3>
                    <ul>
                      <#if hotGoodsList??>
                        <#list hotGoodsList as g>
                        <li>
                            <a href="/cate${goods.fqcat!}/${g.itemid!}.html">
                                <img class="lazy" src="${g.itempic!}" alt="${g.itemtitle!}" style="display: inline;">
                                <div class="hot_price">
                                    <em class="hot_num"><em class="hot_yang">券后￥</em>${g.itemendprice!}</em>&nbsp;<em class="hot_num"><em class="hot_yang">原价￥</em><s>${g.itemprice!}</s></em>&nbsp;<em class="hot_num"><em class="hot_yang">券</em>${g.couponmoney!}<em class="hot_yang">元</em></em>
                                </div>
                            </a>
                        </li>
                        </#list>
                      </#if>
                    </ul>
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <#include "common/footer.ftl">
</body>
</html>