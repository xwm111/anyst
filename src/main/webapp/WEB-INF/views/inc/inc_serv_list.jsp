<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            url:'${ctx}/api/v1/serv',method:'get'
            ">
  <thead>
    <tr>
      <th data-options="field:'ck',checkbox:true"></th>
      <th data-options="field:'opt',width:120,align:'center',formatter:rowFormater_action">操作</th>
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
  <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search" onClick="searchService()">搜索</a>
</div>
<script>
function rowFormater_state(value,row,index){
	switch(Number(value)){
		case 0:
		btns='<a class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\" onClick=shiftOn(\"' + row['opt'] + ')\">停用</a>'
		return btns;
		case 1:
		btns='<a class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\" onClick=shiftOff(\"' + row['opt'] + ')\">正常</a>'
		return '正常'
	}
}
function rowFormater_action(value,row,index){
	if(!!value){
		var btns="<a class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\" onClick=edit(\"' + value + ')\">修改</a>"
		btns+="<a class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\" onClick=del(\"' + value + ')\">删除</a>"	
		return btns
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
				$('#createServiceForm').form('submit', {
					url: '${ctx}/api/v1/serv/create',
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
		href:'${ctx}/inc/serv/inc_serv_list_edit?serviceId=' + id,
		title:'修改',
		iconCls:'icon-edit',
		width:750,
		height:466,
		buttons:[{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){
				$('#createServiceForm').form('submit', {
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

function del(id){
	if(confirm('真的要删除码？')) {
		$.ajax({
			url : '${ctx}/api/v1/serv/delete',
	        data:{'serviceId':id},
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

function shiftOn(id){
	$.ajax({
		url : '${ctx}/api/v1/serv/shiftOn',
        data:{'serviceId':id},
        cache : false,
        async : false,
        type : "POST",
        dataType : 'json',
        success : function (data){
    	   	alert("启用成功");
        },
        error: function(data) {
        	alert("启用失败: " + data);
        }
	});
}

function shiftOff(id){
	$.ajax({
		url : '${ctx}/api/v1/serv/shiftOff',
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

function searchService(){
	var searchName = $('#')

}
</script>
