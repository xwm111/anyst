﻿<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<table id="grid_inc_serv_list" class="easyui-datagrid"
			data-options="
            toolbar:'#gridTools_inc_serv_list',
            fit:true,
            border:false,
            singleSelect:true,
            fitColumns: true,
            singleSelect: true,
            collapsible:true,
            onLoadSuccess:dataGridOnloadSuccess,
            pagination:true,
            url:'../data/data_serv_list.json',method:'get'
            ">
  <thead>
    <tr>
      <th data-options="field:'ck',checkbox:true"></th>
      <th data-options="field:'lab_01',width:120,align:'center',formatter:rowFormater_action">操作</th>
      <th data-options="field:'lab_02',width:100,align:'center'">客服名称</th>
      <th data-options="field:'lab_03',width:80,align:'center'">客服帐号</th>
      <th data-options="field:'lab_04',width:160,align:'center'">客服电话</th>
      <th data-options="field:'lab_05',width:120,align:'left'">最后登录时间</th>
      <th data-options="field:'lab_06',width:80,align:'center',formatter:rowFormater_state">状态</th>
    </tr>
  </thead>
</table>
<div id="gridTools_inc_serv_list" style="padding:5px;height:auto">
  <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">新增</a>
  <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
  
  <div class="separator"/>
  
  <input class="easyui-validatebox" name="" type="text" style="width:180px" placeholder="名称/电话">
  
  <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search">搜索</a>
</div>
<script>
function rowFormater_state(value,row,index){
	switch(Number(value)){
		case 0:
		return '已经停用'
		case 1:
		return '正常'
	}
}
function rowFormater_action(value,row,index){
	if(!!value){
		switch(row["lab_06"]){
			case 0:
				var btns="<a class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\">启用</a>"
			return btns
			case 1:
				var btns="<a class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\">停用</a>"
			return btns
		}
	}else{
		return ""
	}
}


function add(){
	qDialog({
		href:'${ctx}/inc/serv/inc_serv_list_add',
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

function edit(){
	qDialog({
		href:'${ctx}/inc/serv/inc_serv_list_edit',
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
