<%@ page import="com.WebPortal.domain.User" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		
		<div id="create-user" class="content scaffold-create" role="main">
			<h1  id="contentBlock"><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${userInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${userInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			
			
			<g:form action="checkLogin" >
			<div id="contentBlock">
					
	<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'userName', 'error')} required">
	<label for="userName">
		<g:message code="user.userName.label" default="User Name" />
			<span class="required-indicator">*</span>
</label>

	<g:textField name="userName" required="" value="${userInstance?.userName}"/>

</div>


<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="user.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:passwordField name="password" required="" value="${userInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'loginType', 'error')} required">
	<label for="gender">
		<g:message code="user.loginType.label" default="LoginType" />
		<span class="required-indicator">*</span>
	</label>
<!--<g:radio name="gender" value="${userInstance?.gender}"/>  -->
	
	<g:radio name="loginType" value="1"/> User 
	
	<g:radio name="loginType" value="0"/> Provider
</div>

<div id="contentBlock">
				<fieldset class="buttons">
					<g:submitButton name="login" class="save" value="${message(code: 'default.button.login.label', default: 'Login')}" />
				</fieldset>
			</g:form>
			<g:form action="createIndex">
			<g:submitButton name="registerUser" class="save" value="${message(code: 'default.button.registerUser.label', default: 'User Register')}" />
		</g:form>
		<g:form controller="Provider" action="createIndex">
			<g:submitButton name="registerProvider" class="save" value="${message(code: 'default.button.registerProvider.label', default: 'Provider Register')}" />
			</g:form>	
		</div>
	</body>
</html>