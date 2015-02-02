<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<div class="form">
	<input type="hidden" name="giftGroupId" value="${giftGroupBean.id}"/>
	<table border="0" cellpadding="0" cellspacing="4" class="content">
		<tr>
			<th width="100" align="right">分类名称：</th>
			<td><input name="giftGroupName" type="text" value="${giftGroupBean.name}" style="width: 180px;" /></td>
		</tr>
		<tr>
			<th width="100" align="right">是否显示：</th>
			<c:choose>
				<c:when test="${empty giftGroupBean}">
					<td><input id="isTrue" name="giftGroupIsDisplay" type="radio" value="1" checked><label for="isTrue">是</label><input id="isFalse" name="giftGroupIsDisplay" type="radio" value="0"><label for="isFalse">否</label></td>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${giftGroupBean.isDisplay == 0}">	
							<td><input id="isTrue" name="giftGroupIsDisplay" type="radio" value="1"><label for="isTrue">是</label><input id="isFalse" name="giftGroupIsDisplay" type="radio" value="0" checked><label for="isFalse">否</label></td>
						</c:when>
						<c:otherwise>
							<td><input id="isTrue" name="giftGroupIsDisplay" type="radio" value="1" checked><label for="isTrue">是</label><input id="isFalse" name="giftGroupIsDisplay" type="radio" value="0"><label for="isFalse">否</label></td>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<th width="100" align="right">序列编号：</th>
			<td><input name="giftGroupOrder" type="text"
				value="${giftGroupBean.displayOrder}" style="width: 80px;" /></td>
		</tr>
	</table>
	<div class="nullLine" style="height: 4px;"></div>
	<table border="0" cellpadding="0" cellspacing="4" class="content">
		<tr>
			<th width="100" align="right">备注：</th>
			<td><textarea name="giftGroupDescription" style="width: 220px; height: 50px;">${giftGroupBean.description}</textarea></td>
		</tr>
	</table>
</div>
