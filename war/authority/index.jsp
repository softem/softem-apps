<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setBundle basename="application" var="rs" />

<div class="actions">
	<a href="${f:url('create')}"><fmt:message bundle="${rs}" key="create"/></a>
</div>

<h1><fmt:message bundle="${rs}" key="authority"/></h1>

<p id="message">${f:h(errors.message)}</p>

<c:if test="${fn:length(list)>0}">
<p>${pagenator.navigation}</p>
<p class="count">${pagenator.label}</p>
<table class="list">
	<thead>
		<tr>
			<th><fmt:message bundle="${rs}" key="action"/></th>
			<th><fmt:message bundle="${rs}" key="label.authorityName"/></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="e" items="${list}" varStatus="status">
		<tr<c:if test="${status.count%2==0}"> class="odd"</c:if>>
			<c:set var="editUrl" value="edit/${f:h(e.key)}/${e.version}"/>
			<c:set var="deleteUrl" value="delete/${f:h(e.key)}/${e.version}"/>
			<td>
				<a href="${f:url(editUrl)}"><fmt:message bundle="${rs}" key="edit"/></a>
				<a href="${f:url(deleteUrl)}" onclick="return confirm('delete OK?')"><fmt:message bundle="${rs}" key="delete"/></a>
			</td>
			<td>${f:h(e.authorityName)}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</c:if>

<jsp:include page="/master_menu.jsp"></jsp:include>
