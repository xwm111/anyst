<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="easyui-layout" fit="true">
  <form id="createSupplierForm" method="post">
  <c:choose>
    <c:when test="${empty supplierBean}">
  <div data-options="region:'center',border:false" href="${ctx}/inc/dist/inc_dist_list_add_infos"></div>
    </c:when>
    <c:otherwise>
  <div data-options="region:'center',border:false" href="${ctx}/inc/dist/inc_dist_list_edit_infos?supplierId=${supplierBean.id}&supplierName=${supplierBean.name}&supplierPhone=${supplierBean.phone}&supplierEmail=${supplierBean.email}&supplierDescription=${supplierBean.description}"></div>
    </c:otherwise>
  </c:choose>
  
    <!--<div class="easyui-tabs" fit="true" border="false">
      <div title="基本信息" href="../inc/inc_cust_list_add_infos.html"></div>
    </div>-->
  
  </form>
</div>
