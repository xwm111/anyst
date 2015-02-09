<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<table id="grid_inc_repr_list_relation_prodList" class="easyui-datagrid"
			data-options="
            toolbar:'#gridTools_inc_repr_list_relation_prodList',
            fit:true,
            border:false,
            singleSelect:false,
            fitColumns: true,
            collapsible:true,
            onLoadSuccess:dataGridOnloadSuccess,
            pagination:true,
            url:'${ctx}/api/v1/product‘,method:'get'
            ">
  <thead>
    <tr>
      <th data-options="field:'ck',checkbox:true"></th>
      <th data-options="field:'imgUrl',width:100,align:'center',formatter:rowFormater_pic">产品图片</th>
      <th data-options="field:'name',width:120,align:'center'">产品名称</th>
    </tr>
  </thead>
</table>
<div id="gridTools_inc_repr_list_relation_prodList" style="padding:5px;height:auto">
  <input class="easyui-validatebox" name="searchProductName" id="searchProductName" type="text" style="width:180px" placeholder="名称">
  <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search" onclick="searchProduct()">搜索</a>
</div>

<script>
function rowFormater_pic(value,row,index){
	var picArr=value.split("|");
	if(picArr.length>0){
		return "有图片("+picArr.length+")"  //TODO:更换为现实图片
	}else{
		return "尚无图片"
	}
}

function searchProduct(){
  var searchProductName = $('#searchProductName');
  $('#grid_inc_repr_list_relation_prodList').datagrid(
      'load', 
      {
        'productName' : productName,
        'productCode' : productCode,
        'productStatus' : productStatus
      });
}
</script>