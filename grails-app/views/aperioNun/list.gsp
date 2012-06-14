
<%@ page import="org.nunstudy.pathology.AperioNun" %>
<%@ page import="org.nunstudy.pathology.AperioService" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="umn">
		<g:set var="entityName" value="${message(code: 'aperioNun.label', default: 'AperioNun')}" />
		<title>Subject Slide Scan Status List</title>
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
				<h2 class="showSummary closed"></h2>
				<table>
					<tr>
						<td class="status">Brains Not Received:</td><td>${summaryDataInstance.needBrain}</td>
					</tr>
					<tr class="odd">
						<td class="status noData">No Data Entered:</td><td>${summaryDataInstance.noData}</td>
					</tr>
					<tr>
						<td class="status todo">No Slides Scanned:</td><td>${summaryDataInstance.zeroScanned}</td>
					</tr>
					<tr class="odd">
						<td class="status started">Some Slides Scanned:</td><td>${summaryDataInstance.someScanned}</td>
					</tr>
					<tr>
						<td class="status done">All Slides Scanned:</td><td>${summaryDataInstance.allScanned}</td>
					</tr>
				</table>
			</div>

			<div class="syncBox">
				<div><span class="blockButton syncButton"><g:remoteLink action="runSyncWithAperio" update="syncInfo">Synchronize with Aperio Data</g:remoteLink></span></div>
				<div id="syncInfo"></div>
			</div>

			<div class="subjectCount" title="${aperioNunInstanceTotal}"><strong>Showing 10 of ${aperioNunInstanceTotal} subjects</strong></div>
			<div class="tableContainer">
			<table id="sortableTable" class="tablesorter">
				<thead>
					<tr>
						<%--<g:sortableColumn property="id" title="${message(code: 'aperioNun.id.label', default: 'Aperio Id')}" />
					
						<g:sortableColumn property="autopId" title="${message(code: 'aperioNun.autopId.label', default: 'Autop Id')}" />
					
						<g:sortableColumn property="autopYear" title="${message(code: 'aperioNun.autopYear.label', default: 'Autopsy Year')}" />

						<g:sortableColumn property="autopOrder" title="${message(code: 'aperioNun.autopOrder.label', default: 'Autopsy Order')}" />

						<g:sortableColumn property="blocks" title="${message(code: 'aperioNun.blocks.label', default: 'Blocks')}" />
					
						<g:sortableColumn property="stains" title="${message(code: 'aperioNun.stains.label', default: 'Slides')}" />
					
						<g:sortableColumn property="aperio" title="${message(code: 'aperioNun.aperio.label', default: 'Scanned')}" /> --%>

						<th>Aperio Id</th>
					
						<th>Autop Id</th>
					
						<th>Autopsy Year</th>

						<th>Autopsy Order</th>

						<th>Blocks</th>
					
						<th>Slides</th>
					
						<th>Scanned</th>

						<th>Status</th>
					</tr>
				</thead>
				<tbody>
				<g:each in="${aperioNunInstanceList}" status="i" var="aperioNunInstance">
					<%--<tr class="subjectRow ${(i % 2) == 0 ? 'even' : 'odd'}"> --%>
					<tr>

						<td><g:link controller="nunId" action="find" id="${aperioNunInstance.id}"><g:formatNumber number="${aperioNunInstance.id}" format="####"/></g:link></td>
					
						<td>${fieldValue(bean: aperioNunInstance, field: "autopId")}</td>
					
						<td><g:formatNumber number="${aperioNunInstance.autopYear}" format="####" /></td>

						<td>${fieldValue(bean: aperioNunInstance, field: "autopOrder")}</td>

						<td>${fieldValue(bean: aperioNunInstance, field: "blocks")}</td>
					
						<td>${fieldValue(bean: aperioNunInstance, field: "stains")}</td>
					
						<td>${fieldValue(bean: aperioNunInstance, field: "aperio")}</td>

						<td class="status <g:if test='${aperioNunInstance.status == 1}'>noData</g:if><g:if test='${aperioNunInstance.status == 2}'>done</g:if><g:if test='${aperioNunInstance.status == 3}'>todo</g:if><g:if test='${aperioNunInstance.status == 4}'>started</g:if>" ><g:scannedStatus status="${aperioNunInstance.status}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<%--<div class="pagination">
				<g:paginate total="${aperioNunInstanceTotal}" />
			</div> --%>
				<div id="pager" class="tablesorterPager">
					<form>
					  <img src="${resource(dir: 'images/addons/pager', file: 'first.png')}" class="first"/>
					  <img src="${resource(dir: 'images/addons/pager', file: 'prev.png')}" class="prev"/>
					  <input type="text" class="pagedisplay"/>
					  <img src="${resource(dir: 'images/addons/pager', file: 'next.png')}" class="next"/>
					  <img src="${resource(dir: 'images/addons/pager', file: 'last.png')}" class="last"/>
					  <label>Show</label>
					  <select class="pagesize">
					    <option selected="selected"  value="10">10</option>
					    <option value="20">20</option>
					    <option value="30">30</option>
					    <option  value="40">40</option>
					    <option  value="${aperioNunInstanceTotal}">All</option>
					  </select>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
