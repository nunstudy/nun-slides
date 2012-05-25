
<%@ page import="org.nunstudy.pathology.NunId" %>

<%-- MODAL DIALOG FOR BLOCK EDITING --%>
<div id="blockEditFormDialog" class="blockEdit" title="Edit Block" >
	<g:form name="blockEditForm" >
<%--		<g:hiddenField name="id" value="${blockInstance.id}" />
		<fieldset>
			<label for="code">Code</label>${blockInstance.code}
			<label for="hemisphere">Hemisphere</label>
			<g:textField name="hemisphere" value="${blockInstance.hemisphere}" />
			<label for="blockArea">Area</label>
			<g:textField name="blockArea" value="" />
			<label for="areaOtherText">Other Area Description</label>
			<g:textField name="areaOtherText" value="" />
			<label for="lesion">Lesion</label>
			<g:checkBox name="lesion" value="" />
			<label for="infarction">Infarction</label>
			<g:checkBox name="infarction" value="" />
			<label for="missing">Missing</label>
			<g:checkBox name="missing" value="" />
			<label for="demented">Demented</label>
			<g:checkBox name="demented" value="" />
		</fieldset> --%>
	</g:form>
	<button id="blockEditFormCancelBtn" type="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" role="button" aria-disabled="false">
		<span class="ui-button-text">Cancel</span>
	</button>				
</div>

<div class="blocks">
	<a href="#" class="showAll" title="Show All">Show All</a>
	<g:each in="${nunIdInstance?.blocks}" var="blockInstance" status="i" >
		<g:hiddenField name="id" value="${blockInstance.id}" />
		<div class="blockRow ${(i % 2) == 0 ? 'odd' : 'even'}">
			<div class="blockHeader closed"><h3>${blockInstance}</h3></div>
			<div class="blockInfo">	
				Block created on <g:formatDate date="${blockInstance.dateCreated}" format="MM/dd/yyyy h:mm a"/> by ${blockInstance.userCreated}	
				<g:form name="${'editBlockForm_' + i}">
					<g:remoteLink controller="block" action="edit" id="${blockInstance.id}" update="blockEditForm" onSuccess="showBlockEditForm()" >Edit Block</g:remoteLink>
				</g:form>
				<div class="stainInfo">			
					<h3>Stains</h3>
					<g:each in="${blockInstance?.stains}" var="stainInstance" >			
						<div class="stainRow">
							<span>${stainInstance}<g:if test="${stainInstance.scannedToAperio}" ><em>scanned</em></g:if></span>							
						</div>
					</g:each>
				</div>
			</div>
		</div>
	</g:each>
</div>

