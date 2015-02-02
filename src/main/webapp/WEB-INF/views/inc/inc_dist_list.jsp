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
            url:'../data/data_dist_list.json',method:'get'
            ">
  <thead>
    <tr>
      <th data-options="field:'ck',checkbox:true"></th>
      <th data-options="field:'lab_01',width:120,align:'center',formatter:rowFormater_action">操作</th>
      <th data-options="field:'lab_02',width:100,align:'center'">经销商名称</th>
      <th data-options="field:'lab_03',width:80,align:'center'">经销商电话</th>
      <th data-options="field:'lab_04',width:160,align:'center'">所属代表</th>
      <th data-options="field:'lab_05',width:120,align:'left'">最后登录时间</th>
    </tr>
  </thead>
</table>
<div id="gridTools_inc_dist_list" style="padding:5px;height:auto">
  <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">新增</a>
  <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
  
  <div class="separator"/>
  
  <input class="easyui-validatebox" name="" type="text" style="width:180px" placeholder="姓名/医院/科室/身份/状态/分组">
  
  <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search">搜索</a>
</div>
<script>
function rowFormater_action(value,row,index){
	if(!!value){
		var btns="<a class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\" onClick=\"edit()\">修改</a>"
			btns+="<a class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\" onClick=\"confirm('真的要停用码？')\">停用</a>"
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
		href:'${ctx}/inc/dist/inc_dist_list_edit',
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
