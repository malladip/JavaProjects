
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
		<%--<g:set var="name" value="${name}" />--%>

		<g:if test="${created=="y"}">
			<h2>successfully created</h2>
		</g:if>
		<g:if test="${updated=="y"}">
			<h2>successfully updated</h2>
		</g:if>
		<g:if test="${deleted=="y"}">
			<h2>successfully deleted</h2>
		</g:if>
		<g:if test="${inValid=="y"}">
			<h2>
				invalid details</br>update failed
			</h2>
		</g:if>
		<g:if test="${name!="0"}">
			<div id="rightBlock">
				<div>
					<h1>Search</h1>
				</div>
				<g:form controller="Venue" action="searchResults">
					<ul>
						<li><g:select name="searchSubType"
								from="${["Marriage","Birthday","Party","Function"]}"
								value="${searchSubType}"
								noSelection="['':'-Choose your category-']" /> <%--<g:radio name="searchSubType" value="Marriage" />Marriage
							<g:radio name="searchSubType" value="Birthday" /> Birthday <g:radio
								name="searchSubType" value="Party" />Party <g:radio
								name="searchSubType" value="Function" /> Function--%></li>
						<li>
							<div>name:</div>
							<div>
								<g:textField name="searchName" value="" />
							</div>
						</li>
						<li>
							<div>cost(per day):</div>
							<div>
								<g:textField name="searchCost" value="" />
							</div>
						</li>
						<li>
							<div>max capacity:</div>
							<div>
								<g:textField name="searchMaxCapacity" value="" />
							</div>
						</li>
						<li><g:checkBox name="searchAc" checked="${false}" value="1" />AC
						</li>
						<li>
							<div>place:</div>
							<div>
								<g:textField name="searchPlace" value="" />
							</div>
						</li>
						<li>
							<div>city:</div>
							<div>
								<g:textField name="searchCity" value="" />
							</div>
						</li>

						<li><g:submitButton name="search" class="save"
								value="${message(code: 'default.button.search.label', default: 'Search')}" />
						</li>

					</ul>
				</g:form>
			</div>
		</g:if>
		<div id="contentBlock">
			<h1>List</h1>
			<g:each in="${venueInstanceList}" status="i" var="venueInstance">

				<ul class="${(i % 2) == 0 ? 'even' : 'odd'}">

					<%--
					
					
					<%--<li><a onclick="javascript:showVenue(${venueInstance.id});"
						style="cursor: pointer;" id="${venueInstance.id}"> ${fieldValue(bean: venueInstance, field: "name")}
					</a></li>
					--%>

					<%--<li><g:link controller="Venue" action="fullDetails" id="${fieldValue(bean: venueInstance, field: "name")}">
							${fieldValue(bean: venueInstance, field: "name")}
						</g:link></li>
					--%>

					<li>
						${fieldValue(bean: venueInstance, field: "name")}
					</li>

					<li>
						${fieldValue(bean: venueInstance.address, field: "place")}, ${fieldValue(bean: venueInstance.address, field: "city")}
					</li>
					<li><g:form controller="Venue" action="fullDetails">
							<g:hiddenField name="proVar" value="${name}" />
							<g:hiddenField name="venueId" value="${venueInstance.id}" />
							<g:submitButton name="seeFullDetails" class="save"
								value="${message(code: 'default.button.seeFullDetails.label', default: 'See FullDetails')}" />

						</g:form></li>
					<%--<li><g:if test="${name=="0"}">
							<g:form controller="Venue" action="update">
								<g:submitButton name="update" class="save"
									value="${message(code: 'default.button.update.label', default: 'Update')}" />
							</g:form>
							<g:form controller="Venue" action="delete">
								<g:submitButton name="delete" class="save"
									value="${message(code: 'default.button.delete.label', default: 'Delete')}" />
							</g:form>
						</g:if></li>
				--%>
				</ul>
			.........................................................................................
			</g:each>

			<%--<div class="pagination">
				<g:paginate total="${venueInstanceTotal}" />
			</div>
		--%>
		</div>
	</div>
	<%--<script type="text/javascript">
function showVenue(id){
	
	$.ajax({
		 type:"GET",
		  url: './fullDetails',
		  data:{venueId:id},
		  success: function(response) {
			  
		    $('#list-venue').html(response);
		    
		  }
		});
}
</script>
--%>
</body>
</html>
