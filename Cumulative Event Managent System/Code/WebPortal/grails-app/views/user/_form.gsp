<%@ page import="com.WebPortal.domain.User" %>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="user.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	</div>
	<div>
	<g:textField name="firstName" required="" value="${userInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'lastName', 'error')} required ">
	<label for="lastName">
		<g:message code="user.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	</div>
	<div>
	<g:textField name="lastName" required="" value="${userInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'userName', 'error')} required">
	<label for="userName">
		<g:message code="user.userName.label" default="User Name" />
		<span class="required-indicator">*</span>
	</label>
	</div>
	<div>
	<g:textField name="userName" required="" value="${userInstance?.userName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="user.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	</div>
	<div>
	<g:passwordField name="password" required="" value="${userInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'gender', 'error')} required">
	<label for="gender">
		<g:message code="user.gender.label" default="Gender" />
		<span class="required-indicator">*</span>
	</label>

<!--<g:radio name="gender" value="${userInstance?.gender}"/>  -->
	
	<g:radio name="gender" value="M"/> MALE 
	
	<g:radio name="gender" value="F"/> FEMALE
</div>


<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'emailId', 'error')} ">
	<label for="emailId">
		<g:message code="user.emailId.label" default="Email Id" />
		
	</label>
	</div>
	<div>
	<g:textField name="emailId" value="${userInstance?.emailId}"/>
</div>


<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'mobile', 'error')}  ">
	<label for="mobile">
		<g:message code="user.mobile.label" default="Mobile" />

	</label>
	</div>
	<div>
	<g:field type="number" name="mobile" value="${fieldValue(bean: providerInstance, field: 'contactNumber')}"/>
</div>




