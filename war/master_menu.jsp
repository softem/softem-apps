<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setBundle basename="application" var="rs" />
<div class="masters">
	<a href="${f:url('/authority')}"><fmt:message bundle="${rs}" key="authority"/></a> | 
	<a href="${f:url('/employee')}"><fmt:message bundle="${rs}" key="employee"/></a>
</div>
