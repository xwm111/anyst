<table id="grid_inc_logm_list" class="easyui-datagrid"
			data-options="
            toolbar:'#gridTools_inc_logm_list',
            fit:true,
            border:false,
            singleSelect:true,
            collapsible:true,
            onLoadSuccess:dataGridOnloadSuccess,
            pagination:true,
            url:'../data/data_logm_list.json',method:'get'
            ">
  <thead>
    <tr>
      <th data-options="field:'ck',checkbox:true"></th>
      <th data-options="field:'lab_02',width:100,align:'center',formatter:rowFormater_types">日志类型</th>
      <th data-options="field:'lab_03',width:180,align:'center'">记录时间</th>
      <th data-options="field:'lab_04',width:160,align:'center'">操作人帐号</th>
      <th data-options="field:'lab_05',width:120,align:'left'">操作人角色</th>
      <th data-options="field:'lab_06',width:420,align:'left'">操作记录</th>
    </tr>
  </thead>
</table>
<div id="gridTools_inc_logm_list" style="padding:5px;height:auto">
  <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">导出</a>
  
  <div class="separator"/>
  日志类型：
  <select class="easyui-combobox" panelHeight="auto" style="width:100px">
    <option value="1">产品日志</option>
    <option value="2">礼品日志</option>
    <option value="3">订单日志</option>
    <option value="4">库存日志</option>
    <option value="5">登录日志</option>
    <option value="0" selected>全部</option>
  </select>
  时间：
  <input class="easyui-validatebox" name="" type="text" style="width:80px">
  至
  <input class="easyui-validatebox" name="" type="text" style="width:80px">
  
  <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-search">搜索</a>
</div>
<script>
function rowFormater_types(value,row,index){
	switch(Number(value)){
		case 1:
		return '产品日志'
		case 2:
		return '礼品日志'
		case 3:
		return '订单日志'
		case 4:
		return '库存日志'
		case 5:
		return '登录日志'
	}
}


function add(){
	qDialog({
		href:'../inc/inc_logm_list_add.html',
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
		href:'../inc/inc_logm_list_add.html',
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
