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
            url:'${ctx}/api/v1/tap',method:'get'
            ">
  <thead>
    <tr>
      <th data-options="field:'ck',checkbox:true"></th>
      <th data-options="field:'code',width:100,align:'center'">贴花ID</th>
      <th data-options="field:'opt',width:160,align:'center',formatter:rowFormater_action">操作</th>
      <th data-options="field:'name',width:160">贴花名称</th>
      <th data-options="field:'status',width:80,align:'center',formatter:rowFormater_state">状态</th>
      <th data-options="field:'imgUrl',width:100,align:'center',formatter:rowFormater_pic">产品贴花图片</th>
    </tr>
  </thead>
</table>
<div id="gridTools_inc_flowe_list" style="padding:5px;height:auto">
  <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addFlowe()">新增</a>
  <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
  
  <div class="separator"/>
  
  名称：
  <input class="easyui-validatebox" name="searchTapName" id="searchTapName" type="text" style="width:80px">
  编号：
  <input class="easyui-validatebox" name="searchTapCode" id="searchTapCode" type="text" style="width:80px">
  状态：
  <select class="easyui-combobox" name="searchTapStatus" id="searchTapStatus" panelHeight="auto" style="width:100px">
    <option value="-1">所有</option>
    <option value="1">使用</option>
    <option value="0">未使用</option>
  </select>
  <a href="#" class="easyui-linkbutton" plain="true" onClick="searchFlowe()" iconCls="icon-search">搜索</a>
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
		var btns="<a class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\" onClick=\"editFlowe('" + value + "')\">修改</a>"
			btns+="<a class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\" onClick=\"delFlowe('" + value + "')\">删除</a>"
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
				$('#createTapForm').form('submit', {
					url: '${ctx}/api/v1/tap/create',
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

function editFlowe(id){
	qDialog({
		href:'${ctx}/inc/basi/inc_flowe_list_edit?tapCode=' + id,
		title:'修改',
		iconCls:'icon-edit',
		width:750,
		height:382,
		buttons:[{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){
				$('#createTapForm').form('submit', {
					url: '${ctx}/api/v1/tap/update',
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

function delFlowe(id) {
	if(confirm('真的要删除码？')) {
		$.ajax({
			url : '${ctx}/api/v1/tap/delete',
	        data:{'tapCode':id},
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

function searchFlowe() {
	var searchTapName = $('#searchTapName').val();
	var searchTapCode = $('#searchTapCode').val();
	var searchTapStatus=$("#searchTapStatus").combobox('getValue');
	alert(searchTapStatus);
	$('#grid_inc_flowe_list').datagrid(
			'load', 
			{
				'tapName' : searchTapName,
				'tapCode' : searchTapCode,
				'tapStatus' : searchTapStatus
			});
}
</script>
