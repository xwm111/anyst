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
<title>礼品搜索</title>
<link rel="stylesheet" type="text/css" href="${ctx}/static/weixin/themes/default/css/style.css">
<script src="${ctx}/static/weixin/js/jquery.js"></script>
<script src="${ctx}/static/weixin/js/script.js"></script>
<script>
var bannerData=[
  {
    src:'${p.productImgUrls}'
  }
 ]

$(function(){
	setBanner({elmts:"#imgList",data:bannerData})

	$('#selectClass').mobiscroll(defaultControls.selects);
	$('#selectPayer').mobiscroll(defaultControls.selects);
})
</script>
</head>

<body>
<form action="${ctx}/mbsearchgift" method="post">
<input type="hidden" name="pcode" vale="${ pcode}">
<div id="imgList"></div>
<div class="contents">
  <div class="gridList">
    <ul>
      <li>
        <div class="inputGroup">
          <!--<span class="icon icon-class"></span>-->
          <span class="titles">礼品分类</span>
          <span class="selects">
          <select id="selectClass" name="giftgroup">
          <c:forEach  var="gg" items="${gglist}">
            <option value="${gg.id }">${gg.name }</option>
          </c:forEach>
          </select>
          </span>
        </div>
      </li>
      <li>
        <div class="inputGroup">
          <!--<span class="icon icon-class"></span>-->
          <span class="titles">贴花数量</span>
          <span class="selects">
          <select id="selectPayer" name="flowerrange">
            <option  value="0">1~5</option>
            <option value="1">6~10</option>
            <option value="2">11~15</option>
          </select>
          </span>
        </div>
      </li>
    </ul>
  </div>
  <div class="nullLine" style="height:10px;"></div>
  <div class="inputButton org">
  	<a href="javascript:document.forms[0].submit()">搜索</a>
  	<!--<a>清空</a>-->
  </div>
  <div class="nullLine" style="height:10px;"></div>
  <div class="inputButton gre">
  	<a href="regist.html">我要注册</a>
  	<!--<a>清空</a>-->
  </div>
</div>
</form>
</body>
</html>
