<%@ page import="com.WebPortal.domain.User"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'user.label', default: 'User')}" />
<title><g:message code="default.create.label"
		args="[entityName]" /></title>
</head>
<body>

	<div id="create-user" class="content scaffold-create" role="main">

	<g:render template="/login/login" />
	
	</div>

</body>
</html>
