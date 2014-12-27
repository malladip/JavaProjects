<%@ page import="com.WebPortal.domain.Venue"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'venue.label', default: 'Venue')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
<g:javascript library="jquery" />
<g:javascript library="jquery-ui" />
</head>
<body>
	<%--<a href="#list-venue" class="skip" tabindex="-1"><g:message
			code="default.link.skip.label" default="Skip to content&hellip;" /></a>
	<div class="nav" role="navigation">
		<ul>
			<li><a class="home" href="${createLink(uri: '/')}"><g:message
						code="default.home.label" /></a></li>
			<li><g:link class="create" action="create">
					<g:message code="default.new.label" args="[entityName]" />
				</g:link></li>
		</ul>
	</div>


	--%>
	<div id="list-venue" class="content scaffold-list" role="main">

		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>

		</g:if>
		<div id="contentBlock">
			<g:set var="name" value="${name}" />
			<ul>
				<li><b> ${message(code: 'venue.name.label', default: 'Name')}</b>:
					${fieldValue(bean: venue, field: "name")}</li>
				.........................................................................................
				</br>
				<b>SubType:</b>

				<g:each in="${subServiceTypeList}" status="i" var="subServiceType">
					<ul class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<li>
							${fieldValue(bean: subServiceType, field: "subType")}
						</li>
					</ul>
				</g:each>
				.........................................................................................
				</br>
				<li><b>
						${message(code: 'venue.website.label', default: 'Website')}
				</b>: ${fieldValue(bean: venue, field: "website")}</li>
				.........................................................................................
				</br>
				<li><b>
						${message(code: 'venue.cost.label', default: 'Cost')}
				</b>: ${venue.cost}</li>
				.........................................................................................
				</br>
				<li><b>
						${message(code: 'venue.maxCapacity.label', default: 'Max Capacity')}
				</b>: ${venue.maxCapacity}</li>
				.........................................................................................
				</br>
				<li><b>
						${message(code: 'venue.ac.label', default: 'Ac')}
				</b>: ${venue.ac}</li>
				.........................................................................................
				</br>
				<li><b> ${message(code: 'venue.description.label', default: 'Description')}</b>:
					${fieldValue(bean: venue, field: "description")}</li>
				.........................................................................................
				</br>
				<li><b>
						${message(code: 'address.line.label', default: 'Line')}
				</b>: ${fieldValue(bean: venue.address, field: "line")}</li>

				<li><b> ${message(code: 'address.place.label', default: 'Place')}</b>:
					${fieldValue(bean: venue.address, field: "place")}</li>

				<li><b>
						${message(code: 'address.city.label', default: 'City')}
				</b>: ${fieldValue(bean: venue.address, field: "city")}</li>

				<li><b>
						${message(code: 'address.pincode.label', default: 'Pincode')}
				</b>: ${venue.address.pincode}</li>
				.........................................................................................
				</br>
				<li><b>
						${message(code: 'address.phoneNumber.label', default: 'Phone Number')}
				</b>: ${venue.address.phoneNumber}</li>
				.........................................................................................
				</br>

				<li><strong>rating</strong>: ${rate}</li>
				<li><g:if test="${session.getAttribute("user")!=null}">
						<g:form controller="CommentAndRate" action="saveVenueRate">
							<g:hiddenField name="venueId" value="${venue.id}" />
							<g:select name="rating" from="${1..5}" value="${rating}"
								noSelection="['':'-Choose your rate-']" />
							<%--<g:radio name="rating" value="1" /> 1
							<g:radio name="rating" value="2" /> 2
							<g:radio name="rating" value="3" /> 3 
							<g:radio name="rating" value="4" />  4
							<g:radio name="rating" value="5" /> 5
							--%>
							<g:submitButton name="rate" class="save"
								value="${message(code: 'default.button.rate.label', default: 'Rate')}" />
						</g:form>
					</g:if></li>
				</br> 
				******************<strong>Comments</strong>*******************
				</br>

				<li><g:each in="${commentVenueList}" status="i"
						var="commentVenue">
						<ul class="${(i % 2) == 0 ? 'even' : 'odd'}">
							<li><strong> ${fieldValue(bean: commentVenue.user, field: "userName")}:
							</strong> ${fieldValue(bean: commentVenue, field: "review")}</li>
						</ul>
					</g:each></li>

				<li><g:if test="${proVar=="0"}">
						<g:form controller="Venue" action="updateVenue">
							<g:submitButton name="edit" class="save"
								value="${message(code: 'default.button.edit.label', default: 'Edit')}" />
							<g:hiddenField name="venueId" value="${venue.id}" />
						</g:form>
						<g:form controller="Venue" action="delete">
							<g:submitButton name="delete" class="save"
								value="${message(code: 'default.button.delete.label', default: 'Delete')}" />
							<g:hiddenField name="venueId" value="${venue.id}" />
						</g:form>
					</g:if></li>
				<li><g:if test="${session.getAttribute("user")!=null}">
						<g:form controller="CommentAndRate" action="saveVenueComment">
							<g:hiddenField name="venueId" value="${venue.id}" />
							<g:textArea name="review" value="${commentVenue?.review}" />
							<g:submitButton name="comment" class="save"
								value="${message(code: 'default.button.comment.label', default: 'Comment')}" />
						</g:form>
					</g:if></li>
			</ul>
		</div>
	</div>
</body>
</html>

