<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<a href="${f:url('create')}">Create</a>

<table>
	<thead>
		<tr>
			<th>Key</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="e" items="${list}">
		<tr>
			<td>${f:h(e.key)}</td>
			<c:set var="editUrl" value="edit/${f:h(e.key)}/${e.version}"/>
			<c:set var="deleteUrl" value="delete/${f:h(e.key)}/${e.version}"/>
			<td><a href="${f:url(editUrl)}">Edit</a></td>
			<td><a href="${f:url(deleteUrl)}" onclick="return confirm('delete OK?')">Delete</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>