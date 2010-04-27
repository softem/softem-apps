<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setBundle basename="application" var="rs" />

<div class="actions">
	<a href="${f:url('create')}"><fmt:message bundle="${rs}" key="create"/></a>
</div>

<h1><fmt:message bundle="${rs}" key="employee"/></h1>

<form action="${f:url('index')}" method="post">
<p>
<input type="text" ${f:text("words")} class="${f:errorClass('words', 'err')}"/>${f:h(errors.words)}
<input type="submit" value="<fmt:message bundle="${rs}" key="find"/>"/>
</p>
</form>

<c:if test="${fn:length(list)>0}">
<p class="count">${fn:length(list)}<fmt:message bundle="${rs}" key="count"/></p>
<table class="list">
	<thead>
		<tr>
			<th><fmt:message bundle="${rs}" key="action"/></th>
			<th><fmt:message bundle="${rs}" key="label.employeeName"/></th>
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
			<td>${f:h(e.employeeName)}</td>
			<td>${f:h(e.authorityRef.model.authorityName)}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</c:if>

<jsp:include page="/master/menu.jsp"></jsp:include>