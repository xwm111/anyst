<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="form">
  <table border="0" cellpadding="0" cellspacing="4" class="content">
    <tr>
      <th width="64" align="right">图片上传：</th>
      <td><form id="giftFileUploadForm" enctype="multipart/form-data" method="post"><input name="uploadFile" id="uplaodFile" type="file" multiple="multiple" style="width:140px;" onchange="fileSelected(this.value);"></form>
        <a id="uploadFileButton" style="display:none;" href="#" class="easyui-linkbutton" plain="true" data-options="iconCls:'icon-update'" onclick="fileUpload()">上传图片</a></td>
    </tr>
  </table>
  <div class="nullLine" style="height:4px;"></div>
  <table border="0" cellpadding="0" cellspacing="4" class="content">
    <tr>
      <td height="182" align="center" valign="middle"><img id="giftImgBox"class="imgViewBox" src="../themes/default/images/blank.gif" height="160" style="background-image:url(${ctx}/static/updata/u=130740056,3316200783&fm=116&gp=0.jpg);"></td>
    </tr>
  </table>
  <div class="nullLine" style="height:4px;"></div>
  <table border="0" cellpadding="0" cellspacing="4" class="content">
    <tr>
      <td height="56" align="left" valign="middle"><div class="imgGroup">
          <a class="btn-prev">&lt;</a>
          <a class="btn-next">&gt;</a>
          <ul id="giftImgList">
            <li class="selected">
              <a><span class="checked"></span><img class="imgViewBox" src="../themes/default/images/blank.gif" style="background-image:url(../updata/u=130740056,3316200783&fm=116&gp=0.jpg);" height="36"></a>
            </li>
          </ul>
        </div></td>
    </tr>
  </table>
</div>
<script>
function fileSelected(filename) {
	alert(filename);
	if (filename) {
		alert("need show");
		$('#uploadFileButton').show();
	}
}

function fileUpload() {
	$('#giftFileUploadForm').form('submit', {
		url: '${ctx}/api/v1/qiniu/upload',
		
		onSubmit: function() {
			return true;
		},
		success:function(data) {
			var giftImgList = $('#giftImgList');
			giftImgList.append("<li class='selected'><a><span class='checked'></span><img class='imgViewBox' src='../themes/default/images/blank.gif' style='background-image:url(${ctx}/static/updata/u=130740056,3316200783&fm=116&gp=0.jpg);' height='36'></a></li>")
		}
	});
}
</script>
