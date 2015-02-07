<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=2.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-touch-fullscreen" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no" />
<meta name="format-detection" content="email=no" />
<title>礼品列表</title>
<link rel="stylesheet" type="text/css" href="${ctx}/static/weixin/themes/default/css/style.css">
<script src="${ctx}/static/weixin/js/jquery.js"></script>
<script src="${ctx}/static/weixin/js/script.js"></script>
<script>


$(function(){
	
})

</script>
</head>

<body>
<div id="imgList"></div>
<div class="content-view paper">
  <p class="noteImg Buy"></p>
  <p class="font-14-g">感谢您对XXX产品的支持，祝您工作顺利，万事如意！您所兑换的礼品将下方指定工作人员在近期内给您送到。</p>
</div>
<div class="content-view paper">
  <h4>
  刘凡 <span class="font-16-gre" style="float:right">18888888888</span>
  </p>
</div>
<div class="nullLine" style="height:10px;"></div>
<div class="contents">
  <div class="inputButton">
    <a href="${ctx}/mbproduct/${pcode }">返回礼品列表</a>
  </div>
</div>
</body>
</html>
