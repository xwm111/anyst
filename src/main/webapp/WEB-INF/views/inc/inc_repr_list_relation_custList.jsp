<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<table id="grid_inc_repr_list_relation_custList" class="easyui-datagrid"
			data-options="
            toolbar:'#gridTools_inc_repr_list_relation_custList',
            fit:true,
            border:false,
            singleSelect:false,
            fitColumns: true,
            collapsible:true,
            onLoadSuccess:dataGridOnloadSuccess,
            pagination:true,
            url:'../data/data_cust_list.json',
            method:'get'
            ">
  <thead>
    <tr>
      <th data-options="field:'ck',checkbox:true"></th>
      <th data-options="field:'lab_03',width:120,align:'center'">客户名称</th>
      <th data-options="field:'lab_04',width:120,align:'center'">客户信息</th>
      <th data-options="field:'lab_12',width:120,align:'center'">所属医院</th>
      <th data-options="field:'lab_10',width:120,align:'center'">所属科室</th>
      <th data-options="field:'lab_10',width:120,align:'center',formatter:rowFormater_type">身份</th>
    </tr>
  </thead>
</table>
<div id="gridTools_inc_repr_list_relation_custList" style="padding:5px;height:auto">
  <input class="easyui-validatebox" name="" type="text" style="width:180px" placeholder="名称/电话">
  医院：
  <select class="easyui-combobox" id="searchGiftGroup" panelHeight="auto" style="width:100px"
       data-options="
       url:'${ctx}/api/v1/class/listAllGiftGroupIncludeAll',
       method:'get',
       valueField:'id',
       textField:'name',
       value:'-1'
       ">
  </select>
  科室：
  <select class="easyui-combobox" id="searchGiftGroup" panelHeight="auto" style="width:100px"
       data-options="
       url:'${ctx}/api/v1/class/listAllGiftGroupIncludeAll',
       method:'get',
       valueField:'id',
       textField:'name',
       value:'-1'
       ">
  </select>
  分组：
  <select class="easyui-combobox" id="searchGiftGroup" panelHeight="auto" style="width:100px"
       data-options="
       url:'${ctx}/api/v1/class/listAllGiftGroupIncludeAll',
       method:'get',
       valueField:'id',
       textField:'name',
       value:'-1'
       ">
  </select>
  身份：
  <select class="easyui-combobox" id="searchGiftGroup" panelHeight="auto" style="width:100px"
       data-options="
       url:'${ctx}/api/v1/class/listAllGiftGroupIncludeAll',
       method:'get',
       valueField:'id',
       textField:'name',
       value:'-1'
       ">
  </select>
  <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search" onclick="searchCustomer()">搜索</a>
</div>

<script>


function rowFormater_type(value,row,index){
	switch(Number(value)){
		case 0:
		return '未确认'
		case 1:
		return '已确认'
	}
}

function searchCustomer(){

}
</script>