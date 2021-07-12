<@friends_link_list>
    <#if friendsLinkList??>
        <ul style="border:2px solid #FF0000;padding:5px">
            <h3 class="mb10" style="padding:3px">友情链接:（申请友链联系在线QQ客服）</h3>
            <dl style="line-height:20px;">
                <#list friendsLinkList as link>
                <a href="${link.link!}" title="${link.name!}" target='_blank' rel="first" style="padding:10px" >${link.name!}</a>
                </#list>
            </dl>
        </ul>
    </#if>
</@friends_link_list>
