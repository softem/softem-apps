<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setBundle basename="application" var="rs" />

<div class="actions">
	<a href="${f:url('create')}"><fmt:message bundle="${rs}" key="create"/></a>
</div>

<h1><fmt:message bundle="${rs}" key="authority"/>(${fn:length(list)}<fmt:message bundle="${rs}" key="count"/>)</h1>

<table class="list">
	<thead>
		<tr>
			<th><fmt:message bundle="${rs}" key="label.authorityName"/></th>
			<th><fmt:message bundle="${rs}" key="action"/></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="e" items="${list}" varStatus="status">
		<tr<c:if test="${status.count%2==0}"> class="odd"</c:if>>
			<td>${f:h(e.authorityName)}</td>
			<c:set var="editUrl" value="edit/${f:h(e.key)}/${e.version}"/>
			<c:set var="deleteUrl" value="delete/${f:h(e.key)}/${e.version}"/>
			<td>
				<a href="${f:url(editUrl)}">Edit</a>
				<a href="${f:url(deleteUrl)}" onclick="return confirm('delete OK?')">Delete</a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>