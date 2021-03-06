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
			<g:form name="blockEditForm" controller="block" >
			</g:form>
		</div>
		<div id="stainEditFormDialog" class="stainEdit" title="Edit Stain" >
			<g:form name="stainEditForm" controller="stain" >
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
				<h2><strong>Showing <u>Blocks</u></strong> for Aperio ID: <strong>${nunIdInstance?.aperioId}</strong> | Autopsy ID: <strong>${nunIdInstance?.autopId}</strong></h2>
			</div>
			<div class="blockContainer">
				<div class="blocks">
					<g:if test="${flash.message}">
					<div class="message" role="status">${flash.message}</div>
					</g:if>
					
					<div class="showHideBar">
						<g:if test="${nunIdInstance?.blocks}">
								<span class="showHideAll"><a href="#" class="showAll" title="Show All">Show All</a>  |  <a href="#" class="hideAll" title="Hide All">Hide All</a></span>
						</g:if>
						<g:form name="createBlockForm" >
							<span class="blockButton"><g:submitToRemote url="${[controller:'block', action:'create', id:nunIdInstance.id]}" update="blockEditForm" onSuccess="showBlockEditForm()" value="New Block" /></span>
						</g:form>						
						<g:form name="createBlockTemplateForm" controller="nunId" >
							<g:hiddenField name="id" value="${nunIdInstance.id}" />
							<span class="blockButton"><g:actionSubmit action="createTemplate" value="New Template" /></span>
						</g:form>						
					</div>
					<div id="blockList">
						<g:hiddenField name="blockToOpen" value="${blockId}"/>
						<g:render template="/block/blockInfo" collection="${nunIdInstance?.blocks}" var="blockInstance" />
					</div>
				</div>
				<%--<g:render template="form"/> --%>
			</div>
			<div class="bottomBumper"> </div>
			
		</div>
	</body>
</html>
