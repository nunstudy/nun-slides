
<%@ page import="org.nunstudy.pathology.NunId" %>
<%@ page import="org.nunstudy.pathology.Nun" %>

<%--<div class="fieldcontain ${hasErrors(bean: nunIdInstance, field: 'autopId', 'error')} ">
	<label for="autopId">
		<g:message code="nunId.autopId.label" default="Autop Id" />
		
	</label>
	${nunIdInstance?.autopId}
</div>

<div class="fieldcontain ${hasErrors(bean: nunIdInstance, field: 'aperioId', 'error')} ">
	<label for="aperioId">
		<g:message code="nunId.aperioId.label" default="Aperio Id" />
	</label>
	${nunIdInstance?.aperioId}
</div> --%>

Blocks for ${nunIdInstance}
<div class="blocks">
	<g:each in="${nunIdInstance?.blocks}" var="blockInstance" >
		<div class="blockRow">
			<div class="blockHeader"><h3>${blockInstance}</h3></div>
			<div class="blockInfo">
				<g:each in="${blockInstance?.stains}" var="stainInstance" >			
					<div class="stainRow">
						<span>${stainInstance}<g:if test="${stainInstance.scannedToAperio}" ><em>scanned</em></g:if></span>							
					</div>
				</g:each>
			</div>
		</div>
	</g:each>
</div>

