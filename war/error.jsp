<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setBundle basename="application" var="rs" />

<div class="actions">
	&nbsp;
</div>

<h1><fmt:message bundle="${rs}" key="error"/></h1>

<p id="message">${f:h(errors.message)}</p>
