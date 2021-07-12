<section class="goods">
    <ul class="goods-list clear">
        <#list goodsList as goods>
            <li>
                <a class="goods-a" href="/cate${goods.fqcat!}/${goods.itemid!}.html" rel="nofollow" target="_self">
                    <img class="lazy" src="${goods.itempic!}" alt="${goods.itemtitle!},有${goods.couponmoney!}元券">
                </a>
                <a href="/cate${goods.fqcat!}/${goods.itemid!}.html" target="_self">
                    <h3>
                        <#if goods.shoptype == "B">
                            <i class="zg-b"></i>
                        </#if>
                        <#if goods.shoptype == "C">
                            <i class="zg-c"></i>
                        </#if>
                        ${goods.itemtitle!},领券下单仅需${goods.itemendprice!}元
                    </h3>
                    <div class="list-price buy">
                        <span class="price-new"><i>券后价:￥</i>${goods.itemendprice!}</span>
                        <i class="del">￥${goods.itemprice!}</i>
                    </div>
                    <div class="list-price buy">
                        <span class="good-btna" style="font-size:12px">已售:${goods.itemsale!}</span>
                        <#--<span class="good-btn">50人已领券</span>-->
                    </div>
                </a>
                <div class="lingquan">
                    <a href="/cate${goods.fqcat!}/${goods.itemid!}.html" rel="nofollow" target="_self" class="coupon">
                        <span><font color="#fcff00">优惠券</font><br>${goods.couponmoney!}元</span><b></b>
                    </a>
                </div>
            </li>
        </#list>
    </ul>
</section>