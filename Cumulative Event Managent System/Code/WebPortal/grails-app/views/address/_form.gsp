<%@ page import="com.WebPortal.domain.Address" %>



<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'line', 'error')} ">
	<label for="line">
		<g:message code="address.line.label" default="Line" />
		
	</label>
	<g:textField name="line" value="${addressInstance?.line}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'place', 'error')} required">
	<label for="place">
		<g:message code="address.place.label" default="Place" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="place" required="" value="${addressInstance?.place}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'city', 'error')} required">
	<label for="city">
		<g:message code="address.city.label" default="City" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="city" required="" value="${addressInstance?.city}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'pincode', 'error')} required">
	<label for="pincode">
		<g:message code="address.pincode.label" default="Pincode" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="pincode" required="" value="${fieldValue(bean: addressInstance, field: 'pincode')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: addressInstance, field: 'phoneNumber', 'error')} required">
	<label for="phoneNumber">
		<g:message code="address.phoneNumber.label" default="Phone Number" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="phoneNumber" required="" value="${fieldValue(bean: addressInstance, field: 'phoneNumber')}"/>
</div>

