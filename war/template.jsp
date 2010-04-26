<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<fmt:setBundle basename="application" var="rs" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css" />
<title><fmt:message bundle="${rs}" key="application.name"/></title>
</head>
<body>
	<div id="menu">
		<a href="${f:url('/')}"><fmt:message bundle="${rs}" key="home"/><span>HOME</span></a>
		<a href="${f:url('/master')}"><fmt:message bundle="${rs}" key="master"/><span>MASTER</span></a>
	</div><!-- end of menu  -->

	<div id="content">
		<jsp:include page="${page}" flush="true" />
	</div><!-- end of content -->

	<div id="footer">
		<div id="navigation">
			<a href="${f:url('/')}">HOME</a> | 
			<a href="${f:url('/master')}">MASTER</a>
		</div>
		<div id="copyright">&copy;2010 SOFTEM</div>
	</div>
</body>
</html>