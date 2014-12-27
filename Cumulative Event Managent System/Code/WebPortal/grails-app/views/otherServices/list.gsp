
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
			<g:form controller="OtherServices" action="searchResults">
				<ul>
					<li><g:if test="${serviceType.id==2}">

							<g:select name="searchSubType"
								from="${["Marriage","Birthday","Party","Function"]}"
								value="${searchSubType}"
								noSelection="['':'-Choose your category-']" />


							<%--<g:radio name="searchSubType" value="Marriage" />Marriage
							<g:radio name="searchSubType" value="Birthday" /> Birthday <g:radio
								name="searchSubType" value="Party" />Party <g:radio
								name="searchSubType" value="Function" /> Function</li>
								
						--%>
						</g:if> <g:if test="${serviceType?.id==3}">


							<g:select name="searchSubType" from="${["indian","continental"]}"
								value="${searchSubType}"
								noSelection="['':'-Choose your category-']" />

							<%--<g:radio name="searchSubType" value="indian" />indian
							<g:radio name="searchSubType" value="continental" /> continental 
					--%>
						</g:if> <g:if test="${serviceType?.id==4}">

							<g:select name="searchSubType" from="${["rock","classical"]}"
								value="${searchSubType}"
								noSelection="['':'-Choose your category-']" />

							<%--<g:radio name="searchSubType" value="rock" />rock
							<g:radio name="searchSubType" value="classical" /> classical 
					--%>

						</g:if></li>
					<li>
						<div>name:</div>
						<div>
							<g:textField name="searchName" value="" />
						</div>
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

					<g:hiddenField name="serviceTypeId" value="${serviceType.id}" />
					<li><g:submitButton name="search" class="save"
							value="${message(code: 'default.button.search.label', default: 'Search')}" />
					</li>

				</ul>
			</g:form>
		</div>
	</g:if>

	<div id="contentBlock">
		<div id="list-otherServices" class="content scaffold-list" role="main">
			<h1>List</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">
					${flash.message}
				</div>
			</g:if>
			<g:each in="${otherServicesInstanceList}" status="i"
				var="otherServicesInstance">

				<ul class="${(i % 2) == 0 ? 'even' : 'odd'}">

					<li>
						${fieldValue(bean: otherServicesInstance, field: "name")}
					</li>
					<li>
						${fieldValue(bean: otherServicesInstance.address, field: "place")},
						${fieldValue(bean: otherServicesInstance.address, field: "city")}
					</li>
					<li><g:form controller="OtherServices" action="fullDetails">
							<g:hiddenField name="proVar" value="${name}" />
							<g:hiddenField name="otherServicesId"
								value="${otherServicesInstance.id}" />
							<g:submitButton name="seeFullDetails" class="save"
								value="${message(code: 'default.button.seeFullDetails.label', default: 'See FullDetails')}" />

						</g:form></li>
				</ul>
				.........................................................................................
			</g:each>

			<%--<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'otherServices.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="website" title="${message(code: 'otherServices.website.label', default: 'Website')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'otherServices.description.label', default: 'Description')}" />
					    
					    // <g:sortableColumn property="type" title="${message(code: 'serviceType.line.label', default: 'serviceType')}" />
					    
					    <g:sortableColumn property="line" title="${message(code: 'address.line.label', default: 'Line')}" />
					
						<g:sortableColumn property="place" title="${message(code: 'address.place.label', default: 'Place')}" />
					
						<g:sortableColumn property="city" title="${message(code: 'address.city.label', default: 'City')}" />
					
						<g:sortableColumn property="pincode" title="${message(code: 'address.pincode.label', default: 'Pincode')}" />
					
						<g:sortableColumn property="phoneNumber" title="${message(code: 'address.phoneNumber.label', default: 'Phone Number')}" />
			
					
						
					</tr>
				</thead>
				<tbody>
				<g:each in="${otherServicesInstanceList}" status="i" var="otherServicesInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
					
					
					
						<td><g:link action="show" id="${otherServicesInstance.id}">${fieldValue(bean: otherServicesInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: otherServicesInstance, field: "website")}</td>
					
						<td>${fieldValue(bean: otherServicesInstance, field: "description")}</td>
						<td><g:link action="show" id="${otherServicesInstance.serviceType?.id}">${fieldValue(bean: otherServicesInstance.serviceType, field: "type")}</g:link></td>
						
						<td><g:link action="show" id="${otherServicesInstance.address?.id}">${fieldValue(bean: otherServicesInstance.address, field: "line")}</g:link></td>
					
						<td>${fieldValue(bean: otherServicesInstance.address, field: "place")}</td>
					
						<td>${fieldValue(bean: otherServicesInstance.address, field: "city")}</td>
					
						<td>${fieldValue(bean: otherServicesInstance.address, field: "pincode")}</td>
					
						<td>${fieldValue(bean: otherServicesInstance.address, field: "phoneNumber")}</td>
						
					
					</tr>
				</g:each>
				</tbody>
			</table>
			--%>
			<%--<div class="pagination">
				<g:paginate total="${otherServicesInstanceTotal}" />
			</div>
		--%></div>
	</div>
	<%--<script type="text/javascript">
function showOtherServices(id){
	
	$.ajax({
		 type:"GET",
		  url: './fullDetails',
		  data:{otherServicesId:id},
		  success: function(response) {
			 
		    $('#list-otherServices').html(response);
		  }
		});
}
</script>
--%>
</body>
</html>
