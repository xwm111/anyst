<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<table id="grid_inc_flowe_list" class="easyui-datagrid"
			data-options="
            toolbar:'#gridTools_inc_flowe_list',
            fit:true,
            border:false,
            singleSelect:true,
            collapsible:true,
            onLoadSuccess:dataGridOnloadSuccess,
            pagination:true,
            url:'../data/data_flowe_list.json',method:'get'
            ">
  <thead>
    <tr>
      <th data-options="field:'ck',checkbox:true"></th>
      <th data-options="field:'lab_00',width:100,align:'center'">贴花ID</th>
      <th data-options="field:'lab_01',width:160,align:'center',formatter:rowFormater_action">操作</th>
      <th data-options="field:'lab_02',width:160">贴花名称</th>
      <th data-options="field:'lab_03',width:80,align:'center',formatter:rowFormater_state">状态</th>
      <th data-options="field:'lab_04',width:100,align:'center',formatter:rowFormater_pic">产品贴花图片</th>
    </tr>
  </thead>
</table>
<div id="gridTools_inc_flowe_list" style="padding:5px;height:auto">
  <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addFlowe()">新增</a>
  <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
  
  <div class="separator"/>
  
  名称：
  <input class="easyui-validatebox" name="" type="text" style="width:80px">
  编号：
  <input class="easyui-validatebox" name="" type="text" style="width:80px">
  分类：
  <select class="easyui-combobox" panelHeight="auto" style="width:100px">
    <option value="">所有</option>
    <option value="">已绑定</option>
    <option value="">未绑定</option>
  </select>
  <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search">搜索</a>
</div>
<script>
function rowFormater_pic(value,row,index){
	if(!!!value) return "尚无图片"
	var picArr=value.split("|");
	if(picArr.length>0){
		return "有图片("+picArr.length+")"
	}else{
		return "尚无图片"
	}
}

function rowFormater_action(value,row,index){
	if(!!value){
		var btns="<a class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\" onClick=\"editFlowe()\">修改</a>"
			btns+="<a class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\" onClick=\"confirm('真的要删除码？')\">删除</a>"
		return btns
	}else{
		return ""
	}
}
function rowFormater_state(value,row,index){
	if(Number(value)==1){
		var btns="<a class=\"easyui-linkbutton\" plain=\"true\">已经使用</a>"
		return btns
	}else{
		var btns="<a class=\"easyui-linkbutton\" plain=\"true\">未使用</a>"
		return btns
	}
}


function addFlowe(){
	qDialog({
		href:'${ctx}/inc/basi/inc_flowe_list_add',
		title:'新建',
		iconCls:'icon-add',
		width:750,
		height:382,
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

function editFlowe(){
	qDialog({
		href:'${ctx}/inc/basi/inc_flowe_list_edit',
		title:'修改',
		iconCls:'icon-edit',
		width:750,
		height:382,
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
