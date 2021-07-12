<!DOCTYPE html>
<html class="jp-pc w1200 desktop landscape">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Cache-Control" content="max-age=600">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <title>${cate.title!}-${web.webname!}</title>
    <meta name="keywords" content="${cate.keywords!}">
    <meta name="description" content="${cate.description!}">
     <!--公共cssjs-->
    <#include "common/jscss.ftl">
    <!--私有cssjs-->
    <link type="text/css" rel="stylesheet" href="/static/pc/css/pager.css">
    <script type="text/javascript" src="/static/pc/js/cate.js"></script>
</head>
<body>
    <#include "common/header.ftl">
    <div class="main w1200">
        <div class="line-cate-nav-location">
            <div class="line-cate-nav-wrapper">
                <ul class="line-cate-nav">
                    <li><a rel="nofollow" href="/" class="active">全部分类</a></li>
                    <@category_list status="1">
                    <#list cateList as cate>
                        <li><a href="/cate${cate.fqcat!}/"  title="${cate.name!}">${cate.name!}</a></li>
                    </#list>
                    </@category_list>
                    <li style="padding-left:50px;font-size:12px;">排序：</li>
                    <li style="padding-left:5px;"><a style="font-size:12px;" href="/cate${cate.fqcat!}/t/starttime/desc/1.html" title="按照更新最近的优惠券排序">最新</a></li>
                    <li style="padding-left:5px;"><a style="font-size:12px;" href="/cate${cate.fqcat!}/t/itemsale/desc/1.html" title="按照领优惠券下单量排序">销量</a></li>
                    <li style="padding-left:5px;"><a style="font-size:12px;" href="/cate${cate.fqcat!}/t/itemprice/asc/1.html" title="按照使用优惠券后价格排序有低到高">价格</a></li>
                    <li style="padding-left:5px;"><a style="font-size:12px;" href="/cate${cate.fqcat!}/t/discount/desc/1.html" title="按照优惠券折扣力度排序">折扣</a></li>
                    <li style="padding-left:5px;"><a style="font-size:12px;" href="/cate${cate.fqcat!}/t/couponmoney/desc/1.html" title="按照优惠券面值排序有大到小">优惠券</a></li>
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
                console.log(obj);
                if (!first) {
                    location.href = '${plink!}' + obj.curr + '.html';
                }
            }
        });
    });
</script>
</body>
</html>