<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="easyui-layout" fit="true">
  <form id="createGroupForm" method="post">
  <c:choose>
    <c:when test="${empty customerGroupBean}">
  <div data-options="region:'center',border:false" href="${ctx}/inc/basi/inc_group_list_add_infos">
    <!--<div class="easyui-tabs" fit="true" border="false">
      <div title="基本信息" href="../inc/inc_cust_list_add_infos.html"></div>
    </div>-->
  </div>
    </c:when>
    <c:otherwise>
  <div data-options="region:'center',border:false" href="${ctx}/inc/basi/inc_group_list_edit_infos?customerGroupId=${customerGroupBean.id}&customerGroupName=${customerGroupBean.name}&customerGroupDescription=${customerGroupBean.description}">
    <!--<div class="easyui-tabs" fit="true" border="false">
      <div title="基本信息" href="../inc/inc_cust_list_add_infos.html"></div>
    </div>-->
  </div>
    </c:otherwise>
  </c:choose>
  </form>
</div>
