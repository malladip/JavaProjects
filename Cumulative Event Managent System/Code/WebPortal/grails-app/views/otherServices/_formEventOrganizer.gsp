<%@ page import="com.WebPortal.domain.OtherServices" %>
<%@ page import="com.WebPortal.domain.Address" %>

<div class="fieldcontain ${hasErrors(bean: otherServicesInstance, field: 'name', 'error')} required ">
	<label for="name">
		<g:message code="otherServices.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	</div>
<div>
	<g:textField name="name" required="" value="${otherServicesInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: subServiceTypeOtherServicesInstance, field: 'subType', 'error')} required ">
	<label for="subType">
		<g:message code="subServiceTypeOtherServices.subType.label" default="Sub Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:checkBox name="subType1" checked ="${false}" value="Marriage"/> Marriage
	<g:checkBox name="subType2" checked ="${false}" value="Birthday"/> Birthday
	<g:checkBox name="subType3" checked ="${false}" value="Party"/> Party
	<g:checkBox name="subType4" checked ="${false}" value="Function"/> Function
</div>

<div class="fieldcontain ${hasErrors(bean: otherServicesInstance, field: 'website', 'error')} ">
	<label for="website">
		<g:message code="otherServices.website.label" default="Website" />
		
	</label>
	</div>
<div>
	<g:field type="url" name="website" value="${otherServicesInstance?.website}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'line', 'error')} ">
	<label for="line">
		<g:message code="address.line.label" default="Line" />
		
	</label>
	</div>
<div>
	<g:textField name="line" value="${addressInstance?.line}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'place', 'error')} required">
	<label for="place">
		<g:message code="address.place.label" default="Place" />
		<span class="required-indicator">*</span>
	</label>
	</div>
<div>
	<g:textField name="place" required="" value="${addressInstance?.place}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'city', 'error')} required">
	<label for="city">
		<g:message code="address.city.label" default="City" />
		<span class="required-indicator">*</span>
	</label>
	</div>
<div>
	<g:textField name="city" required="" value="${addressInstance?.city}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'pincode', 'error')} required">
	<label for="pincode">
		<g:message code="address.pincode.label" default="Pincode" />
		<span class="required-indicator">*</span>
	</label>
	</div>
<div>
	<g:field type="number" name="pincode" required="" value="${fieldValue(bean: addressInstance, field: 'pincode')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'phoneNumber', 'error')} required">
	<label for="phoneNumber">
		<g:message code="address.phoneNumber.label" default="Phone Number" />
		<span class="required-indicator">*</span>
	</label>
	</div>
<div>
	<g:field type="number" name="phoneNumber" required="" value="${fieldValue(bean: addressInstance, field: 'phoneNumber')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: otherServicesInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="otherServices.description.label" default="Description" />
		
	</label>
	</div>
<div>
	<g:textArea name="description" value="${otherServicesInstance?.description}"/>
</div>



