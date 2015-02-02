<table id="grid_inc_orde_list" class="easyui-datagrid"
			data-options="
            toolbar:'#gridTools_inc_orde_list',
            fit:true,
            border:false,
            singleSelect:true,
            fitColumns: false,
            onLoadSuccess:dataGridOnloadSuccess,
            pagination:true,
            url:'../data/data_orde_list.json',
            method:'get'
            ">
  <thead>
    <tr>
      <th data-options="field:'ck',checkbox:true"></th>
      <th data-options="field:'lab_00',width:120,align:'center'">快递单号</th>
      <th data-options="field:'lab_01',width:120,align:'center',formatter:rowFormater_action">操作</th>
      <th data-options="field:'lab_02',width:120,align:'center'">客户姓名</th>
      <th data-options="field:'lab_03',width:180,align:'center'">科室</th>
      <th data-options="field:'lab_04',width:80,align:'center'">电话</th>
      <th data-options="field:'lab_05',width:120,align:'center'">身份</th>
      <th data-options="field:'lab_06',width:80,align:'center'">礼品编号</th>
      <th data-options="field:'lab_07',width:80,align:'left'">礼品名称</th>
      <th data-options="field:'lab_08',width:100,align:'center'">礼品数量</th>
      <th data-options="field:'lab_09',width:140,align:'right'">礼品成本</th>
      <th data-options="field:'lab_10',width:60,align:'right'">成本小计</th>
      <th data-options="field:'lab_11',width:120,align:'center',formatter:rowFormater_state">订单状态</th>
      <th data-options="field:'lab_12',width:120,align:'center'">下单时间</th>
    </tr>
  </thead>
</table>
<div id="gridTools_inc_orde_list" style="padding:5px;height:auto">
  <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">导出Excel</a>
  
  <div class="separator"/>
  
  客户名称：
  <input class="easyui-validatebox" name="" type="text" style="width:80px">
  时间：
  <input class="easyui-validatebox" name="" type="text" style="width:80px">
  至
  <input class="easyui-validatebox" name="" type="text" style="width:80px">
  订单状态：
  <select>
    <option value="2">已经确认</option>
    <option value="3">已经邮寄</option>
    <option value="1">未确认</option>
    <option value="0" selected>全部</option>
  </select>
  礼品名称：
  <input class="easyui-validatebox" name="" type="text" style="width:80px">
  <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search">搜索</a>
</div>
<script>

function rowFormater_action(value,row,index){
	if(!!value){
		switch (row["lab_11"]){
			case 1:
				var btns="<a class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\">确认订单</a>"
			return btns
			case 2:
				var btns="<a class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\">录入快递号</a>"
			return btns
			case 3:
				var btns="<a class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\">签收</a>"
			return btns
		}
	}else{
		return ""
	}
}
function rowFormater_state(value,row,index){
	if(!!value){
		switch (value){
			case 1:
			return "未确认"
			case 2:
			return "已经确认"
			case 3:
			return "已经邮寄"
		}
	}else{
		return ""
	}
}

</script>
