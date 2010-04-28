<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setBundle basename="application" var="rs" />

<div class="actions">
	&nbsp;
</div>

<h1><fmt:message bundle="${rs}" key="master"/></h1>

<ul>
	<li><a href="${f:url('/authority')}"><fmt:message bundle="${rs}" key="authority"/></a></li> 
	<li><a href="${f:url('/employee')}"><fmt:message bundle="${rs}" key="employee"/></a></li>
</ul>
