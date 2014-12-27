<%@ page import="com.WebPortal.domain.Provider" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'provider.label', default: 'Provider')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-provider" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="create-provider" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${providerInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${providerInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form action="checkLogin" >
				
<div class="fieldcontain ${hasErrors(bean: providerInstance, field: 'userName', 'error')} required">
	<label for="userName">
		<g:message code="provider.userName.label" default="User Name" />
			<span class="required-indicator">*</span>
	</label>
	<g:textField name="userName" required="" maxlength="25" value="${providerInstance?.userName}"/>
</div>


<div class="fieldcontain ${hasErrors(bean: providerInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="provider.password.label" default="Password" />
			<span class="required-indicator">*</span>
	</label>
	<g:passwordField name="password" required="" value="${providerInstance?.password}"/>
</div>
				<fieldset class="buttons">
					<g:submitButton name="login" class="save" value="${message(code: 'default.button.login.label', default: 'Login')}" />
				</fieldset>
			</g:form>
			<g:form action="createIndex">
			<g:submitButton name="register" class="save" value="${message(code: 'default.button.register.label', default: 'Register')}" />
			</g:form>
		</div>
	</body>
</html>
