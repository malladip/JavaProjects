
<%@ page import="com.WebPortal.domain.Provider" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'provider.label', default: 'Provider')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-provider" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-provider" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list provider">
			
				<g:if test="${providerInstance?.userName}">
				<li class="fieldcontain">
					<span id="userName-label" class="property-label"><g:message code="provider.userName.label" default="User Name" /></span>
					
						<span class="property-value" aria-labelledby="userName-label"><g:fieldValue bean="${providerInstance}" field="userName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${providerInstance?.organizationName}">
				<li class="fieldcontain">
					<span id="organizationName-label" class="property-label"><g:message code="provider.organizationName.label" default="Organization Name" /></span>
					
						<span class="property-value" aria-labelledby="organizationName-label"><g:fieldValue bean="${providerInstance}" field="organizationName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${providerInstance?.contactName}">
				<li class="fieldcontain">
					<span id="contactName-label" class="property-label"><g:message code="provider.contactName.label" default="Contact Name" /></span>
					
						<span class="property-value" aria-labelledby="contactName-label"><g:fieldValue bean="${providerInstance}" field="contactName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${providerInstance?.contactNumber}">
				<li class="fieldcontain">
					<span id="contactNumber-label" class="property-label"><g:message code="provider.contactNumber.label" default="Contact Number" /></span>
					
						<span class="property-value" aria-labelledby="contactNumber-label"><g:fieldValue bean="${providerInstance}" field="contactNumber"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${providerInstance?.emailId}">
				<li class="fieldcontain">
					<span id="emailId-label" class="property-label"><g:message code="provider.emailId.label" default="Email Id" /></span>
					
						<span class="property-value" aria-labelledby="emailId-label"><g:fieldValue bean="${providerInstance}" field="emailId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${providerInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="provider.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${providerInstance}" field="password"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${providerInstance?.id}" />
					<g:link class="edit" action="edit" id="${providerInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
