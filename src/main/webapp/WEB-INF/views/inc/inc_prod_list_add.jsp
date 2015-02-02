<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="easyui-layout" fit="true">
<!--  <div data-options="region:'north',border:false" style="border-bottom:1px solid #ddd;">
    <div class="form">
      <table border="0" cellpadding="0" cellspacing="4" class="content">
        <tr>
          <th width="100" align="right">商品分类：</th>
          <td><select name="select" id="select">
            </select></td>
        </tr>
      </table>
    </div>
  </div>-->
  <form id="createProductForm" method="post">
  <div data-options="region:'center',border:false">
    <div class="easyui-tabs" fit="true" border="false">
   	  <c:choose>
   	    <c:when test="${empty productBean}">
      <div title="基本信息" href="${ctx}/inc/product/inc_prod_list_add_infos"></div>
        </c:when>
        <c:otherwise>
      <div title="基本信息" href="${ctx}/inc/product/inc_prod_list_edit_infos?productCode=${productBean.code}&productName=${productBean.name}&productDescription=${productBean.description}"></div>
        </c:otherwise>
      </c:choose>
    </div>
  </div>
  <div data-options="region:'east',border:false" style="width:320px;">
    <div class="easyui-tabs" fit="true" border="false" style="border-left:1px solid #ddd;">
      <!-- 
      <div title="贴花图片" href="${ctx}/inc/inc_prod_list_add_imgs"></div>
       -->
       <c:choose>
   	    <c:when test="${empty productBean}">
      <div title="宣传图片" href="${ctx}/inc/product/inc_prod_list_add_imgs"></div>
        </c:when>
        <c:otherwise>
      <div title="宣传图片" href="${ctx}/inc/product/inc_prod_list_edit_imgs?productCode=${productBean.code}&productImgUrls=${productBean.productImgUrls}"></div>
        </c:otherwise>
      </c:choose>
    </div>
  </div>
  </form>
</div>
