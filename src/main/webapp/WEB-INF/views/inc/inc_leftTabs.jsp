<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<ul>
  <li class="selected">
    <a href="${ctx}/prod"><span class='icon-leftTab i-11'></span><span class='txt'>产品管理</span></a>
  </li>
  <li>
    <a href="${ctx}/gift"><span class='icon-leftTab i-10'></span><span class='txt'>礼品管理</span></a>
  </li>
  <li>
    <a href="${ctx}/cust"><span class='icon-leftTab i-09'></span><span class='txt'>客户管理</span></a>
  </li>
  <li>
    <a href="${ctx}/dist"><span class='icon-leftTab i-01'></span><span class='txt'>经销商管理</span></a>
  </li>
  <li>
    <a href="${ctx}/repr"><span class='icon-leftTab i-08'></span><span class='txt'>代表管理</span></a>
  </li>
  <li>
    <a href="${ctx}/basi"><span class='icon-leftTab i-07'></span><span class='txt'>基础数据管理</span></a>
  </li>
  <li>
    <a href="${ctx}/sett"><span class='icon-leftTab i-02'></span><span class='txt'>结算管理</span></a>
  </li>
  <li>
    <a href="${ctx}/orde"><span class='icon-leftTab i-05'></span><span class='txt'>订单管理</span></a>
  </li>
  <li>
    <a class="customization" href="${ctx}/serv"><span class='icon-leftTab i-04'></span><span class='txt'>客服管理</span></a>
  </li>
  <li>
    <a class="customization" href="${ctx}/logm"><span class='icon-leftTab i-12'></span><span class='txt'>日志管理</span></a>
  </li>
</ul>
<script>
	$(".leftTabs").find("a").click(function(){
		getUrl($(this).attr("href"));
		var par=$(this).parent().addClass("selected").siblings().removeClass("selected");
		return false
	})
</script>
