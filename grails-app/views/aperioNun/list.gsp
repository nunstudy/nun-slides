
<%@ page import="org.nunstudy.pathology.AperioNun" %>
<%@ page import="org.nunstudy.pathology.AperioService" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="umn">
		<g:set var="entityName" value="${message(code: 'aperioNun.label', default: 'AperioNun')}" />
		<title>Subject List</title>
	</head>
	<body>
		<div class="nav" role="navigation">
			<div class="navLeft">
				<ul>
					<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				</ul>
			</div>
			<div class="navRight">
				<g:form controller="nunId" action="find">
					 <g:textField class="searchBox" name="id" title="Search by Aperio or Autopsy ID..." value="Search by Aperio or Autopsy ID..." />
				</g:form> 
			</div>
		</div>
		
		<div id="list-aperioNun" class="content scaffold-list" role="main">
			<h1>Subject List</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<div class="stats">
				<table>
					<tr>
						<td>Brains Not Received:</td><td>${summaryDataInstance.needBrain}</td>
					</tr>
					<tr>
						<td>No Data Entered:</td><td>${summaryDataInstance.noData}</td>
					</tr>
					<tr>
						<td>No Slides Scanned:</td><td>${summaryDataInstance.zeroScanned}</td>
					</tr>
					<tr>
						<td>Some Slides Scanned:</td><td>${summaryDataInstance.someScanned}</td>
					</tr>
					<tr>
						<td>All Slides Scanned:</td><td>${summaryDataInstance.allScanned}</td>
					</tr>
				</table>
			</div>
			<div id="subjectCount">Showing ${aperioNunInstanceTotal} subjects</div>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="id" title="${message(code: 'aperioNun.id.label', default: 'Aperio Id')}" />
					
						<g:sortableColumn property="autopId" title="${message(code: 'aperioNun.autopId.label', default: 'Autop Id')}" />
					
						<g:sortableColumn property="autopYear" title="${message(code: 'aperioNun.autopYear.label', default: 'Autopsy Year')}" />

						<g:sortableColumn property="autopOrder" title="${message(code: 'aperioNun.autopOrder.label', default: 'Autopsy Order')}" />

						<g:sortableColumn property="blocks" title="${message(code: 'aperioNun.blocks.label', default: 'Blocks')}" />
					
						<g:sortableColumn property="stains" title="${message(code: 'aperioNun.stains.label', default: 'Slides')}" />
					
						<g:sortableColumn property="aperio" title="${message(code: 'aperioNun.aperio.label', default: 'Scanned')}" />

						<th>Status</th>
					</tr>
				</thead>
				<tbody>
				<g:each in="${aperioNunInstanceList}" status="i" var="aperioNunInstance">
					<tr class="subjectRow ${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:link controller="nunId" action="find" id="${aperioNunInstance.id}"><g:formatNumber number="${aperioNunInstance.id}" format="####"/></g:link></td>
					
						<td>${fieldValue(bean: aperioNunInstance, field: "autopId")}</td>
					
						<td><g:formatNumber number="${aperioNunInstance.autopYear}" format="####" /></td>

						<td>${fieldValue(bean: aperioNunInstance, field: "autopOrder")}</td>

						<td>${fieldValue(bean: aperioNunInstance, field: "blocks")}</td>
					
						<td>${fieldValue(bean: aperioNunInstance, field: "stains")}</td>
					
						<td>${fieldValue(bean: aperioNunInstance, field: "aperio")}</td>

						<td class="status <g:if test='${aperioNunInstance.status == 1}'>noData</g:if> <g:if test='${aperioNunInstance.status == 2}'>done</g:if> <g:if test='${aperioNunInstance.status == 3}'>todo</g:if> <g:if test='${aperioNunInstance.status == 4}'>started</g:if>" ><g:scannedStatus status="${aperioNunInstance.status}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${aperioNunInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
