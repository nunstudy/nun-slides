<%@ page import="org.nunstudy.pathology.Block" %>


<g:if test="${editing}">
	<g:hiddenField name="id" value="${blockInstance.id}" />
</g:if>
<g:else>
	<g:hiddenField name="nun" value="${blockInstance.nun.id}" />
</g:else>

<div class="fieldcontain ${hasErrors(bean: blockInstance, field: 'code', 'error')} ">
	<label for="code">
		<g:message code="block.code.label" default="Aperio Code" />
		
	</label>
	<strong>${blockInstance?.code}</strong>
</div>

<div class="fieldcontain ${hasErrors(bean: blockInstance, field: 'label', 'error')} ">
	<label for="label">
		<g:message code="block.label.label" default="Label" />
		
	</label>
	<g:textField name="label" value="${blockInstance?.label}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: blockInstance, field: 'hemisphere', 'error')} ">
	<label for="hemisphere">
		<g:message code="block.hemisphere.label" default="Hemisphere" />
		
	</label>
	<g:select id="hemisphere" name="hemisphere.id" from="${org.nunstudy.pathology.Hemisphere.list()}" optionKey="id" value="${blockInstance?.hemisphere?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: blockInstance, field: 'blockArea', 'error')} required">
	<label for="blockArea">
		<g:message code="block.blockArea.label" default="Area" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="subArea" name="subArea.id" from="${org.nunstudy.pathology.SubArea.list()}" optionKey="id" optionValue="description" value="${blockInstance?.subArea?.id}" class="many-to-one" noSelection="['null': '']"/>
	<g:select id="blockArea" name="blockArea.id" from="${org.nunstudy.pathology.BlockArea.list()}" optionKey="id" optionValue="description" required="" value="${blockInstance?.blockArea?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: blockInstance, field: 'areaOtherText', 'error')} ">
	<label for="areaOtherText">
		<g:message code="block.areaOtherText.label" default="Other Area" />
		
	</label>
	<g:textField name="areaOtherText" value="${blockInstance?.areaOtherText}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: blockInstance, field: 'lesion', 'error')} ">
	<label for="lesion">
		<g:message code="block.lesion.label" default="Lesion" />
		
	</label>
	<g:checkBox name="lesion" value="${blockInstance?.lesion}" />
</div>

<div class="fieldcontain ${hasErrors(bean: blockInstance, field: 'infarction', 'error')} ">
	<label for="infarction">
		<g:message code="block.infarction.label" default="Infarction" />
		
	</label>
	<g:checkBox name="infarction" value="${blockInstance?.infarction}" />
</div>

<div class="fieldcontain ${hasErrors(bean: blockInstance, field: 'missing', 'error')} ">
	<label for="missing">
		<g:message code="block.missing.label" default="Missing" />
		
	</label>
	<g:checkBox name="missing" value="${blockInstance?.missing}" />
</div>

<div class="fieldcontain ${hasErrors(bean: blockInstance, field: 'demented', 'error')} ">
	<label for="demented">
		<g:message code="block.demented.label" default="Demented" />
		
	</label>
	<g:checkBox name="demented" value="${blockInstance?.demented}" />
</div>

<div class="dialogButtons">
	<g:if test="${editing}">
		<g:submitToRemote class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" update="${'block' + blockInstance.id}" value="Save" url="[action:'update']" after="closeBlockEditForm()" />
	</g:if>
	<g:else>
		<g:actionSubmit class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" action="save" value="Save" onclick="closeBlockEditForm();"/>
	</g:else>
	<input id="blockEditFormCancelBtn" type="button" class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only" role="button" aria-disabled="false" onclick="closeBlockEditForm();" value="Cancel" />
</div>
