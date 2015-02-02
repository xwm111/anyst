<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>优思特商贸管理平台 </title>
<script src="${ctx}/static/js/jquery/UI/jquery-1.9.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/static/themes/default/css/style.css">
<script src="${ctx}/static/js/script.js"></script>
<script>
$(function(){
	
})


</script>
</head>

<body oncontextmenu="return false" onselectstart="return false" ondragstart="return false" onbeforecopy="return false" oncopy=document.selection.empty() onselect=document.selection.empty()>
<div data-options="fit:true" class="easyui-layout">
  <div data-options="region:'north',border:false" href="${ctx}/inc/inc_header" class="header" style="overflow:hidden;"></div>
  <div data-options="region:'center',border:false">
  	<div class=" easyui-layout" fit="true">
    	<div data-options="region:'west',border:false" class="leftTabs" href="${ctx}/inc/inc_leftTabs"></div>
        <div data-options="region:'center',border:false" class="mains" id="_mainframe" href="${ctx}/prod" style="padding:4px;"></div>
    </div>
  </div>
  <div data-options="region:'south',border:false" href="${ctx}/inc/inc_footer" class="footer"></div>
</div>

<!------------------------------------------------------->
<!--通用对话窗口-->
<div id="dlg_example" class="easyui-dialog" data-options="closed:true,modal:true,method:'GET'"></div>
<!------------------------------------------------------->

</html>
