
<%@ page import="com.WebPortal.domain.OtherServices"%>
<!doctype html>
<html>
<head>
<meta name="layout" content="main">
<g:set var="entityName"
	value="${message(code: 'otherServices.label', default: 'OtherServices')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
<g:javascript library="jquery" />
<g:javascript library="jquery-ui" />
</head>
<body>

	<%--<a href="#list-otherServices" class="skip" tabindex="-1"><g:message
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
	<div id="list-otherServices" class="content scaffold-list" role="main">
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>

		<div id="contentBlock">

			<ul>
				<li>
					<b>${message(code: 'otherServices.name.label', default: 'Name')}</b>: ${fieldValue(bean: otherServicesInstance, field: "name")}
				</li>
				.........................................................................................
				</br>
				<b>SubType</b>:

				<g:each in="${subServiceTypeList}" status="i" var="subServiceType">
					<ul class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<li>
							${fieldValue(bean: subServiceType, field: "subType")}
						</li>
					</ul>
				</g:each>
.........................................................................................
				</br>
				<li>
					<b>${message(code: 'otherServices.website.label', default: 'Website')}</b>:
					${fieldValue(bean: otherServicesInstance, field: "website")}
				</li>
				.........................................................................................
				</br>
				<b> Address</b>:
				<li>
					${fieldValue(bean: otherServicesInstance.address, field: "line")}, ${fieldValue(bean: otherServicesInstance.address, field: "place")},
					${fieldValue(bean: otherServicesInstance.address, field: "city")}, ${otherServicesInstance.address.pincode}
				</li>
				.........................................................................................
				</br>
				<li><b>Phone Number</b>: ${otherServicesInstance.address.phoneNumber}
				</li>
				.........................................................................................
				</br>
				<li>
				<b>	${message(code: 'otherServices.description.label', default: 'Description')}</b>:${fieldValue(bean: otherServicesInstance, field: "description")}
				</li>
				.........................................................................................
				</br>
				<li><strong>rating</strong>: ${rate}</li>
				<li><g:if test="${session.getAttribute("user")!=null}">
				<g:form controller="CommentAndRate" action="saveOtherServicesRate">
							<g:hiddenField name="otherServicesId"
								value="${otherServicesInstance.id}" />
							<g:select name="rating" from="${1..5}" value="${rating}"
								noSelection="['':'-Choose your rate-']" />
							<%--<g:radio name="rating" value="1" /> 1
							<g:radio name="rating" value="2" /> 2
							<g:radio name="rating" value="3" /> 3 
							<g:radio name="rating" value="4" />  4
							<g:radio name="rating" value="5" /> 5
							--%><g:submitButton name="rate" class="save"
								value="${message(code: 'default.button.rate.label', default: 'Rate')}" />

						</g:form>

					</g:if></li>
				</br>
				******************<strong>Comments</strong>*******************
				<li><g:each in="${commentOtherServicesList}" status="i"
						var="commentOtherServices">
						<ul class="${(i % 2) == 0 ? 'even' : 'odd'}">
							<li><strong> ${fieldValue(bean: commentOtherServices.user, field: "userName")}:
							</strong> ${fieldValue(bean: commentOtherServices, field: "review")}</li>
						</ul>
					</g:each></li>
				<li><g:if test="${proVar=="0"}">
						<g:form controller="OtherServices" action="updateOtherServices">
							<g:submitButton name="edit" class="save"
								value="${message(code: 'default.button.edit.label', default: 'Edit')}" />
							<g:hiddenField name="otherServicesId"
								value="${otherServicesInstance.id}" />
						</g:form>
						<g:form controller="OtherServices" action="delete">
							<g:submitButton name="delete" class="save"
								value="${message(code: 'default.button.delete.label', default: 'Delete')}" />
							<g:hiddenField name="otherServicesId"
								value="${otherServicesInstance.id}" />
						</g:form>

					</g:if></li>
				<li><g:if test="${session.getAttribute("user")!=null}">
						<g:form controller="CommentAndRate"
							action="saveOtherServicesComment">
							<g:hiddenField name="otherServicesId"
								value="${otherServicesInstance.id}" />
							<g:textArea name="review" value="${commentOtherServices?.review}" />
							<g:submitButton name="comment" class="save"
								value="${message(code: 'default.button.comment.label', default: 'Comment')}" />
						</g:form>
					
					</g:if></li>

			</ul>

		</div>
	</div>
</body>
</html>
