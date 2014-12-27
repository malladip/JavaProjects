
<!doctype html>
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<link rel="stylesheet"
	href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
<link rel="shortcut icon"
	href="${resource(dir: 'images', file: 'favicon.ico')}"
	type="image/x-icon">
<link rel="stylesheet"
	href="${resource(dir: 'css', file: 'default.css')}" type="text/css">
<r:layoutResources />
</head>
<body>

	<div id="grailsLogo" role="banner">
		<a href="http://grails.org"><img
			src="${resource(dir: 'images', file: 'grails_logo.png')}"
			alt="Grails" /></a>
	</div>
	<div></div>
	<div class="footer" role="contentinfo"></div>
	<div id="spinner" class="spinner" style="display: none;">
		<g:message code="spinner.alt" default="Loading&hellip;" />
	</div>
	<g:javascript library="application" />
	<r:layoutResources />

	<!-- Accessibility items - do not remove !!! -->
	<ul class="noscreen">
		<li><a href="#content">Přeskočit na obsah</a></li>
		<li><a href="#mainMenu">Přeskočit na menu</a></li>
	</ul>

	<hr class="hidden" />

	<!-- View -  -->
	<div id="view">
		<!-- Header (logotype, search, menus) -->
		<div id="head">
			<h1 id="logotype"><b>CELEBRATIONS</b></h1>
			<form action="" method="post" id="searchForm">
				<fieldset>

					<g:if test="${session.userId}">
						<g:link controller="Login" action="logoutProvider">
	            	Logout
	            </g:link>
					</g:if>
					<g:if test="${session.user}">
						<g:link controller="Login" action="logoutUser">
	            	Logout
	            </g:link>
					</g:if>
				</fieldset>
			</form>
		</div>
		<!-- // Header -->

		<hr class="hidden" />

		<!-- Main content -->
		<div id="content">

			<!-- Left content part -->
			<div id="contentBlock">
				<%--
          <h2 class="subheader biggest">Web Portal</h2>
	
          --%>
			</div>
			<!-- // Item -->

			<g:layoutBody />

			<!-- // ContentBlock -->

			<hr class="hidden" />


		</div>
		<!-- // Content -->

		<hr class="hidden noprint" />

		<!-- Main menu and submenu -->
		<div id="menu">
			<ul id="mainMenu">
				<li><g:if test="${session.userId}">
						<g:link controller="Login" action="providerHome">Home</g:link>
					</g:if></li>

				<li><g:if test="${session.user}">
						<g:link controller="Login" action="userHome">Home</g:link>
					</g:if></li>

				<li><g:if test="${session.userId==null&&session.user==null}">
						<g:link controller="Login" action="index">Home</g:link>
					</g:if></li>


				<li><g:link controller="Venue" action="list">Venues</g:link></li>


				<li><g:link controller="OtherServices"
						action="listEventOrganizers">EventOrganizers</g:link></li>

				<li><g:link controller="OtherServices"
						action="listFoodSuppliers">FoodSuppliers</g:link></li>

				<li><g:link controller="OtherServices"
						action="listMusicProviders">MusicProviders</g:link></li>

				<%--<li><a href="">Help</a></li>
        --%>
			</ul>

		</div>
		<!-- // Menu -->
		<hr class="hidden noprint" />


		<!-- Web footer -->
		<div id="foot"></div>
		<!-- // Foot -->

	</div>
	<!-- // View -->

</body>
</html>