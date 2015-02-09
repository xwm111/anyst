<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="form"> 
  <input name="serviceId" type="hidden" value="${servBean.id}">
  <table border="0" cellpadding="0" cellspacing="4" class="content">
    <tr>
      <th width="100" align="right">客服名称：</th>
      <td><input name="serviceName" type="text" style="width:180px;" value="${servBean.name}"/></td>
    </tr>
    <tr>
      <th align="right">客服帐号：</th>
      <td><input name="serviceAccount" type="text" style="width:180px;" value="${servBean.account}"/></td>
    </tr>
    <tr>
      <th align="right">电话：</th>
      <td><input name="servicePhone" type="text" style="width:180px;" value="${servBean.phone}"/></td>
    </tr>
  </table>
</div>
