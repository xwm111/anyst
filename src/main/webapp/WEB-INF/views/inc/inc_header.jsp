<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="bg"></div>
<div class="logo"><img src="${ctx}/static/themes/default/images/header-logo.png" width="489" height="110">;</div>
<div id="navMenu" class="nav">
</div>
<div class="msg">
  <div class="timer">2015年01月01日　15:28:40　星期五 </div>
  <div class="prompt">你好！ admin 欢迎使用本系统</div>
</div>
<div class="topNav">
  <ul>
    <li class="first last">
      <a onClick="qDialog({href:'${ctx}/inc/inc_set.jsp',iconCls:'icon_settings',title:'系统设置',width:680,height:445,onLoad:function(){$('#setConfig').tabs({selected:'用户管理'})}})">系统设置</a>
    </li>
  </ul>
</div>
