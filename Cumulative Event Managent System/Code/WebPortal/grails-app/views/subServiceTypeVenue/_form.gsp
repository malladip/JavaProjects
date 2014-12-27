<%@ page import="com.WebPortal.domain.SubServiceTypeVenue" %>



<div class="fieldcontain ${hasErrors(bean: subServiceTypeVenueInstance, field: 'subType', 'error')} ">
	<label for="subType">
		<g:message code="subServiceTypeVenue.subType.label" default="Sub Type" />
		
	</label>
	<g:textField name="subType" value="${subServiceTypeVenueInstance?.subType}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: subServiceTypeVenueInstance, field: 'venue', 'error')} required">
	<label for="venue">
		<g:message code="subServiceTypeVenue.venue.label" default="Venue" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="venue" name="venue.id" from="${com.WebPortal.domain.Venue.list()}" optionKey="id" required="" value="${subServiceTypeVenueInstance?.venue?.id}" class="many-to-one"/>
</div>

