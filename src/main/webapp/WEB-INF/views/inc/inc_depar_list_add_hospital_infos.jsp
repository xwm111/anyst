<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="easyui-layout" fit="true">
  <div data-options="region:'center',border:false">
  	<form id="createHospitalForm" method="POST">
    <div class="form">
      <input type="hidden" name="hospitalId" value="${hospitalBean.id}"/>
	  <table border="0" cellpadding="0" cellspacing="4" class="content">
	    <tr>
	      <td>&nbsp;</td>
	    </tr>
	    <tr>
	      <th width="100" align="right">医院名称：</th>
	      <td><input name="hospitalName" type="text" style="width:180px;" value="${hospitalBean.hospitalName}"/></td>
	    </tr>
	  </table>
	</div>
	</form>
  </div>
</div>
