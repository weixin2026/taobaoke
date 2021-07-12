<div class="app-other">
    <ul>
        <li class="search">
            <div id="search-box">
                <form id="search-form" action="/search" method="get">
                    <div class="box-search">
                        <input type="text" name="s" x-webkit-speech="" placeholder="搜索商品" autocomplete="off">
                        <a href="javascript:;" class="del"><img src="/static/m/images/del.png"></a>
                    </div>
                    <button id="search-submit" type="submit"><img src="/static/m/images/search.png"></button>
                </form>
            </div>
        </li>
        <li class="normal active "><a href="/">首页</a></li>
        <@category_list status="1">
            <#list cateList as cate>
                <li class="normal"><a href="/cate${cate.fqcat!}/">${cate.name!}</a></li>
            </#list>
        </@category_list>
    </ul>
    <p>
        <a href=""><em class="icon-user"></em><br>个人中心</a>
        <a href=""><em class="icon-about"></em><br>关于我们</a>
    </p>
</div>