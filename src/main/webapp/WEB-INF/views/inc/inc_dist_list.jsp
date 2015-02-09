<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<table id="grid_inc_dist_list" class="easyui-datagrid"
			data-options="
            toolbar:'#gridTools_inc_dist_list',
            fit:true,
            border:false,
            singleSelect:true,
            fitColumns: true,
            collapsible:true,
            onLoadSuccess:dataGridOnloadSuccess,
            pagination:true,
            url:'${ctx}/api/v1/dist',method:'get'
            ">
  <thead>
    <tr>
      <th data-options="field:'ck',checkbox:true"></th>
      <th data-options="field:'opt',width:120,align:'center',formatter:rowFormater_action">操作</th>
      <th data-options="field:'name',width:100,align:'center'">经销商名称</th>
      <th data-options="field:'phone',width:80,align:'center'">经销商电话</th>
      <th data-options="field:'email',width:80,align:'center'">经销商电子邮箱</th>
      <th data-options="field:'description',width:160,align:'center'">经销商备注</th>
      <th data-options="field:'lastLoginDate',width:120,align:'left'">最后登录时间</th>
    </tr>
  </thead>
</table>
<div id="gridTools_inc_dist_list" style="padding:5px;height:auto">
  <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">新增</a>
  <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
  
  <div class="separator"/>
  
  <input class="easyui-validatebox" name="searchSupplierName" id="searchSupplierName" type="text" style="width:180px" placeholder="姓名/电话/邮箱">
  
  <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search" onClick="searchSupplier()">搜索</a>
</div>
<script>
function rowFormater_action(value,row,index){
	if(!!value){
		var btns="<a class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\" onClick=\"edit('" + value + "')\">修改</a>"
			btns+="<a class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\" onClick=\"del('" + value + "')\">停用</a>"
		return btns
	}else{
		return ""
	}
}


function add(){
	qDialog({
		href:'${ctx}/inc/dist/inc_dist_list_add',
		title:'新建',
		iconCls:'icon-add',
		width:540,
		height:340,
		buttons:[{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){
				$('#createSupplierForm').form('submit', {
					url: '${ctx}/api/v1/dist/create',
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

function edit(id){
	qDialog({
		href:'${ctx}/inc/dist/inc_dist_list_edit?supplierId=' + id,
		title:'修改',
		iconCls:'icon-edit',
		width:750,
		height:466,
		buttons:[{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){
				$('#createSupplierForm').form('submit', {
					url: '${ctx}/api/v1/dist/update',
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

function del(id){
	if(confirm('真的要删除码？')) {
		$.ajax({
			url : '${ctx}/api/v1/dist/delete',
	        data:{'supplierId':id},
	        cache : false,
	        async : false,
	        type : "POST",
	        dataType : 'json',
	        success : function (result){
	           if (result == '1') {
	        	   alert("删除成功");
	        	   $('#grid_inc_dist_list').datagrid('load');
	           }
	        },
	        error: function(data) {
	        	alert("删除失败");
	        	$('#grid_inc_dist_list').datagrid('load');
	        }
		});
	}
}

function searchSupplier() {
	var searchSupplierName = $('#searchSupplierName').val();
	$('#grid_inc_dist_list').datagrid(
		'load', 
		{
			'supplierName' : searchSupplierName
		});
}
</script>
