<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="form">
  <!-- 
  <table border="0" cellpadding="0" cellspacing="4" class="content">
    <tr>
      <th width="100" align="right">商品条码：</th>
      <td><input name="input" type="text" style="width:180px;"></td>
    </tr>
    <tr>
      <th width="100" align="right">&nbsp;</th>
      <td>扫描条码，自动从商品库中查询商品属性，未编辑过的商品手动编辑商品属性信息</td>
    </tr>
  </table>
   -->
  <div class="nullLine" style="height:4px;"></div>
  <table border="0" cellpadding="0" cellspacing="4" class="content">
    <tr>
      <th width="100" align="right">礼品名称：</th>
      <td><input name="giftName" type="text" style="width:180px;" value="${giftBean.giftName}"></td>
    </tr>
    <tr>
      <th align="right">礼品编码：</th>
      <td><input name="giftCode" type="text" style="width:180px;" value="${giftBean.code}"/></td>
    </tr>
    <tr>
      <th align="right">礼品分类：</th>
      <c:choose>
      	<c:when test="${empty giftBean}">
      <td><select class="easyui-combobox" panelHeight="auto" style="width:180px;" name="giftGroup" id="giftGroup" 
      	data-options="
  		 url:'${ctx}/api/v1/class/listAllGiftGroup',
  		 method:'get',
  		 valueField:'id',
  		 textField:'name',
  		 onLoadSuccess: function(data){
  		 	if(data) {
  		 		$(this).combobox('setValue', data[0].id);
			}
  		 }
  		 ">
      </select></td>
      	</c:when>
      	<c:otherwise>
      	<td><select class="easyui-combobox" panelHeight="auto" style="width:180px;" name="giftGroup" id="giftGroup" 
      	data-options="
  		 url:'${ctx}/api/v1/class/listAllGiftGroup',
  		 method:'get',
  		 valueField:'id',
  		 textField:'name',
  		 value: '${giftBean.giftGroup}'
  		 ">
      </select></td>
      	</c:otherwise>
      </c:choose>
    </tr>
    <tr>
      <th width="100" align="right">所属产品：</th>
      <c:choose>
      	<c:when test="${empty giftBean}">
      <td><select class="easyui-combobox" panelHeight="auto" style="width:180px;" name="productCode" id="productCode" 
      	data-options="
      	 url:'${ctx}/api/v1/product/listAllProduct',
  		 method:'get',
  		 valueField:'code',
  		 textField:'name',
  		 onLoadSuccess: function(data){
  		 	if(data) {
  		 		$(this).combobox('setValue', data[0].code);
			}
  		 }
      ">
      </select></td>
        </c:when>
        <c:otherwise>
        <td><select class="easyui-combobox" panelHeight="auto" style="width:180px;" name="productCode" id="productCode" 
      	data-options="
      	 url:'${ctx}/api/v1/product/listAllProduct',
  		 method:'get',
  		 valueField:'code',
  		 textField:'name',
  		 value: '${giftBean.product}'
      ">
      </select></td>
        </c:otherwise>
      </c:choose>
    </tr>
    <tr>
      <th align="right">成本价（分为单位）：</th>
      <td><input name="giftCost" type="text" style="width:180px;" value="${giftBean.giftCost}"></td>
    </tr>
    <tr>
      <th align="right">市场价（分为单位）：</th>
      <td><input name="giftPrice" type="text" style="width:180px;" value="${giftBean.giftPrice}"></td>
    </tr>
    <tr>
      <th align="right">兑换比：</th>
      <td><input name="exchangeValue" type="text" style="width:180px;" value="${giftBean.exchangeValue}">个</td>
    </tr>
  </table>
  <div class="nullLine" style="height:4px;"></div>
  <table border="0" cellpadding="0" cellspacing="4" class="content">
    <tr>
      <th width="100" align="right">礼品介绍：</th>
      <td><textarea name="giftDescription" style="width:220px; height:50px;">${giftBean.giftDiscribe}</textarea></td>
    </tr>
  </table>
</div>
