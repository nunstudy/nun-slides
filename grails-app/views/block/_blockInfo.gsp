
<div id="${'block' + block.id}">
	<div class="blockRow">
		<div class="blockHeader closed"><h3 title="Block created on <g:formatDate date='${block.dateCreated}' format='MM/dd/yyyy h:mm a'/> by ${block.userCreated}">${block}</h3></div>
		<div class="blockInfo">
			<ul class="property-list block">
				<g:if test="${block?.hemisphere}">
				<li class="fieldcontain">
					<span id="hemisphere-label" class="property-label"><g:message code="block.hemisphere.label" default="Hemisphere:" /></span>
					
					<span class="property-value" aria-labelledby="hemisphere-label">${block.hemisphere}</span>
					
				</li>
				</g:if>
	
				<g:if test="${block?.blockArea}">
				<li class="fieldcontain">
					<span id="blockArea-label" class="property-label"><g:message code="block.blockArea.label" default="Area:" /></span>
					
						<span class="property-value" aria-labelledby="blockArea-label">${block?.blockArea?.encodeAsHTML()}</span>
					
				</li>
				</g:if>
			
				<g:if test="${block?.subArea}">
				<li class="fieldcontain">
					<span id="subArea-label" class="property-label"><g:message code="block.subArea.label" default="Sub-Area:" /></span>
					
						<span class="property-value" aria-labelledby="subArea-label">${block?.subArea?.encodeAsHTML()}</span>
					
				</li>
				</g:if>
			
				<g:if test="${block?.areaOtherText}">
				<li class="fieldcontain">
					<span id="areaOtherText-label" class="property-label"><g:message code="block.areaOtherText.label" default="Other Area:" /></span>
					
						<span class="property-value" aria-labelledby="areaOtherText-label"><g:fieldValue bean="${block}" field="areaOtherText"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${block?.code}">
				<li class="fieldcontain">
					<span id="code-label" class="property-label"><g:message code="block.code.label" default="Aperio Code:" /></span>
					
					<span class="property-value" aria-labelledby="code-label">${block.code}</span>
					
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
	
			</ul>
			
			<span class="editBlock">
				<g:form name="${'editBlockForm_' + block.id}">
					<g:remoteLink controller="block" action="edit" id="${block.id}" update="blockEditForm" onSuccess="showBlockEditForm()" >Edit Block</g:remoteLink>
				</g:form>
			</span>
			<div class="stainInfo">			
				<h3>Stains</h3>
				<g:each in="${block?.stains}" var="stainInstance" >			
					<div class="stainRow">
						<span>${stainInstance}<g:if test="${stainInstance.scannedToAperio}" ><em>scanned</em></g:if></span>							
					</div>
				</g:each>
			</div>
		</div>
		
	</div>
</div>