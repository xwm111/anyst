<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<table id="grid_inc_group_list" class="easyui-datagrid"
	data-options="
            toolbar:'#gridTools_inc_group_list',
            fit:true,
            border:false,
            singleSelect:true,
            fitColumns: true,
            singleSelect: true,
            collapsible:true,
            showFooter: true,
            onLoadSuccess:dataGridOnloadSuccess,
            pagination:true,
            url:'${ctx}/api/v1/group',
            method:'get'
            ">
	<thead>
		<tr>
			<th data-options="field:'ck',checkbox:true"></th>
			<th
				data-options="field:'opt',width:120,align:'center',formatter:rowFormater_action">操作</th>
			<th data-options="field:'name',width:100,align:'center'">分组名称</th>
			<th data-options="field:'num',width:80,align:'center'">用户数</th>
			<th data-options="field:'description',width:160,align:'left'">备注</th>
		</tr>
	</thead>
</table>
<div id="gridTools_inc_group_list" style="padding: 5px; height: auto">
	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true"
		onclick="addGroup()">新增</a> <a href="#" class="easyui-linkbutton"
		iconCls="icon-remove" plain="true">删除</a>

	<div class="separator" />

	<input class="easyui-validatebox" name="searchGroupName" id="searchGroupName" type="text"
		style="width: 180px" placeholder="关键字"> <a href="#"
		class="easyui-linkbutton" plain="true" iconCls="icon-search" onClick="searchGroup()">搜索</a>
</div>
<script>

function rowFormater_action(value,row,index){
	if(!!value){
		if(value=='&Sigma;'){
			return "&Sigma; 统计："
		}else{
			var btns="<a class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\" onClick=\"editGroup('" + value + "')\">修改</a>"
				btns+="<a class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\" onClick=\"delGroup('" + value + "')\">删除</a>"
			return btns
		}
	}
}


function addGroup(){
	qDialog({
		href:'${ctx}/inc/basi/inc_group_list_add',
		title:'新建',
		iconCls:'icon-add',
		width:540,
		height:340,
		buttons:[{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){
				$('#createGroupForm').form('submit', {
					url: '${ctx}/api/v1/group/create',
					onSubmit: function() {
						return true;
					},
					success:function(data) {
						alert("成功");
					}
				});
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

function editGroup(data){
	qDialog({
		href:'${ctx}/inc/basi/inc_group_list_edit?customerGroupId=' + data,
		title:'修改',
		iconCls:'icon-edit',
		width:750,
		height:466,
		buttons:[{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){
				$('#createGroupForm').form('submit', {
					url: '${ctx}/api/v1/group/update',
					onSubmit: function() {
						return true;
					},
					success:function(data) {
						alert("成功");
					}
				});
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

function delGroup(id) {
	if(confirm('真的要删除码？')) {
		$.ajax({
			url : '${ctx}/api/v1/group/delete',
	        data:{'customerGroupId':id},
	        cache : false,
	        async : false,
	        type : "POST",
	        dataType : 'json',
	        success : function (data){
        	   	alert("删除成功");
	        },
	        error: function(data) {
	        	alert("删除失败: " + data);
	        }
		});
	}
}

function searchGroup() {
	var customerGroupName = $('#searchGroupName').val();
	$('#grid_inc_group_list').datagrid(
			'load', 
			{
				'customerGroupName' : customerGroupName,
			});
}
</script>
