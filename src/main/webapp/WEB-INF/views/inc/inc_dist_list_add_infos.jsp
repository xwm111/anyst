<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="form">
  <input name="supplierId", type="hidden", value="${supplierBean.id}" />
  <table border="0" cellpadding="0" cellspacing="4" class="content">
    <tr>
      <th width="100" align="right">名称：</th>
      <td><input name="supplierName" type="text" style="width:180px;" value="${supplierBean.name}"/></td>
    </tr>
    <tr>
      <th align="right">经销商电话：</th>
      <td><input name="supplierPhone" type="text" style="width:180px;" value="${supplierBean.phone}"/></td>
    </tr>
    <tr>
      <th align="right">邮箱：</th>
      <td><input name="supplierEmail" type="text" style="width:180px;" value="${supplierBean.email}"/></td>
    </tr>
  </table>
  <div class="nullLine" style="height:4px;"></div>
  <table border="0" cellpadding="0" cellspacing="4" class="content">
    <tr>
      <th width="100" align="right">备注：</th>
      <td><textarea name="supplierDescription" style="width:220px; height:50px;">${supplierBean.description}</textarea></td>
    </tr>
  </table>
</div>
