<!DOCTYPE html>
<html class="jp-pc w1200">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
    <title>【${s!}】相关所有优惠券-${web.webname!}</title>
    <meta name="keywords" content="${s!}">
    <meta name="description" content="为您提供${s!}相关优惠券信息。">
     <!--公共cssjs-->
    <#include "common/jscss.ftl">
    <!--私有cssjs-->
    <link type="text/css" rel="stylesheet" href="/static/pc/css/pager.css">
    <#--<script type="text/javascript" src="/static/js/fun.js"></script>-->
    <script type="text/javascript" src="/static/pc/js/header.js"></script>
</head>
<body>
    <#include "common/header.ftl">
    <div class="line-cate-nav-location">
        <div class="line-cate-nav-wrapper">
            <ul class="line-cate-nav">
                <li><a rel="nofollow" href="/" class="active">全部分类</a></li>
                <@category_list status="1">
                <#list cateList as cate>
                    <li><a href="/cate${cate.fqcat!}" title="${cate.name!}">${cate.name!}</a></li>
                </#list>
                </@category_list>
                <li style="padding-left:50px;font-size:12px;">排序：</li>
                <li style="padding-left:5px;"><a style="font-size:12px;" href="/search/t/starttime/desc/1.html" title="最新">最新</a></li>
                <li style="padding-left:5px;"><a style="font-size:12px;" href="/search/t/itemsale/desc/1.html" title="销量">销量</a></li>
                <li style="padding-left:5px;"><a style="font-size:12px;" href="/search/t/itemprice/asc/1.html" title="价格">价格</a></li>
                <li style="padding-left:5px;"><a style="font-size:12px;" href="/search/t/discount/desc/1.html" title="折扣">折扣</a></li>
                <li style="padding-left:5px;"><a style="font-size:12px;" href="/search/t/couponmoney/desc/1.html" title="优惠券">优惠券</a></li>
            </ul>
        </div>
    </div>
    <div class="main w1200">
        <div class="main pr mt25 clear">
            <#include "common/list_item.ftl">
        </div>
        <div class="page" id="pager"></div>
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