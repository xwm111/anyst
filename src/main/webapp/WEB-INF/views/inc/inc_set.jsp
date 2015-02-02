<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="setConfig" class="easyui-tabs" data-options="border:false,fit:true,tabPosition:'left'">
  <!--<div id="" title="用户信息" style="overflow:hidden;" href="../inc/inc_set_userInfo.html"></div>-->
  <div id="" title="修改密码" style="overflow:hidden;" href="${ctx}/inc/inc_set_repassword.html"></div>
</div>