<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<table id="grid_inc_gift_list" class="easyui-datagrid"
			data-options="
            toolbar:'#gridTools_inc_gift_list',
            fit:true,
            border:false,
            singleSelect:true,
            collapsible:true,
            onLoadSuccess:dataGridOnloadSuccess,
            pagination:true,
            url:'${ctx}/api/v1/gift',method:'get'
            ">
  <thead>
    <tr>
      <th data-options="field:'ck',checkbox:true"></th>
      <th data-options="field:'lab_00',width:100,align:'center'">礼品编号</th>
      <th data-options="field:'lab_01',width:160,align:'center',formatter:rowFormater_action">操作</th>
      <th data-options="field:'lab_02',width:160">礼品名称</th>
      <th data-options="field:'lab_10',width:80,align:'center',formatter:rowFormater_state">状态</th>
      <th data-options="field:'lab_03',width:60,align:'center'">礼品分类</th>
      <th data-options="field:'lab_04',width:60,align:'center'">所属产品</th>
      <th data-options="field:'lab_05',width:220">礼品简介</th>
      <th data-options="field:'lab_06',width:80,align:'right',formatter:rowFormater_money">成本价</th>
      <th data-options="field:'lab_07',width:80,align:'right',formatter:rowFormater_money">市场价</th>
      <th data-options="field:'lab_08',width:100,align:'center',formatter:rowFormater_pic">产品贴花图片</th>
      <th data-options="field:'lab_09',width:60,align:'right',formatter:rowFormater_units">兑换比</th>
    </tr>
  </thead>
</table>
<div id="gridTools_inc_gift_list" style="padding:5px;height:auto">
  <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">新增</a>
  <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
  
  <div class="separator"/>
  
  名称：
  <input class="easyui-validatebox" name="" type="text" style="width:80px">
  编号：
  <input class="easyui-validatebox" name="" type="text" style="width:80px">
  分类：
  <select class="easyui-combobox" panelHeight="auto" style="width:100px"
  		 data-options="
  		 url:'${ctx}/api/v1/class/listAllGiftGroupIncludeAll',
  		 method:'get',
  		 valueField:'id',
  		 textField:'name',
  		 value:'-1'
  		 ">
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
function rowFormater_units(value,row,index){
	return value+" 个"
}
function rowFormater_money(value,row,index){
	return "￥ "+value+" 元"
}
function rowFormater_action(value,row,index){
	if(!!value){
		var btns="<a class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\" onClick=\"edit('" + value + "')\">修改</a>"
			btns+="<a class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\" onClick=\"del('" + value + "')\">删除</a>"
		return btns
	}else{
		return ""
	}
}
function rowFormater_state(value,row,index){
	if(Number(value)==1){
		var btns="<a class=\"easyui-linkbutton\" plain=\"true\" onClick=\"edit()\">上架</a>"
		return btns
	}else{
		var btns="<a class=\"easyui-linkbutton\" plain=\"true\" onClick=\"edit()\">下架</a>"
		return btns
	}
}

function add(){
	qDialog({
		href:'${ctx}/inc/gift/inc_gift_list_add',
		title:'新建',
		iconCls:'icon-add',
		width:750,
		height:466,
		buttons:[{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){
				$('#createGiftForm').form('submit', {
					url: '${ctx}/api/v1/gift/create',
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

function edit(data){
	qDialog({
		href:'${ctx}/inc/gift/inc_gift_list_edit?giftId=' + data,
		title:'修改',
		iconCls:'icon-edit',
		width:750,
		height:466,
		buttons:[{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){
				$('#createGiftForm').form('submit', {
					url: '${ctx}/api/v1/gift/update',
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

function del(code){
	
}

function searchProduct() {
	var giftName = $('#giftName').val();
	var giftCode = $('#giftCode').val();
	var giftGroup = $("#giftGroup").combobox('getValue');
	$('#grid_inc_gift_list').datagrid(
			'load', 
			{
				'giftName' : giftName,
				'giftCode' : giftCode,
				'giftGroup' : giftGroup
			});
}
</script>
