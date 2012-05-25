
<%@ page import="org.nunstudy.pathology.NunId" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="umn">
		<g:set var="entityName" value="${message(code: 'nunId.label', default: 'NunId')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="nav" role="navigation">
			<div class="navLeft">
				<ul>
					<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				</ul>
			</div>
			<div class="navRight">
				<g:form action="find">
					 <g:textField class="searchBox" name="id" title="Search by Aperio or Autopsy ID..." value="Search by Aperio or Autopsy ID..." />
				</g:form> 
			</div>
		</div>
		<div id="list-nunId" class="content scaffold-list" role="main">
			<h1>Subject List</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="autopId" title="${message(code: 'nunId.autopId.label', default: 'Autop Id')}" />
					
						<g:sortableColumn property="aperioId" title="${message(code: 'nunId.aperioId.label', default: 'Aperio Id')}" />
					
						<g:sortableColumn property="aperioCode" title="${message(code: 'nunId.aperioCode.label', default: 'Aperio Code')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${nunIdInstanceList}" status="i" var="nunIdInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${nunIdInstance.id}">${fieldValue(bean: nunIdInstance, field: "autopId")}</g:link></td>
					
						<td>${fieldValue(bean: nunIdInstance, field: "aperioId")}</td>
					
						<td>${fieldValue(bean: nunIdInstance, field: "aperioCode")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${nunIdInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
