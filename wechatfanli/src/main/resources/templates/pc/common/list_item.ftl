<ul class="goods-list clear">
    <#list goodsList as goods>
    <li>
        <div class="list-good buy">
            <div class="good-pic">
                <a href="/cate${goods.fqcat!}/${goods.itemid!}.html"  class="pic-img" target="_blank">
                    <img alt="${goods.itemtitle!}" src="${goods.itempic!}" class="lazy good-pic" style="display: inline;">
                </a>
            </div>
            <h3 class="good-title">
                <a href="/cate${goods.fqcat!}/${goods.itemid!}.html" target="_blank">${goods.itemtitle!}</a>
                <span class="sold">售出<em>${goods.itemsale!}</em></span>
            </h3>
            <div class="good-price">
                <span class="price-current"><em>￥</em>${goods.itemendprice!}</span>
                <span class="des-other">
                    <!--<strong><em class="icon-gai"> 2019-12-15</em></strong>-->
                    <span class="price-old"><em>￥</em>${goods.itemprice!}</span>
                </span>
                <div class="btn buy m-buy">
                    <a href="javascript:;" rel="nofollow">
                        <em class="m-icon"></em><span>分享</span>
                    </a>
                </div>
            </div>
            <div class="lingquan">
                <a href="/cate${goods.fqcat!}/${goods.itemid!}.html" target="_blank">
                    <span>天猫优惠券<br><em>${goods.couponmoney!}元</em></span>
                    <b></b>
                </a>
            </div>
        </div>
    </li>
    </#list>
</ul>