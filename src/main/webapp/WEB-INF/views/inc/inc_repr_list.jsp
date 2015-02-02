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
            url:'../data/data_repr_list.json',method:'get'
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
  <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
  <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onClick="relation()">产品/客户关联</a>
  
  <div class="separator"/>
  
  <input class="easyui-validatebox" name="" type="text" style="width:180px" placeholder="名称/所属经销商/电话">
  
  <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search">搜索</a>
</div>
<script>
function rowFormater_action(value,row,index){
	if(!!value){
		var btns="<a class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\" onClick=\"edit()\">修改</a>"
			btns+="<a class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\" onClick=\"confirm('真的要停用码？')\">停用</a>"
			btns+="<a class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\" onClick=\"relation()\">产品/客户关联</a>"
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
		href:'${ctx}/inc/repr/inc_repr_list_edit',
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

function relation(){
	qDialog({
		href:'${ctx}/inc/repr/inc_repr_list_relation',
		title:'修改',
		iconCls:'icon-edit',
		width:1000,
		height:580,
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
