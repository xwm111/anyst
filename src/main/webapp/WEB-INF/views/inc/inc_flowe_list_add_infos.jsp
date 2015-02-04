<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="form">
  <table border="0" cellpadding="0" cellspacing="4" class="content">
  	<tr>
      <th width="100" align="right">贴花ID：</th>
      <td><input name="tapCode" type="text" value="${tapBean.code}"style="width:180px;"></td>
    </tr>
    <tr>
      <th width="100" align="right">贴花名称：</th>
      <td><input name="tapName" type="text" value="${tapBean.name}"style="width:180px;"></td>
    </tr>
    <tr>
      <th width="100" align="right">使用状态：</th>
      <c:choose>
				<c:when test="${empty tapBean}">
		<td><input id="tapStatusCheckBox" name="tapStatus" type="checkbox" value="1" onClick="changeStatus()" checked></td>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${tapBean.status == 0}">	
		<td><input id="tapStatusCheckBox" name="tapStatus" type="checkbox" value="0" onClick="changeStatus()"></td>
						</c:when>
						<c:otherwise>
		<td><input id="tapStatusCheckBox" name="tapStatus" type="checkbox" value="1" onClick="changeStatus()" checked></td>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
      
    </tr>
  </table>
  <div class="nullLine" style="height:4px;"></div>
  <table border="0" cellpadding="0" cellspacing="4" class="content">
    <tr>
      <th width="100" align="right">所属产品：</th>
      <c:choose>
      	<c:when test="${empty tapBean}">
      <td><select class="easyui-combobox" panelHeight="auto" style="width:180px;" name="tapProduct" id="tapProduct" 
      	data-options="
      	 url:'${ctx}/api/v1/product/listAllProduct',
  		 method:'get',
  		 valueField:'code',
  		 textField:'name',
  		 onLoadSuccess: function(data){
  		 	if(data) {
  		 		$(this).combobox('setValue', data[0].code);
			}
  		 }
      ">
      </select></td>
        </c:when>
        <c:otherwise>
        <td><select class="easyui-combobox" panelHeight="auto" style="width:180px;" name="tapProduct" id="tapProduct" 
      	data-options="
      	 url:'${ctx}/api/v1/product/listAllProduct',
  		 method:'get',
  		 valueField:'code',
  		 textField:'name',
  		 value: '${tapBean.product}'
      ">
      </select></td>
        </c:otherwise>
      </c:choose>
    </tr>
  </table>
  <div class="nullLine" style="height:4px;"></div>
  <table border="0" cellpadding="0" cellspacing="4" class="content">
    <tr>
      <th width="100" align="right">贴花说明：</th>
      <td><textarea name="tapDescription" style="width:220px; height:150px;">${tapBean.description}</textarea></td>
    </tr>
  </table>
</div>
<script>
function changeStatus() {
	var checkBox = $('#tapStatusCheckBox'); 
	var checked = checkBox.val();
	if (checked == 1) {
		checkBox.val(0);
	} else {
		checkBox.val(1);
	}
}
</script>