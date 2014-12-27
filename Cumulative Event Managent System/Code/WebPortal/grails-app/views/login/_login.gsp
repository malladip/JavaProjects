<div id="contentBlock">
<g:form controller="Login" action="checkLogin">

<g:if test="${details1=="z"}">
			<h3>You have successfully registered with us</br>Please login for the first time</h3>
			</g:if>
		<div
			class="fieldcontain ${hasErrors(bean: userInstance, field: 'userName', 'error')} required">
			<label for="userName"> <g:message code="user.userName.label"
					default="User Name" /> <span class="required-indicator">*</span>
			</label>
	</div>
	<div>
			<g:textField name="userName" required=""
				value="${userInstance?.userName}" />
	</div>
	


		<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
			<label for="password"> <g:message code="user.password.label"
					default="Password" /> <span class="required-indicator">*</span>
			</label>
	</div>
	<div>
			<g:passwordField name="password" required=""
				value="${userInstance?.password}" />
		</div>

		<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'loginType', 'error')} required">
			<label for="gender"> <g:message code="user.loginType.label"
					default="LoginType" /> <span class="required-indicator">*</span>
			</label>

			<g:radio name="loginType" value="1" />
			User

			<g:radio name="loginType" value="0" />
			Provider
		</div>

		<%--<div id="contentBlock">
			--%>
			<div>

			<g:if test="${details1=="x"}">
			please enter valid details
			</g:if>
			</div>
			<fieldset class="buttons">
				<g:submitButton name="login" class="save"
					value="${message(code: 'default.button.login.label', default: 'Login')}" />
			</fieldset>

</g:form>
</div>
<div id="rightBlock">
<div>
To comment and rate services, register with us 
</div>
<g:form controller="User" action="createIndex">
	<g:submitButton name="registerUser" class="save"
		value="${message(code: 'default.button.registerUser.label', default: 'User Register')}" />
</g:form>
<div>
To publish your services services,register with us 
</div>
<g:form controller="Provider" action="createIndex">
	<g:submitButton name="registerProvider" class="save"
		value="${message(code: 'default.button.registerProvider.label', default: 'Provider Register')}" />
</g:form>
</div>
