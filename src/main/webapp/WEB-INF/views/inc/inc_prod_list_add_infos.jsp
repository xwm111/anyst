<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="form">
<!-- 
  <table border="0" cellpadding="0" cellspacing="4" class="content">
    <tr>
      <th width="100" align="right">商品条码：</th>
      <td><input name="input" type="text" style="width:180px;"></td>
    </tr>
    <tr>
      <th width="100" align="right">&nbsp;</th>
      <td>扫描条码，自动从商品库中查询商品属性，未编辑过的商品手动编辑商品属性信息</td>
    </tr>
  </table>
   -->
  <div class="nullLine" style="height:4px;"></div>
  <table border="0" cellpadding="0" cellspacing="4" class="content">
    <tr>
      <th width="100" align="right">商品名称：</th>
      <td><input name="productName" type="text" style="width:180px;" value="${productBean.name}"/></td>
    </tr>
    <tr>
      <th align="right">商品编码：</th>
      <td><input name="productCode" type="text" style="width:180px;" value="${productBean.code}"/></td>
    </tr>
    <!-- 
    <tr>
      <th align="right">商品分类：</th>
      <td><select name="select" id="select">
      </select></td>
    </tr>
    <tr>
      <th align="right">商品规格：</th>
      <td><select name="select3" id="select4">
      </select></td>
    </tr>
    <tr>
      <th width="100" align="right">计量单位：</th>
      <td><select name="select2" id="select2">
      </select></td>
    </tr>
     -->
  </table>
  <div class="nullLine" style="height:4px;"></div>
  <table border="0" cellpadding="0" cellspacing="4" class="content">
    <tr>
      <th width="100" align="right">产品介绍：</th>
      <td><textarea name="productDescription" style="width:220px; height:50px;">${productBean.description}</textarea></td>
    </tr>
  </table>
</div>
