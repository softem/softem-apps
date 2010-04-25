<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setBundle basename="application" var="rs" />

<h1><fmt:message bundle="${rs}" key="employee"/></h1>

<div class="actions">
	<a href="${f:url('create')}"><fmt:message bundle="${rs}" key="create"/></a>
</div>

<table>
	<thead>
		<tr>
			<th><fmt:message bundle="${rs}" key="label.employeeName"/></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="e" items="${list}">
		<tr>
			<td>${f:h(e.employeeName)}</td>
			<c:set var="editUrl" value="edit/${f:h(e.key)}/${e.version}"/>
			<c:set var="deleteUrl" value="delete/${f:h(e.key)}/${e.version}"/>
			<td><a href="${f:url(editUrl)}">Edit</a></td>
			<td><a href="${f:url(deleteUrl)}" onclick="return confirm('delete OK?')">Delete</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>