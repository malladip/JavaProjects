<%@ page import="com.WebPortal.domain.User"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'user.label', default: 'User')}" />
<title><g:message code="default.create.label"
		args="[entityName]" /></title>
</head>
<body>
	<%--<a href="#create-user" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			<li><g:link class="list" action="list">
					<g:message code="default.list.label" args="[entityName]" />
				</g:link></li>
		</ul>
	</div>
	--%>
	<div id="create-user" class="content scaffold-create" role="main">
		<%--<h1>
			<g:message code="default.create.label" args="[entityName]" />
		</h1>
			
	<g:if test="${flash.message}">
		<div class="message" role="status">
			${flash.message}
		</div>
	</g:if>
--%>
		<%--<g:hasErrors bean="${userInstance}">
		<ul class="errors" role="alert">
			<g:eachError bean="${userInstance}" var="error">
				<li
					<g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
						error="${error}" /></li>
			</g:eachError>
		</ul>
	</g:hasErrors>

	--%>
		<div id="contentBlock">

			<div>
				<g:form controller="Venue" action="myList">
					<g:submitButton name="myVenues" class="save"
						value="${message(code: 'default.button.myVenues.label', default: 'My Venues')}" />
					<g:hiddenField name="providerId" value="${providerId}" />
				</g:form>
				<g:form controller="Venue" action="index">
					<g:submitButton name="createVenue" class="save"
						value="${message(code: 'default.button.createVenue.label', default: 'Create Venue')}" />
					<g:hiddenField name="id" value="${providerId}" />
				</g:form>
			</div>
		</div>
		<pre>

</pre>
		<div id="rightBlock">
			<div>
				<g:form controller="OtherServices" action="myEventOrganizersList">
					<g:submitButton name="myEventOrganizers" class="save"
						value="${message(code: 'default.button.myEventOrganizers.label', default: 'My Event Organizers')}" />
					<g:hiddenField name="providerId" value="${providerId}" />
					<g:hiddenField name="serviceTypeId" value="2" />
				</g:form>
				<g:form controller="OtherServices" action="index">
					<g:submitButton name="createEventOrganizer" class="save"
						value="${message(code: 'default.button.createEventOrganizer.label', default: 'create Event Organizer')}" />
					<g:hiddenField name="providerId" value="${providerId}" />
					<g:hiddenField name="serviceTypeId" value="2" />
				</g:form>
			</div>
		</div>

		<div id="contentBlock">
				<pre>


</pre>
			<g:form controller="OtherServices" action="myFoodSuppliersList">
				<g:submitButton name="myFoodSuppliers" class="save"
					value="${message(code: 'default.button.myFoodSuppliers.label', default: 'My Food Suppliers')}" />
				<g:hiddenField name="providerId" value="${providerId}" />
				<g:hiddenField name="serviceTypeId" value="3" />
			</g:form>
			<g:form controller="OtherServices" action="index">
				<g:submitButton name="createFoodSupplier" class="save"
					value="${message(code: 'default.button.createFoodSupplier.label', default: 'create Food Supplier')}" />
				<g:hiddenField name="providerId" value="${providerId}" />
				<g:hiddenField name="serviceTypeId" value="3" />
			</g:form>
		</div>

	</div>
	<div id="rightBlock">
		<pre>

</pre>
		<div>
			<g:form controller="OtherServices" action="myMusicProvidersList">
				<g:submitButton name="myMusicProviders" class="save"
					value="${message(code: 'default.button.myMusicProviders.label', default: 'My Music Providers')}" />
				<g:hiddenField name="providerId" value="${providerId}" />
				<g:hiddenField name="serviceTypeId" value="4" />
			</g:form>
			<g:form controller="OtherServices" action="index">
				<g:submitButton name="createMusicProvider" class="save"
					value="${message(code: 'default.button.createMusicProvider.label', default: 'create Music Provider')}" />
				<g:hiddenField name="providerId" value="${providerId}" />
				<g:hiddenField name="serviceTypeId" value="4" />
			</g:form>
		</div>

	</div>

</body>
</html>
