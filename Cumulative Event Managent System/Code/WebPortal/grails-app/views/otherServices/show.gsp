
<%@ page import="com.WebPortal.domain.OtherServices" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'otherServices.label', default: 'OtherServices')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-otherServices" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-otherServices" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list otherServices">
			
				<g:if test="${otherServicesInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="otherServices.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${otherServicesInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${otherServicesInstance?.website}">
				<li class="fieldcontain">
					<span id="website-label" class="property-label"><g:message code="otherServices.website.label" default="Website" /></span>
					
						<span class="property-value" aria-labelledby="website-label"><g:fieldValue bean="${otherServicesInstance}" field="website"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${otherServicesInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="otherServices.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${otherServicesInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${otherServicesInstance?.serviceType}">
				<li class="fieldcontain">
					<span id="serviceType-label" class="property-label"><g:message code="otherServices.serviceType.label" default="Service Type" /></span>
					
						<span class="property-value" aria-labelledby="serviceType-label"><g:link controller="serviceType" action="show" id="${otherServicesInstance?.serviceType?.id}">${otherServicesInstance?.serviceType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${otherServicesInstance?.address}">
				<li class="fieldcontain">
					<span id="address-label" class="property-label"><g:message code="otherServices.address.label" default="Address" /></span>
					
						<span class="property-value" aria-labelledby="address-label"><g:link controller="address" action="show" id="${otherServicesInstance?.address?.id}">${otherServicesInstance?.address?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${otherServicesInstance?.provider}">
				<li class="fieldcontain">
					<span id="provider-label" class="property-label"><g:message code="otherServices.provider.label" default="Provider" /></span>
					
						<span class="property-value" aria-labelledby="provider-label"><g:link controller="provider" action="show" id="${otherServicesInstance?.provider?.id}">${otherServicesInstance?.provider?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${otherServicesInstance?.id}" />
					<g:link class="edit" action="edit" id="${otherServicesInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
