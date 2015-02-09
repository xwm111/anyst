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
var bannerData=[
  {
    src:"${ctx}/static/weixin/update/slider01.jpg"
  },
  {
    src:"${ctx}/static/weixin/update/slider01.jpg"
  },
  {
    src:"${ctx}/static/weixin/update/slider01.jpg"
  }
 ]

$(function(){
	setBanner({elmts:"#imgList",data:bannerData})
})

</script>
</head>

<body>
<div id="imgList"></div>
<form action="${ctx}/mbbuygift" method="post">
<input type="hidden" name="id" value="${id }">;
<div class="content-view paper">
  <h4>德国巧克力 <span style="float:right;"><input name="number" type="text" min="1" class="qdone-numbers" value="1" style="width:60px; text-align:center;"></span></h4>
  <div class="nullLine" style="height:15px;"></div>
  <p><span class="font-16-org">￥80.00</span> <span class="font-12-g-del">￥118.00</span> <span class="font-16-gre" style="float:right;"> <img src="${ctx}/static/weixin/themes/default/images/flower.png" width="20" height="20" style="vertical-align:middle; position:relative; top:-2px;"> 8 枚</span></p>
</div>
<div class="content-view paper">
  <p class="font-14-g">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet. Proin gravida dolor sit amet lacus ...</p>
</div>
<div class="contents">
  <div class="inputButton">
    <a href="javascript:document.forms[0].submit()">申请兑换？</a>
  </div>
</div>
</form>
</body>
</html>
