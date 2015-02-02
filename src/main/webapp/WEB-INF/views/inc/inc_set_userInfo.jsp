<div class="easyui-layout" data-options="fit:true">
  <div data-options="region:'center',border:false">
    <div class="form">
      <table width="100%" border="0" cellpadding="0" cellspacing="4" class="content">
        <tr>
          <th width="100" align="left">手机号：</th>
          <td>13888888888</td>
          <td width="68" align="center">&nbsp;</td>
        </tr>
        <tr>
          <th width="100" align="left">姓名：</th>
          <td>尚未完善</td>
          <td width="68" align="center"><a href="#">编辑</a></td>
        </tr>
        <tr>
          <th align="right">身份证号：</th>
          <td>尚未完善</td>
          <td width="68" align="center"><a href="#">编辑</a></td>
        </tr>
      </table>
      <div class="nullLine" style="height:4px;"></div>
      <table width="100%" border="0" cellpadding="0" cellspacing="4" class="content">
        <tr>
          <td height="160" colspan="3" align="center" valign="middle"><img src="../themes/default/images/bg_card_0.png" width="160" height="108" style="border:1px dashed #CCCCCC;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="../themes/default/images/bg_card_1.png" width="160" height="108" style="border:1px dashed #CCCCCC;"></td>
        </tr>
        <tr>
          <th width="100" align="right">上传图片：</th>
          <td><label for="select"></label>
            <select name="select" id="select">
              <option>正面</option>
              <option>背面</option>
            </select>
            <input type="file" name="fileField" id="fileField" style="width:220px;"></td>
          <td width="68" align="center"><a href="#">保存</a></td>
        </tr>
      </table>
    </div>
  </div>
  <div data-options="region:'south',border:false" style="overflow:hidden;padding:0px 10px;">
    <div class="form">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tbody>
          <tr>
            <td height="60" align="right" valign="middle"><a href="#" class="a-btn-r-big" onClick="$('#dlg_check').dialog('close');$('#dlg_checkOK').dialog('open');">提交审核</a>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</div>
