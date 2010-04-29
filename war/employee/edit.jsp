<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setBundle basename="application" var="rs" />

<div class="actions">
	<a href="${f:url('index')}"><fmt:message bundle="${rs}" key="index"/></a>
</div>

<h1><fmt:message bundle="${rs}" key="employee"/></h1>

<form action="${f:url('update')}" method="post">
<input type="hidden" ${f:hidden("key")}/>
<input type="hidden" ${f:hidden("version")}/>
<table class="form">
	<tr>
		<th><fmt:message bundle="${rs}" key="label.employeeName"/></th>
		<td>
			<input type="text" ${f:text("employeeName")} class="${f:errorClass('employeeName', 'err')}"/>
			<span class="error">${f:h(errors.employeeName)}</span>
		</td>
	</tr>
	<tr>
		<th><fmt:message bundle="${rs}" key="label.authorityName"/></th>
		<td>
			<select name="authorityKey">
			<c:forEach var="e" items="${authorityList}">
				<option ${f:select("authority", f:h(e.key))}>${f:h(e.authorityName)}</option>
			</c:forEach>
			</select>
		</td>
	</tr>
</table>
<p><input type="submit" value="<fmt:message bundle="${rs}" key="update"/>"/></p>
</form>
<jsp:include page="/master_menu.jsp"></jsp:include>