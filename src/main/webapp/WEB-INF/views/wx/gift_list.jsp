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
var page=1;
$(function(){
	appendGridList()
})
function appendGridList(){
  var lists=$('#gridList').children('ul');
  $.ajax({
    type:'GET',
	url:'${ctx}/api/v1/gift/mbquery?page='+page+'&pcode=${pcode}&flowerrange=${flowerrange}&giftgroup=${giftgroup}',
 //    url:'${ctx}/static/weixin/data/data_gift.json?page='+page,
    dataType:"json",
    async:true,
    success: function(data){
      $.each(data.rows,function(idx,comt){
        page++;
        $("<li></li>").append(formatterData(comt)).appendTo(lists)
      })
    },
    error:function(){
    }
  })
}
function formatterData(d){
	var html=''
	if(!!d){
		html+='<div class="listContGroup">'
		html+='<div class="conts">'
		html+='<div class="imgs">'
		html+='<span class="img" style="background-image:url('+d.giftPicUrl+')"></span>'
		html+='<span class="note"> <img src="${product.tapImgUrls}"> '+d.flowerQuantity+' 枚</span>'
		html+='</div>'
		html+='<div class="titles">'
		html+='<span class="title">'+d.giftName+'<span class="unit">￥'+Number(d.openPrice).toFixed(2)+'</span></span>'
		html+='<span class="note">'+d.intro+'</span>'
		html+='</div>'
		html+='</div>'
		html+='<div class="btns">'
		html+='<a href="${ctx}/mbgift/'+d.giftId+'？flowerurl=${product.tapImgUrls}">详细</a>'
		html+='<a href="${ctx}/mbbuygift?id='+d.giftId+'&number=1">兑换一个</a>'
		html+='</div>'
		html+='</div>'
	}
	return html
}
</script>
</head>

<body>
<div class="contents">
  <div class="nullLine" style="height:10px;"></div>
  <div id="gridList" class="gridList A">
    <ul>
      <!--<li>
        <div class="listContGroup">
          <div class="conts">
            <div class="imgs">
              <span class="img" style="background-image:url(../../sys/updata/u=4250297255,88089081&fm=58.jpg)"></span>
              <span class="note"> 8 's</span>
            </div>
            <div class="titles">
              <span class="title">德国巧克力<span class="unit">￥80.00</span></span>
              <span class="note">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet. Proin gravida dolor sit amet lacus ...</span>
            </div>
          </div>
          <div class="btns">
            <a>详细</a>
            <a>兑换一个</a>
          </div>
        </div>
      </li>
      <li>
        <div class="listContGroup">
          <div class="conts">
            <div class="imgs">
              <span class="img" style="background-image:url(../../sys/updata/u=4250297255,88089081&fm=58.jpg)"></span>
              <span class="note"> 8 's</span>
            </div>
            <div class="titles">
              <span class="title">德国巧克力<span class="unit">￥80.00</span></span>
              <span class="note">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet. Proin gravida dolor sit amet lacus ...</span>
            </div>
          </div>
          <div class="btns">
            <a>详细</a>
            <a>兑换一个</a>
          </div>
        </div>
      </li>
      <li>
        <div class="listContGroup">
          <div class="conts">
            <div class="imgs">
              <span class="img" style="background-image:url(../../sys/updata/u=4250297255,88089081&fm=58.jpg)"></span>
              <span class="note"> 8 's</span>
            </div>
            <div class="titles">
              <span class="title">德国巧克力<span class="unit">￥80.00</span></span>
              <span class="note">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet. Proin gravida dolor sit amet lacus ...</span>
            </div>
          </div>
          <div class="btns">
            <a>详细</a>
            <a>兑换一个</a>
          </div>
        </div>
      </li>
      <li>
        <div class="listContGroup">
          <div class="conts">
            <div class="imgs">
              <span class="img" style="background-image:url(../../sys/updata/u=4250297255,88089081&fm=58.jpg)"></span>
              <span class="note"> 8 's </span>
            </div>
            <div class="titles">
              <span class="title">德国巧克力<span class="unit">￥80.00</span></span>
              <span class="note">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet. Proin gravida dolor sit amet lacus ...</span>
            </div>
          </div>
          <div class="btns">
            <a>详细</a>
            <a>兑换一个</a>
          </div>
        </div>
      </li>-->
    </ul>
  </div>
  <div class="nullLine" style="height:10px;"></div>
  <div class="inputButton">
  	<a onClick="appendGridList()">加载下一页</a>
  </div>
</div>
</body>
</html>
