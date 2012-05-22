<%@ page import="org.nunstudy.pathology.NunId" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="umn">
		<g:set var="entityName" value="${message(code: 'nunId.label', default: 'NunId')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="nav" role="navigation">
			<div class="navLeft">
				<ul>
					<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
					<li><g:link class="list" action="list">Subject List</g:link></li>
					<%--<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li> --%>
				</ul>
			</div>
			<div class="navRight">
				<g:form action="find">
					 <g:textField class="searchBox" name="id" title="Search by Aperio or Autopsy ID..." value="Search by Aperio or Autopsy ID..." />
				</g:form> 
			</div>
		</div>
		<div id="edit-nunId" class="content scaffold-edit" role="main">
			<%--<h1>Edit Subject</h1> --%>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${nunIdInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${nunIdInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<div class="subjectInfo" >
				<h2><u><strong>Blocks</strong></u> for Autopsy ID: <strong>${nunIdInstance?.autopId}</strong>  | Aperio ID: <strong>${nunIdInstance?.aperioId}</strong></h2>
			</div>
			<div class="blockContainer">
				<g:render template="form"/>
			</div>
			<div class="bottomBumper"></div>
			
		</div>
	</body>
</html>
