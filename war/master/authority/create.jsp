<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setBundle basename="application" var="rs" />

<div class="actions">
	<a href="${f:url('index')}"><fmt:message bundle="${rs}" key="index"/></a>
</div>

<h1><fmt:message bundle="${rs}" key="authority"/></h1>

<form action="${f:url('insert')}" method="post">
<table class="form">
	<tr>
		<th><fmt:message bundle="${rs}" key="label.authorityName"/></th>
		<td>
			<input type="text" ${f:text("authorityName")} class="${f:errorClass('authorityName', 'err')}"/>
			<span class="error">${f:h(errors.authorityName)}</span>
		</td>
	</tr>
</table>
<p><input type="submit" value="<fmt:message bundle="${rs}" key="insert"/>"/></p>
</form>
<jsp:include page="/master/menu.jsp"></jsp:include>