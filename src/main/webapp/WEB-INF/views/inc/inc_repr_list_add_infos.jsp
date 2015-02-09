<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="form">
  <input name="representorId" type="hidden" value="${representorBean.id}"/>
  <table border="0" cellpadding="0" cellspacing="4" class="content">
    <tr>
      <th width="100" align="right">代表姓名：</th>
      <td><input name="representorName" type="text" style="width:180px;" value="${representorBean.name}"/></td>
    </tr>
    <tr>
      <th align="right">代表电话：</th>
      <td><input name="representorPhone" type="text" style="width:180px;" value="${representorBean.phone}"/></td>
    </tr>
    <tr>
      <th align="right">所属经销商：</th>
      <td><select name="representorSupplier" id="select">
      </select></td>
    </tr>
    <tr>
      <th align="right">代表微信号：</th>
      <td><input name="representorWeichat" type="text" style="width:180px;" value="${representorBean.webChat}"/></td>
    </tr>
  </table>
  <div class="nullLine" style="height:4px;"></div>
  <table border="0" cellpadding="0" cellspacing="4" class="content">
    <tr>
      <th width="100" align="right">备注：</th>
      <td><textarea name="representorDescription" style="width:220px; height:50px;">${representorBean.description}</textarea></td>
    </tr>
  </table>
</div>
