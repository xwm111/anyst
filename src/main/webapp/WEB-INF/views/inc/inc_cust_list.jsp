﻿<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<table id="grid_inc_cust_list" class="easyui-datagrid"
			data-options="
            toolbar:'#gridTools_inc_cust_list',
            fit:true,
            border:false,
            singleSelect:true,
            fitColumns: true,
            singleSelect: true,
            collapsible:true,
            onLoadSuccess:dataGridOnloadSuccess,
            pagination:true,
            url:'${ctx}/api/v1/cust',method:'get'
            ">
  <thead>
    <tr>
      <th data-options="field:'ck',checkbox:true"></th>
      <th data-options="field:'lab_01',width:120,align:'center',formatter:rowFormater_action">操作</th>
      <th data-options="field:'lab_02',width:100,align:'center'">微信号</th>
      <th data-options="field:'lab_03',width:80,align:'center'">客户姓名</th>
      <th data-options="field:'lab_04',width:160,align:'center'">注册单位信息</th>
      <th data-options="field:'lab_05',width:120,align:'left'">单位</th>
      <th data-options="field:'lab_06',width:80,align:'center'">科室</th>
      <th data-options="field:'lab_07',width:80,align:'center',formatter:rowFormater_type">身份</th>
      <th data-options="field:'lab_08',width:100,align:'center'">电话</th>
      <th data-options="field:'lab_09',width:60,align:'center'">分组</th>
      <th data-options="field:'lab_10',width:60,align:'center',formatter:rowFormater_state">状态</th>
      <th data-options="field:'lab_11',width:160,align:'left'">备注</th>
    </tr>
  </thead>
</table>
<div id="gridTools_inc_cust_list" style="padding:5px;height:auto">
  <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">新增</a>
  <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
  
  <div class="separator"/>
  姓名：
  <input class="easyui-validatebox" name="searchCustomerName" id="searchCustomerName" type="text" style="width:180px" placeholder="姓名关键字">
  医院：
  <select class="easyui-combobox" id="searchCustomerHospital" panelHeight="auto" style="width:100px"
  		 data-options="
  		 url:'${ctx}/api/v1/depar/listAllHospitalIncludeAll',
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
               url : '${ctx}/api/v1/depar/listAllDepartmentIncludeAll?hospitalId=' + data.id,
               cache : false,
               async : false,
               type : 'GET',
               dataType : 'json',
               success : function (ret){
                 $('#searchCustomerDepartment').combobox({data: ret, valueField: 'id', textField: 'departmentName', value: ret[0].id});   
               },
               error: function(data) {
                
               }
             });
           }
         }
  	   ">
  </select>
  科室：
  <select class="easyui-combobox" id="searchCustomerDepartment" panelHeight="auto" style="width:100px">
  </select>
  分组：
  <select class="easyui-combobox" id="searchCustomerGroup" panelHeight="auto" style="width:100px"
  		 data-options="
  		 url:'${ctx}/api/v1/group/listAllCustomerGroupIncludeAll',
  		 method:'get',
  		 valueField:'id',
  		 textField:'name',
  		 value:'-1'
  		 ">
  </select>
  身份:
  <select class="easyui-combobox" id="searchCustomerType" panelHeight="auto" style="width:100px"
  		 data-options="
  		 data:[{value:-1,type:'所有'},{value:0,type:'医生'},{value:1,type:'护士'}],
  		 valueField:'value',
  		 textField:'type',
  		 value:'-1'
  		 ">
  </select>
  状态：
  <select class="easyui-combobox" id="searchGiftGroup" panelHeight="auto" style="width:100px"
  		 data-options="
  		 data:[{value:-1,status:'所有'},{value:0,status:'未确认'},{value:1,status:'已确认'}],
  		 valueField:'value',
  		 textField:'status',
  		 value:'-1'
  		 ">
  </select>
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
function rowFormater_type(value,row,index){
	switch(Number(value)){
		case -1:
		return '未确认'
		case 1:
		return '医生'
		case 2:
		return '护士'
	}
}
function rowFormater_action(value,row,index){
	if(!!value){
		var btns="<a class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\" onClick=\"edit()\">修改</a>"
			btns+="<a class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\" onClick=\"confirm('真的要删除码？')\">删除</a>"
		return btns
	}else{
		return ""
	}
}


function add(){
	qDialog({
		href:'${ctx}/inc/cust/inc_cust_list_add',
		title:'新建',
		iconCls:'icon-add',
		width:540,
		height:340,
		buttons:[{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){
					qDialog({closed:true});
			}
		},{
			text:'关闭',
			iconCls:'icon_delete',
			handler:function(){
					qDialog({closed:true});
			}
		}]
	})
	
}

function edit(id){
	qDialog({
		href:'${ctx}/inc/cust/inc_cust_list_edit?id='+id,
		title:'修改',
		iconCls:'icon-edit',
		width:750,
		height:466,
		buttons:[{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){
					qDialog({closed:true});
			}
		},{
			text:'关闭',
			iconCls:'icon_delete',
			handler:function(){
					qDialog({closed:true});
			}
		}]
	})
	
}
</script>
