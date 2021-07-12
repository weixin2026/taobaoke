<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="robots" content="index,follow" />
<title>${web.webname!}网站地图</title>
<meta name="description" content="${web.webname!}网站地图" />
<style type="text/css">
body {
	background-color: #FFFFFF;
	margin: 20px;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
}

h1 {
	color: #0099CC;
}

#intro {
	background-color: #CFEBF7;
	border: 1px #2580B2 solid;
	padding: 15px 10px 15px 10px;
	margin: 10px 0px 10px 0px;
	line-height: 20px;
	min-width: 900px;
}

#myTable {
	font-size: 11px;
	list-style: none;
	margin: 10px 0px 10px 0px;
	padding:0;
	width: 100%;
	min-width: 804px;
}

#myTable li {
	list-style-type: none;
	width: 100%;
	min-width: 404px;
	height: 20px;
	line-height: 20px;
	display: inline-block;
	clear: both;
}

#myTable li .T1-h {
	float: left;
	font-weight: bold;
	min-width: 300px;
}

#myTable li .T2-h {
	width: 200px;
	float: right;
	font-weight: bold;
}

#myTable li .T3-h {
	width: 200px;
	float: right;
	font-weight: bold;
}

#myTable li .T4-h {
	width: 100px;
	float: right;
	font-weight: bold;
}

#myTable li .T1 {
	float: left;
	min-width: 300px;
}

#myTable li .T2 {
	width: 200px;
	float: right;
}

#myTable li .T3 {
	width: 200px;
	float: right;
}

#myTable li .T4 {
	width: 100px;
	float: right;
}

#footer {
	padding: 2px;
	margin:0;
	font-size: 8pt;
	color: gray;
	min-width: 900px;
}

#footer a {
	color: gray;
}

.myClear {
	clear: both;
}
</style>
</head>
<body>
	<h1>${web.webname!}网站地图</h1>
	<div id="intro">
		网站地图由<a href="http://www.wlkankan.cn" title="免费建站系统" >免费建站系统</a>自动生成！
	</div>
	<ul id="myTable">
		<li>
			<div class="T1-h">URL</div>
			<div class="T2-h">Last Change</div>
			<div class="T3-h">Change Frequency</div>
			<div class="T4-h">Priority</div>
		</li>
		
		<li>
			<div class="T1">
				<a href="/" target="_blank" title="${web.webname!}">${web.webname!}</a>
			</div>
			<div class="T2">${.now?string('yyyy-MM-dd HH:mm:ss')!}</div>
			<div class="T3">Always</div>
			<div class="T4">1</div>
		</li>
		
		<#if cateall?exists>  
			<#list cateall as text>
			<li>
				<div class="T1">
					<a href="/cate${text.fqcat!}/" target="_blank" title="${text.title!}">${text.title!}</a>
				</div>
				<div class="T2">${text.createTime?string('yyyy-MM-dd HH:mm:ss')!}</div>
				<div class="T3">Always</div>
				<div class="T4">0.9</div>
			</li> 
			</#list>
	    </#if> 
	     
		<#if goods?exists>  
			<#list goods as text>
			<li>
				<div class="T1">
					<a href="/cate${text.fqcat!}/${text.itemid!}.html" target="_blank" title="${text.itemtitle!}">${text.itemtitle!}</a>
				</div>
				<div class="T2">${text.createTime?string('yyyy-MM-dd HH:mm:ss')!}</div>
				<div class="T3">Always</div>
				<div class="T4">0.9</div>
			</li> 
			</#list>
		</#if> 
 
	</ul>
</body>
</html>