<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="easyui-layout" fit="true">
  <div data-options="region:'center',border:false">
  <form id="createDepartmentForm" method="POST">
	<div class="form">
	  <table border="0" cellpadding="0" cellspacing="4" class="content">
	    <tr>
	      <td>&nbsp;</td>
	    </tr>
	    <tr>
	      <th width="100" align="right">附属医院：</th>
	      <td>
	      <!-- 
	      <select name="select" id="select">
	        <option value="1">中南医院</option>
	        <option value="2">省人民医院</option>
	      </select>
	      -->
	      <input type="text" style="width:180px;" value="${hospitalBean.hospitalName}"/>
	      <input type="hidden" name="hospitalId" style="width:180px;" value="${hospitalBean.id}"/>
	      </td>
	    </tr>
	    <tr>
	      <th align="right">科室名称：</th>
	      <td>
	        <input name="departmentName" type="text" value="${departmentBean.departmentName}" style="width:180px;" />
	        <input name="departmentId" type="hidden" value="${departmentBean.id}"/>
	      </td>
	    </tr>
	  </table>
	</div>
  </form>    
  </div>
</div>

