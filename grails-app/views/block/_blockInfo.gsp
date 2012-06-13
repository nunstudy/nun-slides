
<div id="${'block' + blockInstance.id}">
	<div class="blockRow">	
		<div id="${'blockHeader' + blockInstance.id}" class="blockHeader closed <g:if test='${blockInstance.dateDeleted}'>deleted</g:if>"><h3 title="Block ${blockInstance.id} created on <g:formatDate date='${blockInstance.dateCreated}' format='MM/dd/yyyy h:mm a'/> by ${blockInstance.userCreated}">${blockInstance} <g:if test="${blockInstance.dateDeleted}">- Deleted on <g:formatDate date="${blockInstance.dateDeleted}" format="MM/dd/yyyy h:mm a"/> by ${blockInstance.userUpdated}</g:if></h3></div>
		<div class="blockInfo">
			<g:if test="${infoMessage}">
			<div class="message" role="status">${infoMessage}</div>
			</g:if>
			<ul class="property-list block">
				<g:if test="${blockInstance?.hemisphere}">
				<li class="fieldcontain">
					<span id="hemisphere-label" class="property-label"><g:message code="block.hemisphere.label" default="Hemisphere:" /></span>
					
					<span class="property-value" aria-labelledby="hemisphere-label">${blockInstance.hemisphere}</span>
					
				</li>
				</g:if>
	
				<g:if test="${blockInstance?.blockArea}">
				<li class="fieldcontain">
					<span id="blockArea-label" class="property-label"><g:message code="block.blockArea.label" default="Area:" /></span>
					
						<span class="property-value" aria-labelledby="blockArea-label">${blockInstance?.blockArea?.encodeAsHTML()}</span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.subArea}">
				<li class="fieldcontain">
					<span id="subArea-label" class="property-label"><g:message code="block.subArea.label" default="Sub-Area:" /></span>
					
						<span class="property-value" aria-labelledby="subArea-label">${blockInstance?.subArea?.encodeAsHTML()}</span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.areaOtherText}">
				<li class="fieldcontain">
					<span id="areaOtherText-label" class="property-label"><g:message code="block.areaOtherText.label" default="Other Area:" /></span>
					
						<span class="property-value" aria-labelledby="areaOtherText-label"><g:fieldValue bean="${block}" field="areaOtherText"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.code}">
				<li class="fieldcontain">
					<span id="code-label" class="property-label"><g:message code="block.code.label" default="Aperio Code:" /></span>
					
					<span class="property-value" aria-labelledby="code-label">${blockInstance.code}</span>
					
				</li>
				</g:if>

				<g:if test="${blockInstance?.lesion}">
				<li class="fieldcontain">
					<span id="lesion-label" class="property-label"><g:message code="block.lesion.label" default="Lesion:" /></span>
					
						<span class="property-value" aria-labelledby="lesion-label"><g:formatBoolean boolean="${blockInstance?.lesion}" true="Yes" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.infarction}">
				<li class="fieldcontain">
					<span id="infarction-label" class="property-label"><g:message code="block.infarction.label" default="Infarction:" /></span>
					
						<span class="property-value" aria-labelledby="infarction-label"><g:formatBoolean boolean="${blockInstance?.infarction}" true="Yes" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.missing}">
				<li class="fieldcontain">
					<span id="missing-label" class="property-label"><g:message code="block.missing.label" default="Missing:" /></span>
					
						<span class="property-value" aria-labelledby="missing-label"><g:formatBoolean boolean="${blockInstance?.missing}" true="Yes" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${blockInstance?.demented}">
				<li class="fieldcontain">
					<span id="demented-label" class="property-label"><g:message code="block.demented.label" default="Demented:" /></span>
					
						<span class="property-value" aria-labelledby="demented-label"><g:formatBoolean boolean="${blockInstance?.demented}" true="Yes" /></span>
					
				</li>
				</g:if>
	
			</ul>
			
			<div class="editBlock">
				<g:form name="${'editBlockForm_' + blockInstance.id}" >
					<span class="blockButton"><g:submitToRemote url="${[controller:'block', action:'edit', id:blockInstance.id]}" update="blockEditForm" onSuccess="showBlockEditForm()" value="Edit Block" /></span>
				</g:form>
				<g:form name="${'deleteBlockForm_' + blockInstance.id}" controller="block" >
					<g:hiddenField name="id" value="${blockInstance.id}" />
					<span class="blockButton"><g:actionSubmit action="delete" onclick="return confirm('Are you sure?');" value="Delete Block" /></span>
				</g:form>
			</div>
			<div class="stainInfo">			
				<g:form name="${'editStainForm_' + blockInstance.id}" >
					<span class="blockButton"><g:submitToRemote url="${[controller:'stain', action:'create', id:blockInstance.id]}" update="stainEditForm" onSuccess="showStainEditForm()" value="Add Stain" /></span>
				</g:form>
				<g:if test="${blockInstance?.stains}"><h3>Stains</h3></g:if>
				<g:each in="${blockInstance?.stains}" var="stainInstance" >			
					<div class="stainRow">						
						<g:form name="${'deleteSlideForm_' + stainInstance.id}" controller="block" >
							<g:hiddenField name="id" value="${stainInstance.id}" />
							<span class="<g:if test='${stainInstance.dateDeleted}'>deleted</g:if>" ><g:if test='${!stainInstance.dateDeleted}'><g:actionSubmit class="deleteItem" action="deleteStain" onclick="return confirm('Are you sure want to delete the ${stainInstance} stain??');" value=" " /></g:if>${stainInstance}<g:if test="${stainInstance.scannedToAperio}" ><em>scanned</em></g:if></span>							
						</g:form>
						<%--<span class="blockButton <g:if test='${stainInstance.dateDeleted}'>deleted</g:if>" ><g:if test='${!stainInstance.dateDeleted}'><g:submitToRemote class="deleteItem" url="${[controller:'block', action:'deleteStain', id:stainInstance.id]}" update="${'block' + blockInstance.id}" before="if (!confirm('Are you sure want to delete the ${stainInstance} stain?')) return false;" value="" title="Delete Stain" /></g:if>${stainInstance}<g:if test="${stainInstance.scannedToAperio}" ><em>scanned</em></g:if></span> --%>							
					</div>
				</g:each>
			</div>
		</div>
		
	</div>
</div>