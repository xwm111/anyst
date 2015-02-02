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
      <th data-options="field:'lab_12',width:100,align:'center',formatter:rowFormater_pic">产品图片</th>
      <th data-options="field:'lab_10',width:120,align:'center',formatter:rowFormater_state">客户状态</th>
    </tr>
  </thead>
</table>
<div id="gridTools_inc_repr_list_relation_custList" style="padding:5px;height:auto">
  <input class="easyui-validatebox" name="" type="text" style="width:180px" placeholder="名称/所属经销商/电话">
  <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search">搜索</a>
</div>

<script>


function rowFormater_state(value,row,index){
	switch(Number(value)){
		case 0:
		return '未确认'
		case 1:
		return '已确认'
	}
}
function rowFormater_pic(value,row,index){
	if(!!!value) return "尚无图片"
	var picArr=value.split("|");
	if(picArr.length>0){
		return "有图片("+picArr.length+")"
	}else{
		return "尚无图片"
	}
}
</script>