<%@ page import="com.WebPortal.domain.OtherServices" %>
<%@ page import="com.WebPortal.domain.Address" %>

<div class="fieldcontain ${hasErrors(bean: otherServices, field: 'name', 'error')} required ">
	<label for="name">
		<g:message code="otherServices.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	</div>
<div>
	<g:textField name="name" required="" value="${otherServices?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: subServiceTypeOtherServicesInstance, field: 'subType', 'error')} required ">
	<label for="subType">
		<g:message code="subServiceTypeOtherServices.subType.label" default="Sub Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:checkBox name="subType1" checked ="${list1.contains("rock")?true:false}" value="rock"/> rock
	<g:checkBox name="subType2" checked ="${list1.contains("classical")?true:false}" value="classical"/> classical
</div>

<div class="fieldcontain ${hasErrors(bean: otherServices, field: 'website', 'error')} ">
	<label for="website">
		<g:message code="otherServices.website.label" default="Website" />
		
	</label>
	</div>
<div>
	<g:field type="url" name="website" value="${otherServices?.website}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: address, field: 'line', 'error')} ">
	<label for="line">
		<g:message code="address.line.label" default="Line" />
		
	</label>
	</div>
<div>
	<g:textField name="line" value="${otherServices.address?.line}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: address, field: 'place', 'error')} required">
	<label for="place">
		<g:message code="address.place.label" default="Place" />
		<span class="required-indicator">*</span>
	</label>
	</div>
<div>
	<g:textField name="place" required="" value="${otherServices.address?.place}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: address, field: 'city', 'error')} required">
	<label for="city">
		<g:message code="address.city.label" default="City" />
		<span class="required-indicator">*</span>
	</label>
	</div>
<div>
	<g:textField name="city" required="" value="${otherServices.address?.city}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: address, field: 'pincode', 'error')} required">
	<label for="pincode">
		<g:message code="address.pincode.label" default="Pincode" />
		<span class="required-indicator">*</span>
	</label>
	</div>
<div>
	<g:field type="number" name="pincode" required="" value="${otherServices.address.pincode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: address, field: 'phoneNumber', 'error')} required">
	<label for="phoneNumber">
		<g:message code="address.phoneNumber.label" default="Phone Number" />
		<span class="required-indicator">*</span>
	</label>
	</div>
<div>
	<g:field type="number" name="phoneNumber" required="" value="${otherServices.address.phoneNumber}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: otherServices, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="otherServices.description.label" default="Description" />
		
	</label>
	</div>
<div>
	<g:textArea name="description" value="${otherServices?.description}"/>
</div>



