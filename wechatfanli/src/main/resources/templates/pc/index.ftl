<!DOCTYPE html>
<html class="jp-pc w1200 desktop landscape">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <meta http-equiv="Cache-Control" content="max-age=600">
    <meta property="og:image" content="/data/upload/site/gzlg.png">
    <title>${web.title!} - ${web.webname!}</title>
    <meta name="keywords" content="${web.keywords!}">
    <meta name="description"  content="${web.description!}">
    <!--公共cssjs-->
    <#include "common/jscss.ftl">
    <!--私有cssjs-->
    <link type="text/css" rel="stylesheet" href="/static/pc/css/pager.css">
    <script type="text/javascript" src="/static/pc/js/cate.js"></script>
</head>
<body>
    <#include "common/header.ftl">
    <div class="top_bar">
        <ul id="banner_list" class="banner">
            <@banner_list status="1">
            <#list bannerList as banner>
            <li style="background-image: url(${banner.img!}); z-index: 1; opacity: 1; background-position: 50% 50%; background-repeat: no-repeat no-repeat;">
                <a rel="nofollow" target="_blank" title="${banner.title!}" href="${banner.url!}" class="pic center"></a>
            </li>
            </#list>
            </@banner_list>
        </ul>
    </div>
    <div class="top_wrap">
        <div class="top_box">
            <div class="banner_l">
                <dl>
                    <@category_list status="1">
                    <#list cateList as cate>
                    <dd>
                        <a href="/cate${cate.fqcat!}/" title="${cate.name!}">
                            <i class="ct-icon ${cate.pcicon!}"></i>
                            ${cate.name!}
                            <#if cate_index % 2 == 0>
                            <em class="ct-line"></em>
                            </#if>
                        </a>
                    </dd>
                    </#list>
                    </@category_list>
                </dl>
            </div>
            <div class="banner_r" style="background:#f7f7f7;box-shadow:none">
                <dl>
                    <@tofu_list status="1">
                    <#list tofuList as tofu>
                    <dd><a href="${tofu.url!}" target="_blank" title="${tofu.title!}"><img src="${tofu.img!}" alt="${tofu.title!}" style="width:295px;height:120px;"></a></dd>
                    </#list>
                    </@tofu_list>
                </dl>
            </div>
        </div>
    </div>
    <div class="main w1200">
        <div style="padding:10px;margin-top:20px;background-color:#01DFD7;">
            <span style="font-size: 16px;"><b>淘宝天猫优惠券持续更新中，购物先领券，真的特别省！</b></span>
            <a href="/index/t/starttime/desc/1.html" style="float:right;font-size:14px;color:#FA8258;padding-left:20px;" title="最新上架淘宝优惠券降序" rel="nofollow">最新</a>
            <a href="/index/t/itemsale/desc/1.html" style="float:right;font-size:14px;color:#DF0101;padding-left:20px;" title="已领淘宝优惠券数量降序" rel="nofollow">销量</a>
            <a href="/index/t/itemprice/asc/1.html" style="float:right;font-size:14px;color:#FA8258;padding-left:20px;" title="券后价格升序" rel="nofollow">价格</a>
            <a href="/index/t/discount/desc/1.html" style="float:right;font-size:14px;color:#FA8258;padding-left:20px;" title="折扣力度降序" rel="nofollow">折扣</a>
            <a href="/index/t/couponmoney/desc/1.html" style="float:right;font-size:14px;color:#DF0101;padding-left:20px;" title="淘宝优惠券面值降序" rel="nofollow">优惠券</a>
        </div>
        <div class="line-cate-nav-location hidn">
            <div class="line-cate-nav-wrapper">
                <ul class="line-cate-nav">
                    <li><a href="/static" class="active">全部分类</a></li>
                    <@category_list status="1">
                    <#list cateList as cate>
                        <li><a href="/cate${cate.fqcat!}" title="${cate.name!}">${cate.name!}</a></li>
                    </#list>
                    </@category_list>
                    <li style="padding-left:50px;font-size:12px;">排序：</li>
                    <li style="padding-left:5px;"><a style="font-size:12px;" href="/index/t/starttime/desc/1.html" title="按照更新最近的优惠券排序">最新</a></li>
                    <li style="padding-left:5px;"><a style="font-size:12px;" href="/index/t/itemsale/desc/1.html" title="按照领优惠券下单量排序">销量</a></li>
                    <li style="padding-left:5px;"><a style="font-size:12px;" href="/index/t/itemprice/asc/1.html" title="按照使用优惠券后价格排序有低到高">价格</a></li>
                    <li style="padding-left:5px;"><a style="font-size:12px;" href="/index/t/discount/desc/1.html" title="按照优惠券折扣力度排序">折扣</a></li>
                    <li style="padding-left:5px;"><a style="font-size:12px;" href="/index/t/couponmoney/desc/1.html" title="按照优惠券面值排序有大到小">优惠券</a></li>
                </ul>
            </div>
        </div>
        <div class="main w1200">
            <div class="main pr mt25 clear">
                <#include "common/list_item.ftl">
            </div>
            <div class="page" id="pager"></div>
        </div>
    </div>
    <#include "common/footer.ftl">
    <script type="text/javascript">
    layui.use(['laypage'], function () {
        var laypage = layui.laypage;
        laypage.render({
            elem: 'pager'
            , count: ${goodsPage!}
            , curr: ${curr!}
            , theme: '#27BCB5'
            , jump: function (obj, first) {
                if (!first) {
                    location.href = '${plink!}' + obj.curr + '.html';
                }
            }
        });
    });
</script>
</body>
</html>