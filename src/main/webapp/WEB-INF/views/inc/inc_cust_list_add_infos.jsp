<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="form">
  <table border="0" cellpadding="0" cellspacing="4" class="content">
    <tr>
      <th width="100" align="right">医院：</th>
      <td><select name="select3" id="select4">
      </select></td>
    </tr>
    <tr>
      <th align="right">科室：</th>
      <td><select name="select3" id="select4">
      </select></td>
    </tr>
    <tr>
      <th align="right">电话：</th>
      <td><input name="input5" type="text" style="width:180px;" /></td>
    </tr>
    <tr>
      <th align="right">分组：</th>
      <td><select name="select3" id="select4">
      </select></td>
    </tr>
  </table>
  <div class="nullLine" style="height:4px;"></div>
  <table border="0" cellpadding="0" cellspacing="4" class="content">
    <tr>
      <th width="100" align="right">备注：</th>
      <td><textarea name="input3" style="width:220px; height:50px;"></textarea></td>
    </tr>
  </table>
</div>
