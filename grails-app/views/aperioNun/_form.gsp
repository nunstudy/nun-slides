<%@ page import="org.nunstudy.pathology.AperioNun" %>



<div class="fieldcontain ${hasErrors(bean: aperioNunInstance, field: 'autopId', 'error')} ">
	<label for="autopId">
		<g:message code="aperioNun.autopId.label" default="Autop Id" />
		
	</label>
	<g:textField name="autopId" value="${aperioNunInstance?.autopId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: aperioNunInstance, field: 'blocks', 'error')} ">
	<label for="blocks">
		<g:message code="aperioNun.blocks.label" default="Blocks" />
		
	</label>
	<g:field type="number" name="blocks" value="${fieldValue(bean: aperioNunInstance, field: 'blocks')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: aperioNunInstance, field: 'stains', 'error')} ">
	<label for="stains">
		<g:message code="aperioNun.stains.label" default="Stains" />
		
	</label>
	<g:field type="number" name="stains" value="${fieldValue(bean: aperioNunInstance, field: 'stains')}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: aperioNunInstance, field: 'aperio', 'error')} ">
	<label for="aperio">
		<g:message code="aperioNun.aperio.label" default="Aperio" />
		
	</label>
	<g:field type="number" name="aperio" value="${fieldValue(bean: aperioNunInstance, field: 'aperio')}"/>
</div>

