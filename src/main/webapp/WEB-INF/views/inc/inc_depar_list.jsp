<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<table id="grid_inc_depar_list" class="easyui-treegrid" style="width:700px;height:250px"
			data-options="
            	toolbar:'#gridTools_inc_depar_list',
				rownumbers: true,
				animate: true,
				collapsible: true,
				fitColumns: true,
				url: '${ctx}/api/v1/depar',
            	onLoadSuccess:dataGridOnloadSuccess,
				method: 'get',
				idField: 'id',
				treeField: 'name',
                fit:true,
                border:false
			">
		<thead>
			<tr>
     			<th data-options="field:'ck',checkbox:true"></th>
				<th data-options="field:'name',width:180">医院/科室名称</th>
      			<th data-options="field:'id',width:120,align:'center',formatter:rowFormater_action">操作</th>
			</tr>
		</thead>
	</table>
<div id="gridTools_inc_depar_list" style="padding:5px;height:auto">
  <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addHospital()">新增医院</a>
  <!--
  <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a> 
  <div class="separator"/>
  
  <input class="easyui-validatebox" name="" type="text" style="width:180px" placeholder="关键字">
  
  <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search">搜索</a>
   -->
</div>
<script>
function rowFormater_action(value,row,index){
	if(!!row._parentId){
		var btns="<a class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\" onClick=\"editDepartment('" + value + "')\">修改</a>"
			btns+="<a class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\" onClick=\"delDepartment('" + value + "')\">删除</a>"
	}else{
		var btns="<a class=\"easyui-linkbutton\" iconCls=\"icon-add\" plain=\"true\" onClick=\"addDepartment('" + value + "')\">新增科室</a>"
			btns+="<a class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\" onClick=\"editHospital('" + value + "')\">修改</a>"
			btns+="<a class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\" onClick=\"delHospital('" + value + "')\">删除</a>"
	}
	return btns
}


function addDepartment(id){
	var hospitalId = id.substring(1);
	qDialog({
		href:'${ctx}/inc/basi/inc_depar_list_add_department_infos?hospitalId=' + hospitalId,
		title:'新建部门',
		iconCls:'icon-add',
		width:540,
		height:340,
		buttons:[{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){
				$('#createDepartmentForm').form('submit', {
					url: '${ctx}/api/v1/depar/createDepartment',
					onSubmit: function() {
						return true;
					},
					success:function(data) {
						alert("成功");
						$('#grid_inc_depar_list').treegrid('reload');
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

function editDepartment(id){
	var departmentId = id.substring(1);
	qDialog({
		href:'${ctx}/inc/basi/inc_depar_list_edit_department_infos?departmentId=' + departmentId,
		title:'修改部门',
		iconCls:'icon-edit',
		width:750,
		height:466,
		buttons:[{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){
				$('#createDepartmentForm').form('submit', {
					url: '${ctx}/api/v1/depar/updateDepartment',
					onSubmit: function() {
						return true;
					},
					success:function(data) {
						alert("成功");
						$('#grid_inc_depar_list').treegrid('reload');
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

function addHospital(){
	qDialog({
		href:'${ctx}/inc/basi/inc_depar_list_add_hospital_infos',
		title:'新建医院',
		iconCls:'icon-add',
		width:540,
		height:340,
		buttons:[{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){
				$('#createHospitalForm').form('submit', {
					url: '${ctx}/api/v1/depar/createHospital',
					onSubmit: function() {
						return true;
					},
					success:function(data) {
						alert("成功");
						$('#grid_inc_depar_list').treegrid('reload');
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

function editHospital(id) {
	var realId = id.substring(1);
	qDialog({
		href:'${ctx}/inc/basi/inc_depar_list_edit_hospital_infos?hospitalId=' + realId,
		title:'修改医院',
		iconCls:'icon-edit',
		width:750,
		height:466,
		buttons:[{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){
				$('#createHospitalForm').form('submit', {
					url: '${ctx}/api/v1/depar/updateHospital',
					onSubmit: function() {
						return true;
					},
					success:function(data) {
						alert("成功");
						$('#grid_inc_depar_list').treegrid('reload');
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

function delDepartment(id) {
	var departmentId = id.substring(1);
	if(confirm('真的要删除码？')) {
		$.ajax({
			url : '${ctx}/api/v1/depar/deleteDepartment?departmentId=' + departmentId,
	        data:{'customerGroupId':id},
	        cache : false,
	        async : false,
	        type : "POST",
	        dataType : 'json',
	        success : function (data){
	    	   	alert("删除成功");
	    	   	$('#grid_inc_depar_list').treegrid('reload');
	        },
	        error: function(data) {
	        	alert("删除失败: " + data);
	        }
		});
	}
}

function delHospital(id) {
	var hospitalId = id.substring(1);
	if(confirm('真的要删除码？')) {
		$.ajax({
			url : '${ctx}/api/v1/depar/deleteHospital?hospitalId=' + hospitalId,
	        data:{'customerGroupId':id},
	        cache : false,
	        async : false,
	        type : "POST",
	        dataType : 'json',
	        success : function (data){
	    	   	alert("删除成功");
	    	   	$('#grid_inc_depar_list').treegrid('reload');
	        },
	        error: function(data) {
	        	alert("删除失败: " + data);
	        }
		});
	}
}
</script>
