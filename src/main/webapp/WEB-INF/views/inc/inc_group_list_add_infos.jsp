<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="form">
  <input type="hidden" name="customerGroupId" value="${customerGroupBean.id}"/>
  <table border="0" cellpadding="0" cellspacing="4" class="content">
    <tr>
      <th width="100" align="right">分组名称：</th>
      <td><input name="customerGroupName" type="text" style="width:180px;" value="${customerGroupBean.name}"/></td>
    </tr>
  </table>
  <div class="nullLine" style="height:4px;"></div>
  <table border="0" cellpadding="0" cellspacing="4" class="content">
    <tr>
      <th width="100" align="right">备注：</th>
      <td><textarea name="customerGroupDescription" style="width:220px; height:50px;">${customerGroupBean.description}</textarea></td>
    </tr>
  </table>
</div>
