<%@ page import="com.WebPortal.domain.Provider" %>

<div class="fieldcontain ${hasErrors(bean: providerInstance, field: 'organizationName', 'error')} required">
	<label for="organizationName">
		<g:message code="provider.organizationName.label" default="Organization Name" />
			<span class="required-indicator">*</span>
	</label>
	</div>
	<div>
	<g:textField name="organizationName" required="" maxlength="45" value="${providerInstance?.organizationName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: providerInstance, field: 'userName', 'error')} required">
	<label for="userName">
		<g:message code="provider.userName.label" default="User Name" />
			<span class="required-indicator">*</span>
	</label>
	</div>
	<div>
	<g:textField name="userName" required="" maxlength="25" value="${providerInstance?.userName}"/>
</div>


<div class="fieldcontain ${hasErrors(bean: providerInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="provider.password.label" default="Password" />
			<span class="required-indicator">*</span>
	</label>
	</div>
	<div>
	<g:passwordField name="password" required="" value="${providerInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: providerInstance, field: 'contactName', 'error')} required">
	<label for="contactName">
		<g:message code="provider.contactName.label" default="Contact Name" />
			<span class="required-indicator">*</span>
	</label>
	</div>
	<div>
	<g:textField name="contactName" required=""  maxlength="45" value="${providerInstance?.contactName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: providerInstance, field: 'contactNumber', 'error')} required">
	<label for="contactNumber">
		<g:message code="provider.contactNumber.label" default="Contact Number" />
		<span class="required-indicator">*</span>
	</label>
	</div>
	<div>
	<g:field type="number" name="contactNumber" required="" value="${fieldValue(bean: providerInstance, field: 'contactNumber')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: providerInstance, field: 'emailId', 'error')} required">
	<label for="emailId">
		<g:message code="provider.emailId.label" default="Email Id" />
			<span class="required-indicator">*</span>
	</label>
	</div>
	<div>
	<g:field type="email" name="emailId" required="" value="${providerInstance?.emailId}"/>
</div>


