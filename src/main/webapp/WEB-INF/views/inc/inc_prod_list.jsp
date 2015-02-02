<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<table id="grid_inc_equipment_list" class="easyui-datagrid"
			data-options="
            toolbar:'#gridTools_inc_milkman_list',
            fit:true,
            border:false,
            singleSelect:true,
            fitColumns: true,
            singleSelect: true,
            collapsible:true,
            onLoadSuccess:dataGridOnloadSuccess,
            pagination:true,
            url:'${ctx}/api/v1/product',method:'get'
            ">
  <thead>
    <tr>
      <th data-options="field:'ck',checkbox:true"></th>
      <th data-options="field:'code',width:40,align:'center'">产品编号</th>
      <th data-options="field:'opt',width:120,align:'center',formatter:rowFormater_action">操作</th>
      <th data-options="field:'name',width:120">产品名称</th>
      <th data-options="field:'description',width:120">产品简介</th>
      <th data-options="field:'productImgUrls',width:60,align:'center',formatter:rowFormater_pic">产品宣传图片</th>
      <th data-options="field:'tapImgUrls',width:60,align:'center',formatter:rowFormater_pic">产品贴花图片</th>
    </tr>
  </thead>
</table>
<div id="gridTools_inc_milkman_list" style="padding:5px;height:auto">
  <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">新增</a>
  <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
  
  <div class="separator"/>
  
  名称：
  <input class="easyui-validatebox" id="searchProductName" name="productName" type="text" style="width:80px">
  编号：
  <input class="easyui-validatebox" id="searchProductCode" name="productCode" type="text" style="width:80px">
  分类：
  <select class="easyui-combobox" id="searchProductStatus" panelHeight="auto" name="productStatus" style="width:100px">
    <option value="-1">所有</option>
    <option value="0">已绑定</option>
    <option value="1">未绑定</option>
  </select>
  <a class="easyui-linkbutton" plain="true" iconCls="icon-search" onClick="searchProduct()">搜索</a>
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
		var btns="<a class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\" onClick=\"edit('" + value + "')\">修改</a>"
			btns+="<a class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\" onClick=\"del('" + value + "')\">删除</a>"
		return btns
	}else{
		return ""
	}
}

function add(){
	qDialog({
		href:'${ctx}/inc/product/inc_prod_list_add',
		title:'新建',
		iconCls:'icon-add',
		width:750,
		height:466,
		buttons:[{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){
					$('#createProductForm').form('submit', {
							url: '${ctx}/api/v1/product/create',
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
		href:'${ctx}/inc/product/inc_prod_list_edit?productCode='+data,
		title:'修改',
		iconCls:'icon-edit',
		width:750,
		height:466,
		buttons:[{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){
					$('#createProductForm').form('submit', {
							url: '${ctx}/api/v1/product/update',
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

function del(code) {
	if(confirm('真的要删除码？')) {
		$.ajax({
			url : '${ctx}/api/v1/product/delete',
	        data:{'productCode':code},
	        cache : false,
	        async : false,
	        type : "POST",
	        dataType : 'json',
	        success : function (result){
	           if (result == '1') {
	        	   alert("删除成功");
	        	   $('#grid_inc_equipment_list').datagrid('load');
	           }
	        },
	        error: function(data) {
	        	alert("删除失败");
	        	$('#grid_inc_equipment_list').datagrid('load');
	        }
		});
	}
}

function searchProduct() {
	var productName = $('#searchProductName').val();
	var productCode = $('#searchProductCode').val();
	var productStatus=$("#searchProductStatus").combobox('getValue');
	$('#grid_inc_equipment_list').datagrid(
			'load', 
			{
				'productName' : productName,
				'productCode' : productCode,
				'productStatus' : productStatus
			});
}

</script>
