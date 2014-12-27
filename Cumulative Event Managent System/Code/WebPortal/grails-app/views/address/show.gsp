
<%@ page import="com.WebPortal.domain.Address" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'address.label', default: 'Address')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-address" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-address" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list address">
			
				<g:if test="${addressInstance?.line}">
				<li class="fieldcontain">
					<span id="line-label" class="property-label"><g:message code="address.line.label" default="Line" /></span>
					
						<span class="property-value" aria-labelledby="line-label"><g:fieldValue bean="${addressInstance}" field="line"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.place}">
				<li class="fieldcontain">
					<span id="place-label" class="property-label"><g:message code="address.place.label" default="Place" /></span>
					
						<span class="property-value" aria-labelledby="place-label"><g:fieldValue bean="${addressInstance}" field="place"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.city}">
				<li class="fieldcontain">
					<span id="city-label" class="property-label"><g:message code="address.city.label" default="City" /></span>
					
						<span class="property-value" aria-labelledby="city-label"><g:fieldValue bean="${addressInstance}" field="city"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.pincode}">
				<li class="fieldcontain">
					<span id="pincode-label" class="property-label"><g:message code="address.pincode.label" default="Pincode" /></span>
					
						<span class="property-value" aria-labelledby="pincode-label"><g:fieldValue bean="${addressInstance}" field="pincode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${addressInstance?.phoneNumber}">
				<li class="fieldcontain">
					<span id="phoneNumber-label" class="property-label"><g:message code="address.phoneNumber.label" default="Phone Number" /></span>
					
						<span class="property-value" aria-labelledby="phoneNumber-label"><g:fieldValue bean="${addressInstance}" field="phoneNumber"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${addressInstance?.id}" />
					<g:link class="edit" action="edit" id="${addressInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
