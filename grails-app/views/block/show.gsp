
<%@ page import="org.nunstudy.pathology.Block" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'block.label', default: 'Block')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-block" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-block" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list block">
			
				<g:if test="${blockInstance?.code}">
				<li class="fieldcontain">
					<span id="code-label" class="property-label"><g:message code="block.code.label" default="Code" /></span>
					
						<span class="property-value" aria-labelledby="code-label"><g:fieldValue bean="${blockInstance}" field="code"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.nun}">
				<li class="fieldcontain">
					<span id="nun-label" class="property-label"><g:message code="block.nun.label" default="Nun" /></span>
					
						<span class="property-value" aria-labelledby="nun-label"><g:link controller="nun" action="show" id="${blockInstance?.nun?.id}">${blockInstance?.nun?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.blockArea}">
				<li class="fieldcontain">
					<span id="blockArea-label" class="property-label"><g:message code="block.blockArea.label" default="Block Area" /></span>
					
						<span class="property-value" aria-labelledby="blockArea-label"><g:link controller="blockArea" action="show" id="${blockInstance?.blockArea?.id}">${blockInstance?.blockArea?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.subArea}">
				<li class="fieldcontain">
					<span id="subArea-label" class="property-label"><g:message code="block.subArea.label" default="Sub Area" /></span>
					
						<span class="property-value" aria-labelledby="subArea-label"><g:link controller="subArea" action="show" id="${blockInstance?.subArea?.id}">${blockInstance?.subArea?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.areaOtherText}">
				<li class="fieldcontain">
					<span id="areaOtherText-label" class="property-label"><g:message code="block.areaOtherText.label" default="Area Other Text" /></span>
					
						<span class="property-value" aria-labelledby="areaOtherText-label"><g:fieldValue bean="${blockInstance}" field="areaOtherText"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.lesion}">
				<li class="fieldcontain">
					<span id="lesion-label" class="property-label"><g:message code="block.lesion.label" default="Lesion" /></span>
					
						<span class="property-value" aria-labelledby="lesion-label"><g:formatBoolean boolean="${blockInstance?.lesion}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.infarction}">
				<li class="fieldcontain">
					<span id="infarction-label" class="property-label"><g:message code="block.infarction.label" default="Infarction" /></span>
					
						<span class="property-value" aria-labelledby="infarction-label"><g:formatBoolean boolean="${blockInstance?.infarction}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.missing}">
				<li class="fieldcontain">
					<span id="missing-label" class="property-label"><g:message code="block.missing.label" default="Missing" /></span>
					
						<span class="property-value" aria-labelledby="missing-label"><g:formatBoolean boolean="${blockInstance?.missing}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.demented}">
				<li class="fieldcontain">
					<span id="demented-label" class="property-label"><g:message code="block.demented.label" default="Demented" /></span>
					
						<span class="property-value" aria-labelledby="demented-label"><g:formatBoolean boolean="${blockInstance?.demented}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.slideSourceId}">
				<li class="fieldcontain">
					<span id="slideSourceId-label" class="property-label"><g:message code="block.slideSourceId.label" default="Slide Source Id" /></span>
					
						<span class="property-value" aria-labelledby="slideSourceId-label"><g:fieldValue bean="${blockInstance}" field="slideSourceId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.hemisphere}">
				<li class="fieldcontain">
					<span id="hemisphere-label" class="property-label"><g:message code="block.hemisphere.label" default="Hemisphere" /></span>
					
						<span class="property-value" aria-labelledby="hemisphere-label"><g:link controller="hemisphere" action="show" id="${blockInstance?.hemisphere?.id}">${blockInstance?.hemisphere?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.label}">
				<li class="fieldcontain">
					<span id="label-label" class="property-label"><g:message code="block.label.label" default="Label" /></span>
					
						<span class="property-value" aria-labelledby="label-label"><g:fieldValue bean="${blockInstance}" field="label"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.dateDeleted}">
				<li class="fieldcontain">
					<span id="dateDeleted-label" class="property-label"><g:message code="block.dateDeleted.label" default="Date Deleted" /></span>
					
						<span class="property-value" aria-labelledby="dateDeleted-label"><g:formatDate date="${blockInstance?.dateDeleted}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.dateCreated}">
				<li class="fieldcontain">
					<span id="dateCreated-label" class="property-label"><g:message code="block.dateCreated.label" default="Date Created" /></span>
					
						<span class="property-value" aria-labelledby="dateCreated-label"><g:formatDate date="${blockInstance?.dateCreated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.userCreated}">
				<li class="fieldcontain">
					<span id="userCreated-label" class="property-label"><g:message code="block.userCreated.label" default="User Created" /></span>
					
						<span class="property-value" aria-labelledby="userCreated-label"><g:fieldValue bean="${blockInstance}" field="userCreated"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.appCreated}">
				<li class="fieldcontain">
					<span id="appCreated-label" class="property-label"><g:message code="block.appCreated.label" default="App Created" /></span>
					
						<span class="property-value" aria-labelledby="appCreated-label"><g:fieldValue bean="${blockInstance}" field="appCreated"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.lastUpdated}">
				<li class="fieldcontain">
					<span id="lastUpdated-label" class="property-label"><g:message code="block.lastUpdated.label" default="Last Updated" /></span>
					
						<span class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate date="${blockInstance?.lastUpdated}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.userUpdated}">
				<li class="fieldcontain">
					<span id="userUpdated-label" class="property-label"><g:message code="block.userUpdated.label" default="User Updated" /></span>
					
						<span class="property-value" aria-labelledby="userUpdated-label"><g:fieldValue bean="${blockInstance}" field="userUpdated"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.appUpdated}">
				<li class="fieldcontain">
					<span id="appUpdated-label" class="property-label"><g:message code="block.appUpdated.label" default="App Updated" /></span>
					
						<span class="property-value" aria-labelledby="appUpdated-label"><g:fieldValue bean="${blockInstance}" field="appUpdated"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.stains}">
				<li class="fieldcontain">
					<span id="stains-label" class="property-label"><g:message code="block.stains.label" default="Stains" /></span>
					
						<g:each in="${blockInstance.stains}" var="s">
						<span class="property-value" aria-labelledby="stains-label"><g:link controller="stain" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${blockInstance?.id}" />
					<g:link class="edit" action="edit" id="${blockInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
