
<%@ page import="org.nunstudy.pathology.AperioNun" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'aperioNun.label', default: 'AperioNun')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-aperioNun" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-aperioNun" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list aperioNun">
			
				<g:if test="${aperioNunInstance?.autopId}">
				<li class="fieldcontain">
					<span id="autopId-label" class="property-label"><g:message code="aperioNun.autopId.label" default="Autop Id" /></span>
					
						<span class="property-value" aria-labelledby="autopId-label"><g:fieldValue bean="${aperioNunInstance}" field="autopId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${aperioNunInstance?.blocks}">
				<li class="fieldcontain">
					<span id="blocks-label" class="property-label"><g:message code="aperioNun.blocks.label" default="Blocks" /></span>
					
						<span class="property-value" aria-labelledby="blocks-label"><g:fieldValue bean="${aperioNunInstance}" field="blocks"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${aperioNunInstance?.stains}">
				<li class="fieldcontain">
					<span id="stains-label" class="property-label"><g:message code="aperioNun.stains.label" default="Stains" /></span>
					
						<span class="property-value" aria-labelledby="stains-label"><g:fieldValue bean="${aperioNunInstance}" field="stains"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${aperioNunInstance?.aperio}">
				<li class="fieldcontain">
					<span id="aperio-label" class="property-label"><g:message code="aperioNun.aperio.label" default="Aperio" /></span>
					
						<span class="property-value" aria-labelledby="aperio-label"><g:fieldValue bean="${aperioNunInstance}" field="aperio"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${aperioNunInstance?.id}" />
					<g:link class="edit" action="edit" id="${aperioNunInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
