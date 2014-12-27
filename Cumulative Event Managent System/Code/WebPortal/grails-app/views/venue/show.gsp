
<%@ page import="com.WebPortal.domain.Venue" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'venue.label', default: 'Venue')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-venue" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-venue" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list venue">
			
				<g:if test="${venueInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="venue.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${venueInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${venueInstance?.website}">
				<li class="fieldcontain">
					<span id="website-label" class="property-label"><g:message code="venue.website.label" default="Website" /></span>
					
						<span class="property-value" aria-labelledby="website-label"><g:fieldValue bean="${venueInstance}" field="website"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${venueInstance?.cost}">
				<li class="fieldcontain">
					<span id="cost-label" class="property-label"><g:message code="venue.cost.label" default="Cost" /></span>
					
						<span class="property-value" aria-labelledby="cost-label"><g:fieldValue bean="${venueInstance}" field="cost"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${venueInstance?.maxCapacity}">
				<li class="fieldcontain">
					<span id="maxCapacity-label" class="property-label"><g:message code="venue.maxCapacity.label" default="Max Capacity" /></span>
					
						<span class="property-value" aria-labelledby="maxCapacity-label"><g:fieldValue bean="${venueInstance}" field="maxCapacity"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${venueInstance?.ac}">
				<li class="fieldcontain">
					<span id="ac-label" class="property-label"><g:message code="venue.ac.label" default="Ac" /></span>
					
						<span class="property-value" aria-labelledby="ac-label"><g:formatBoolean boolean="${venueInstance?.ac}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${venueInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="venue.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${venueInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${venueInstance?.provider}">
				<li class="fieldcontain">
					<span id="provider-label" class="property-label"><g:message code="venue.provider.label" default="Provider" /></span>
					
						<span class="property-value" aria-labelledby="provider-label"><g:link controller="provider" action="show" id="${venueInstance?.provider?.id}">${venueInstance?.provider?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${venueInstance?.address}">
				<li class="fieldcontain">
					<span id="address-label" class="property-label"><g:message code="venue.address.label" default="Address" /></span>
					
						<span class="property-value" aria-labelledby="address-label"><g:link controller="address" action="show" id="${venueInstance?.address?.id}">${venueInstance?.address?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${venueInstance?.id}" />
					<g:link class="edit" action="edit" id="${venueInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
