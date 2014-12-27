<%@ page import="com.WebPortal.domain.OtherServices" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'otherServices.label', default: 'OtherServices')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<%--<a href="#create-otherServices" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		--%><div id="create-otherServices" class="content scaffold-create" role="main">
			
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${otherServicesInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${otherServicesInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:if test="${inValid=="y"}">
			<h3>invalid details</h3>
			</g:if>
			<div id="contentBlock">
			<h1>Create</h1>
			<g:form action="save" >
				<fieldset class="form">
					<g:render template="formFoodSupplier"/>
				</fieldset>
					<g:hiddenField name="providerId" value="${pId}"/>
					<g:hiddenField name="serviceType" value="${sType}"/>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>.
			</div>
		</div>
	</body>
</html>
