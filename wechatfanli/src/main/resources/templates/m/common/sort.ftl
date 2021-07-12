<div class="box">
    <ul>
        <li><span>排序：</span></li>
        <li><a href="/${source!}/t/starttime/desc/1.html" class="<#if !sidx?? || sidx == "starttime">active</#if>">最新</a></li>
        <li><a href="/${source!}/t/itemsale/desc/1.html" class="<#if sidx?? && sidx == "itemsale">active</#if>">销量</a></li>
        <li><a href="/${source!}/t/itemprice/asc/1.html" class="<#if sidx?? && sidx == "itemprice">active</#if>">价格</a></li>
        <li><a href="/${source!}/t/discount/desc/1.html" class="<#if sidx?? && sidx == "discount">active</#if>">折扣</a></li>
        <li><a href="/${source!}/t/couponmoney/desc/1.html" class="<#if sidx?? && sidx == "couponmoney">active</#if>">优惠券</a></li>
    </ul>
</div>