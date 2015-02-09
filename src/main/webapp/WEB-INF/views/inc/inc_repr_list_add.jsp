<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="easyui-layout" fit="true">
  <form id="createProductForm" method="post">
  <c:choose>
   	<c:when test="${empty representorBean}">
  <div data-options="region:'center',border:false" href="${ctx}/inc/repr/inc_repr_list_add_infos"></div>
    </c:when>
    <c:otherwise>
  <div data-options="region:'center',border:false" href="${ctx}/inc/repr/inc_repr_list_edit_infos?"></div>
    </c:otherwise>
  </c:choose>
  </form>
</div>
