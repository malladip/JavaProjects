<%@ page import="com.WebPortal.domain.OtherServices" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'otherServices.label', default: 'OtherServices')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<%--<a href="#edit-otherServices" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		--%><div id="edit-otherServices" class="content scaffold-edit" role="main">
			
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
			<div id="contentBlock">
			<h1>Edit</h1>
		<g:form controller="OtherServices" action="update">
				<g:hiddenField name="id" value="${otherServicesInstance?.id}" />
				<g:hiddenField name="version" value="${otherServicesInstance?.version}" />
				<g:hiddenField name="otherServicesId" value="${otherServices.id}"/>
				<fieldset class="form">
			<g:if test="${serviceTypeId==2}">
			<g:render template="updateFormEventOrganizer"/>
			</g:if>
			<g:if test="${serviceTypeId==3}">
			<g:render template="updateFormFoodSupplier"/>
			</g:if>
			<g:if test="${serviceTypeId==4}">
			<g:render template="updateFormMusicProvider"/>
			</g:if>
				</fieldset>
				<fieldset class="buttons">
				<g:submitButton name="update" class="save"
							value="${message(code: 'default.button.update.label', default: 'Update')}" />
					</fieldset>
			</g:form>
		</div>
		</div>
		
	</body>
</html>
