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
      <th data-options="field:'code',width:100,align:'center'">礼品编号</th>
      <th data-options="field:'opt',width:160,align:'center',formatter:rowFormater_action">操作</th>
      <th data-options="field:'giftName',width:160">礼品名称</th>
      <th data-options="field:'status',width:80,align:'center',formatter:rowFormater_state">状态</th>
      <th data-options="field:'giftGroupName',width:60,align:'center'">礼品分类</th>
      <th data-options="field:'productName',width:60,align:'center'">所属产品</th>
      <th data-options="field:'giftDiscribe',width:220">礼品简介</th>
      <th data-options="field:'giftCost',width:80,align:'right',formatter:rowFormater_money">成本价</th>
      <th data-options="field:'giftPrice',width:80,align:'right',formatter:rowFormater_money">市场价</th>
      <th data-options="field:'imgUrls',width:100,align:'center',formatter:rowFormater_pic">礼品图片</th>
      <th data-options="field:'tapImgUrls',width:100,align:'center',formatter:rowFormater_pic">产品贴花图片</th>
      <th data-options="field:'exchangeValue',width:60,align:'right',formatter:rowFormater_units">兑换比</th>
    </tr>
  </thead>
</table>
<div id="gridTools_inc_gift_list" style="padding:5px;height:auto">
  <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">新增</a>
  <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
  
  <div class="separator"/>
  
  名称：
  <input class="easyui-validatebox" name="searchGiftName" id="searchGiftName" type="text" style="width:80px">
  编号：
  <input class="easyui-validatebox" name="searchGiftCode" id="searchGiftCode" type="text" style="width:80px">
  分类：
  <select class="easyui-combobox" id="searchGiftGroup" panelHeight="auto" style="width:100px"
  		 data-options="
  		 url:'${ctx}/api/v1/class/listAllGiftGroupIncludeAll',
  		 method:'get',
  		 valueField:'id',
  		 textField:'name',
  		 value:'-1'
  		 ">
  </select>
  状态：
  <select class="easyui-combobox" id="searchGiftStatus" panelHeight="auto" style="width:100px">
  	<option value="-1">所有</option>
    <option value="1">上架</option>
    <option value="0">下架</option>
  </select>
  <a href="#" class="easyui-linkbutton" plain="true" onClick="searchGift()" iconCls="icon-search">搜索</a>
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
		var btns="<a class=\"easyui-linkbutton\" plain=\"true\" onClick=\"shiftOff('" + index + "')\">下架</a>"
		return btns
	}else{
		var btns="<a class=\"easyui-linkbutton\" plain=\"true\" onClick=\"shiftOn('" + index + "')\">上架</a>"
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
		href:'${ctx}/inc/gift/inc_gift_list_edit?giftCode=' + data,
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
	if(confirm('真的要删除码？')) {
		$.ajax({
			url : '${ctx}/api/v1/gift/delete',
	        data:{'giftCode':code},
	        cache : false,
	        async : false,
	        type : "POST",
	        dataType : 'json',
	        success : function (result){
	           if (result == '1') {
	        	   alert("删除成功");
	        	   $('#grid_inc_gift_list').datagrid('load');
	           }
	        },
	        error: function(data) {
	        	alert("删除失败");
	        	$('#grid_inc_gift_list').datagrid('load');
	        }
		});
	}
}

function searchGift() {
	var giftName = $('#searchGiftName').val();
	var giftCode = $('#searchGiftCode').val();
	var giftGroup = $("#searchGiftGroup").combobox('getValue');
	var giftStatus = $("#searchGiftStatus").combobox('getValue');
	$('#grid_inc_gift_list').datagrid(
		'load', 
		{
			'giftName' : giftName,
			'giftCode' : giftCode,
			'giftGroup' : giftGroup,
			'giftStatus' : giftStatus
		});
}

function shiftOff(row) {
	var rows = $('#grid_inc_gift_list').datagrid('getRows');
	var code = rows[row].code;
	$.ajax({
		url : '${ctx}/api/v1/gift/shiftOff',
        data:{'giftCode':code},
        cache : false,
        async : false,
        type : "POST",
        dataType : 'json',
        success : function (result){
           if (result == '1') {
        	   alert("下架成功");
        	   $('#grid_inc_gift_list').datagrid('load');
           }
        },
        error: function(data) {
        	alert("下架失败");
        	$('#grid_inc_gift_list').datagrid('load');
        }
	});
}

function shiftOn(row) {
	var rows = $('#grid_inc_gift_list').datagrid('getRows');
	var code = rows[row].code;
	$.ajax({
		url : '${ctx}/api/v1/gift/shiftOn',
        data:{'giftCode':code},
        cache : false,
        async : false,
        type : "POST",
        dataType : 'json',
        success : function (result){
           if (result == '1') {
        	   alert("上架成功");
        	   $('#grid_inc_gift_list').datagrid('load');
           }
        },
        error: function(data) {
        	alert("上架失败");
        	$('#grid_inc_gift_list').datagrid('load');
        }
	});
}
</script>
