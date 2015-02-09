<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="form">
  <table border="0" cellpadding="0" cellspacing="4" class="content">
    <tr>
      <th align="right">姓名：</th>
      <td><input name="customerName" type="text" style="width:180px;" /></td>
    </tr>
    <tr>
      <th align="right">微信号：</th>
      <td><input name="customerWeiChat" type="text" style="width:180px;" /></td>
    </tr>
    <tr>
      <th width="100" align="right">医院：</th>
      <td><select class="easyui-combobox" name="customerHospital" id="customerHospital" panelHeight="auto" style="width:100px" 
      data-options="
  		 url:'${ctx}/api/v1/depar/listAllHospital',
  		 method:'get',
  		 valueField:'id',
  		 textField:'hospitalName',
  		 onLoadSuccess: function(data) {
           if (data) {
             $(this).combobox('select', data[0].id);
         }},
         onSelect: function(data) {
           if (data) {
             $.ajax({
               url : '${ctx}/api/v1/depar/listAllDepartment?hospitalId=' + data.id,
               cache : false,
               async : false,
               type : 'GET',
               dataType : 'json',
               success : function(ret){
               	 if (ret) {
               	   if(!!ret[0].id) {
               	     alert(2);
                     $('#customerDepartment').combobox({data: ret, valueField: 'id', textField: 'departmentName', value: ret[0].id});
                   } else {
                   	 $('#customerDepartment').combobox();
                   }
                 } 
               },
               error: function(error) {
                 alert(error);
               }
             });
           }
         }
  	  ">
      </select></td>
    </tr>
    <tr>
      <th align="right">科室：</th>
      <td><select class="easyui-combobox" name="customerDepartment" id="customerDepartment" panelHeight="auto" style="width:100px">
      </select></td>
    </tr>
    <tr>
      <th align="right">电话：</th>
      <td><input name="customerPhone" type="text" style="width:180px;" /></td>
    </tr>
    <tr>
      <th align="right">身份：</th>
      <td><select class="easyui-combobox" name="customerType" id="customerType" panelHeight="auto" style="width:100px"
      data-options="
      	 data:[{type: '未确认', value: -1},{type: '医生', value: 0},{type: '护士', value: 1}],
      	 valueField: 'value',
      	 textField: 'type',
      	 value:-1
      ">
      </select></td>
    </tr>
    <tr>
      <th align="right">分组：</th>
      <td><select class="easyui-combobox" name="customerGroup" id="customerGroup" panelHeight="auto" style="width:100px"
      data-options="
      	 url:'${ctx}/api/v1/group/listAllCustomerGroup',
  		 method:'get',
  		 valueField:'id',
  		 textField:'name',
  		 onLoadSuccess: function(data) {
           if (data) {
             if(!!data[0].id) { 
               $(this).combobox('select', data[0].id);
             } else {
               $(this).combobox();
             }
         }}
      ">
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
