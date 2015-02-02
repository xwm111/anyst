<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="easyui-layout" fit="true">
  <div data-options="region:'center',border:false">
    <div class="easyui-tabs" fit="true" border="false">
      <div title="关联产品" href="${ctx}/inc/repr/inc_repr_list_relation_prodList"></div>
    </div>
  </div>
  <div data-options="region:'east',border:false" style="width:560px; border-left:1px solid #dbdbdb;">
    <div class="easyui-tabs" fit="true" border="false">
      <div title="关联客户" href="${ctx}/inc/repr/inc_repr_list_relation_custList"></div>
    </div>
  </div>
</div>
