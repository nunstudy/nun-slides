
<%@ page import="org.nunstudy.pathology.NunId" %>

<div class="blocks">
	<a href="#" class="showAll" title="Show All">Show All</a>
	<g:each in="${nunIdInstance?.blocks}" var="blockInstance" status="i" >
		<div class="blockRow ${(i % 2) == 0 ? 'odd' : 'even'}">
			<div class="blockHeader closed"><h3>${blockInstance}</h3></div>
			<div class="blockInfo">			
				<div class="blockEdit">
					<a href="#" title="Edit Block">Edit Block</a>
					
				</div>
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

