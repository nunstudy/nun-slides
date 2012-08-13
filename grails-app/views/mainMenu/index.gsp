<!doctype html>
<html>
	<head>
		<meta name="layout" content="umn"/>
		<title>Nun Slides - Welcome</title>
		<r:require module="raphael" />
	</head>
	<body>
		<%--<div id="status" role="complementary">
			<h1>Application Status</h1>
			<ul>
				<li>App version: <g:meta name="app.version"/></li>
				<li>Grails version: <g:meta name="app.grails.version"/></li>
				<li>Groovy version: ${org.codehaus.groovy.runtime.InvokerHelper.getVersion()}</li>
				<li>JVM version: ${System.getProperty('java.version')}</li>
				<li>Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</li>
				<li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
				<li>Domains: ${grailsApplication.domainClasses.size()}</li>
				<li>Services: ${grailsApplication.serviceClasses.size()}</li>
				<li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>
			</ul>
			<h1>Installed Plugins</h1>
			<ul>
				<g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
					<li>${plugin.name} - ${plugin.version}</li>
				</g:each>
			</ul>
		</div> --%>
		<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
		</g:if>

       	<div class="title-bar">
	       	<div class="title-bar-left">
		       	<%--<h1 style="font-size:3.0em;padding:0;margin:0;">Slide Management</h1> --%>
		       	<h1>Slide Management</h1>
	       	</div>
	       	<div class="title-bar-right">
				<g:form name="searchForm" method="post" controller="nunId" action="find" >			
					<g:textField class="mainSearchBox" name="id" title="Search by Aperio or Autopsy ID..." value="Search by Aperio or Autopsy ID..." /><g:submitButton class="mainSearchButton" name="Find" />
				</g:form>
	       	</div>       	
       	</div>
		<div id="page-body" role="main" class="intro">
            <%-- <p>This application allows authenticated users to access and manage slide data associated with nun study participants.</p>--%>
            
            <%--<p>Note: To manage administrative data for the nun study, please visit the <a href="https://secure.healthstudies.umn.edu/nun-manage" title="Go to Nun Manage" target="_blank">Nun Manage Application</a>. To view or edit gross reports, microscopic findings or plaques and tangles, please visit the
            <a href="https://secure.healthstudies.umn.edu/nun-brainlab" title="Go to Neuropathology" target="_blank">Neuropathology Application</a>. 
            </p> --%>
			
			<%--<div id="infoMessage" class="message" role="status"></div> --%>
			<div class="start">
				
				<%--<g:form name="searchForm" method="post" controller="nunId" action="find" >			
					<div id="search">
						<strong>Start here -></strong> <g:textField class="searchBox" name="id" title="Search by Aperio or Autopsy ID..." value="Search by Aperio or Autopsy ID..." />
					</div>
				</g:form> --%>
	
				<div class="subjectListMain">
					<g:link class="list" controller="aperioNun" action="list">Subject List</g:link>
				</div>
			</div>
			
		</div>
	</body>
</html>
