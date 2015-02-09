<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<table id="grid_inc_dist_list" class="easyui-datagrid"
			data-options="
            toolbar:'#gridTools_inc_repr_list',
            fit:true,
            border:false,
            singleSelect:true,
            fitColumns: true,
            collapsible:true,
            onLoadSuccess:dataGridOnloadSuccess,
            pagination:true,
            url:'${ctx}/api/v1/repr',method:'get'
            ">
  <thead>
    <tr>
      <th data-options="field:'ck',checkbox:true"></th>
      <th data-options="field:'lab_01',width:120,align:'center',formatter:rowFormater_action">操作</th>
      <th data-options="field:'lab_02',width:100,align:'center'">代表名称</th>
      <th data-options="field:'lab_03',width:80,align:'center'">电话</th>
      <th data-options="field:'lab_04',width:160,align:'center'">所属经销商</th>
    </tr>
  </thead>
</table>
<div id="gridTools_inc_repr_list" style="padding:5px;height:auto">
  <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">新增</a>
  <div class="separator"/>
  <input class="easyui-validatebox" name="" type="text" style="width:180px" placeholder="名称/所属经销商/电话">
  <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search" onClick="searchRepresentor()">搜索</a>
</div>
<script>
function rowFormater_action(value,row,index){
	if(!!value){
		var btns="<a class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\" onClick=\"edit('" + value + "')\">修改</a>"
			btns+="<a class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\" onClick=\"del('" + value + "')\">停用</a>"
			btns+="<a class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\" onClick=\"relation('" + value + "')\">产品/客户关联</a>"
		return btns
	}else{
		return ""
	}
}

function add(){
	qDialog({
		href:'${ctx}/inc/repr/inc_repr_list_add',
		title:'新建',
		iconCls:'icon-add',
		width:540,
		height:340,
		buttons:[{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){
				$('#createRepresentorForm').form('submit', {
					url: '${ctx}/api/v1/serv/update',
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
		href:'${ctx}/inc/repr/inc_repr_list_edit?' + id,
		title:'修改',
		iconCls:'icon-edit',
		width:750,
		height:466,
		buttons:[{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){
				$('#createRepresentorForm').form('submit', {
					url: '${ctx}/api/v1/serv/update',
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

function relation(id){
	qDialog({
		href:'${ctx}/inc/repr/inc_repr_list_relation？' + id,
		title:'修改',
		iconCls:'icon-edit',
		width:1000,
		height:580,
		buttons:[{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){
				var customerSelection = $('#grid_inc_repr_list_relation_custList');
				var productSelection = $('#grid_inc_repr_list_relation_prodList');
				$.ajax({
					url : '${ctx}/api/v1/repr/relationUpdate',
			        data:{'serviceId':id},
			        cache : false,
			        async : false,
			        type : "POST",
			        dataType : 'json',
			        success : function (data){
			    	   	alert("停用成功");
			        },
			        error: function(data) {
			        	alert("停用失败: " + data);
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
	$.ajax({
		url : '${ctx}/api/v1/repr/delete',
        data:{'serviceId':id},
        cache : false,
        async : false,
        type : "POST",
        dataType : 'json',
        success : function (data){
    	   	alert("停用成功");
        },
        error: function(data) {
        	alert("停用失败: " + data);
        }
	});
}

function searchRepresentor(){
	
}
</script>
