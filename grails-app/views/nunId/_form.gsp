
<%@ page import="org.nunstudy.pathology.NunId" %>

<div class="blocks">
	<g:each in="${nunIdInstance?.blocks}" var="blockInstance" >
		<div class="blockRow">
			<div class="blockHeader closed"><h3>${blockInstance}</h3></div>
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

