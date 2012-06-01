<%@ page import="org.nunstudy.pathology.Stain" %>


<g:if test="${editing}">
	<h3>Editing ${stainInstance} Stain for Block: ${stainInstance.block}</h3>
	<label for="stainCode">ID: ${stainInstance.stainCode}</label>
	<g:hiddenField name="id" value="${stainInstance.id}" />
</g:if>
<g:else>
	<h3>Adding stain to Block: ${stainInstance.block}</h3>
	<g:hiddenField name="block" value="${stainInstance.block.id}" />
</g:else>

<div class="fieldcontain ${hasErrors(bean: stainInstance, field: 'type', 'error')} ">
	<label for="type">
		<g:message code="stain.type.label" default="Stain Type" />
		
	</label>
	<g:select id="type" name="type.id" from="${org.nunstudy.pathology.StainType.list()}" optionKey="id" value="${stainInstance?.type?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="dialogButtons">
	<g:if test="${editing}">
		<g:submitToRemote class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" update="${'block' + blockInstance.id}" value="Save" url="[action:'update']" after="closeStainEditForm()" />
	</g:if>
	<g:else>
		<g:actionSubmit class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" action="save" value="Save" onclick="closeStainEditForm();"/>
	</g:else>
	<input id="stainEditFormCancelBtn" type="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" role="button" aria-disabled="false" onclick="closeStainEditForm();" value="Cancel" />
</div>
