<%@ page import="org.nunstudy.pathology.NunId" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="umn">
		<g:set var="entityName" value="${message(code: 'nunId.label', default: 'NunId')}" />
		<title>Edit Blocks</title>
		<r:require module="jquery-ui"/>
	</head>
	
	<body>
		<%-- MODAL DIALOG FOR BLOCK EDITING --%>
		<div id="blockEditFormDialog" class="blockEdit" title="Edit Block" >
			<g:form name="blockEditForm" >
			</g:form>
		</div>

		<div class="nav" role="navigation">
			<div class="navLeft">
				<ul>
					<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
					<li><g:link class="list" controller="aperioNun" action="list">Subject List</g:link></li>
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
			<div class="subjectInfo" >
				<h2><u><strong>Blocks</strong></u> for Aperio ID: <strong>${nunIdInstance?.aperioId}</strong> | Autopsy ID: <strong>${nunIdInstance?.autopId}</strong></h2>
			</div>
			<div class="blockContainer">
				<div class="blocks">
					<g:if test="${nunIdInstance?.blocks}">
						<div class="showHideBar"><a href="#" class="showAll" title="Show All">Show All</a>  |  <a href="#" class="hideAll" title="Hide All">Hide All</a></div>
					</g:if>
					<div id="blockList">
						<g:render template="/block/blockInfo" collection="${nunIdInstance?.blocks}"/>
					</div>
				</div>
				<%--<g:render template="form"/> --%>
			</div>
			<div class="bottomBumper"> </div>
			
		</div>
	</body>
</html>
