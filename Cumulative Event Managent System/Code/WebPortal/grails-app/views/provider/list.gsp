
<%@ page import="com.WebPortal.domain.Provider" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'provider.label', default: 'Provider')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-provider" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-provider" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="userName" title="${message(code: 'provider.userName.label', default: 'User Name')}" />
					
						<g:sortableColumn property="organizationName" title="${message(code: 'provider.organizationName.label', default: 'Organization Name')}" />
					
						<g:sortableColumn property="contactName" title="${message(code: 'provider.contactName.label', default: 'Contact Name')}" />
					
						<g:sortableColumn property="contactNumber" title="${message(code: 'provider.contactNumber.label', default: 'Contact Number')}" />
					
						<g:sortableColumn property="emailId" title="${message(code: 'provider.emailId.label', default: 'Email Id')}" />
					
						<g:sortableColumn property="password" title="${message(code: 'provider.password.label', default: 'Password')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${providerInstanceList}" status="i" var="providerInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${providerInstance.id}">${fieldValue(bean: providerInstance, field: "userName")}</g:link></td>
					
						<td>${fieldValue(bean: providerInstance, field: "organizationName")}</td>
					
						<td>${fieldValue(bean: providerInstance, field: "contactName")}</td>
					
						<td>${fieldValue(bean: providerInstance, field: "contactNumber")}</td>
					
						<td>${fieldValue(bean: providerInstance, field: "emailId")}</td>
					
						<td>${fieldValue(bean: providerInstance, field: "password")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${providerInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
