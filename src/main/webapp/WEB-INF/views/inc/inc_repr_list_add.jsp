<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="easyui-layout" fit="true">
  <div data-options="region:'center',border:false" href="${ctx}/inc/repr/inc_repr_list_add_infos">
    <!--<div class="easyui-tabs" fit="true" border="false">
      <div title="基本信息" href="../inc/inc_cust_list_add_infos.html"></div>
    </div>-->
  </div>
</div>
