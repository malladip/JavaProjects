<div class="fieldcontain ${hasErrors(bean: otherServicesInstance, field: 'serviceType', 'error')} required">
	<label for="serviceType">
		<g:message code="otherServices.serviceType.label" default="Service Type" />
		<span class="required-indicator">*</span>
	</label>
		
		<g:radio name="serviceType" value="2"/> Event Organizer
		<g:radio name="serviceType" value="3"/> Food Supplier
	    <g:radio name="serviceType" value="4"/> Music Provider 
	    
</div>