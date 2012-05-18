
<%@ page import="org.nunstudy.pathology.NunId" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'nunId.label', default: 'NunId')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-nunId" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-nunId" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list nunId">
			
				<g:if test="${nunIdInstance?.autopId}">
				<li class="fieldcontain">
					<span id="autopId-label" class="property-label"><g:message code="nunId.autopId.label" default="Autop Id" /></span>
					
						<span class="property-value" aria-labelledby="autopId-label"><g:fieldValue bean="${nunIdInstance}" field="autopId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${nunIdInstance?.aperioId}">
				<li class="fieldcontain">
					<span id="aperioId-label" class="property-label"><g:message code="nunId.aperioId.label" default="Aperio Id" /></span>
					
						<span class="property-value" aria-labelledby="aperioId-label"><g:fieldValue bean="${nunIdInstance}" field="aperioId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${nunIdInstance?.aperioCode}">
				<li class="fieldcontain">
					<span id="aperioCode-label" class="property-label"><g:message code="nunId.aperioCode.label" default="Aperio Code" /></span>
					
						<span class="property-value" aria-labelledby="aperioCode-label"><g:fieldValue bean="${nunIdInstance}" field="aperioCode"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${nunIdInstance?.id}" />
					<g:link class="edit" action="edit" id="${nunIdInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
