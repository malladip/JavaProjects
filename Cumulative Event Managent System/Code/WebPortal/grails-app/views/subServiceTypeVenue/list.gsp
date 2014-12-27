
<%@ page import="com.WebPortal.domain.SubServiceTypeVenue" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'subServiceTypeVenue.label', default: 'SubServiceTypeVenue')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-subServiceTypeVenue" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-subServiceTypeVenue" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="subType" title="${message(code: 'subServiceTypeVenue.subType.label', default: 'Sub Type')}" />
					
						<th><g:message code="subServiceTypeVenue.venue.label" default="Venue" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${subServiceTypeVenueInstanceList}" status="i" var="subServiceTypeVenueInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${subServiceTypeVenueInstance.id}">${fieldValue(bean: subServiceTypeVenueInstance, field: "subType")}</g:link></td>
					
						<td>${fieldValue(bean: subServiceTypeVenueInstance, field: "venue")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${subServiceTypeVenueInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
