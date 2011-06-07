<g:set var="name" value="attributes[${column}]" />

<g:if test="${row >= 0}">
	<g:set var="name" value="rows[${row}].${name}" />
</g:if>

<g:if test="${attribute}">
	<g:hiddenField name="${name}.attribute.id" value="${attribute.id}" />
	<g:set var="metaAttribute" value="${attribute.metaAttribute}" />
</g:if>
<g:else>
	<input type="hidden" name="${name}.attribute.metaAttribute.id" value="${metaAttribute.id}" />
</g:else>

<g:if test="${metaAttribute.type == 'String'}">
	<g:render template="/tile/widget/input" model="[name: name, metaAttribute: metaAttribute, attribute: attribute ]" />
</g:if>
<g:elseif test="${metaAttribute.type == 'List'}">
	<g:render template="/tile/widget/select" model="[name: name, metaAttribute: metaAttribute, attribute: attribute ]" />
</g:elseif>
