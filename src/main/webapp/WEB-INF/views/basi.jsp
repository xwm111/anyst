<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>e货广场 企业销售管理平台【友芝友定制版】</title>
<script src="${ctx}/static/js/jquery/UI/jquery-1.9.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/static/themes/default/css/style.css">
<script src="${ctx}/static/js/script.js"></script>
<script>
$(function(){
	
})


</script>
</head>

<body>
<div class="easyui-tabs" fit=true>
	<div title="用户分组管理" href="${ctx}/inc/basi/inc_group_list"></div>
	<div title="礼品分类管理" href="${ctx}/inc/basi/inc_class_list"></div>
	<div title="医院/科室管理" href="${ctx}/inc/basi/inc_depar_list"></div>
	<div title="帖花管理" href="${ctx}/inc/basi/inc_flowe_list"></div>
</div>
</body>
</html>
