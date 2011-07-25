<html>
    <head>
    </head>
    <body>
		<g:form params="${queryMap}">
			<g:hiddenField name="metaEntity.id" value="${metaEntity.id}" />
			<g:each in="${layout.attributeLayouts}" var="attributeLayout" status="column">
				<label>
					<g:set var="metaAttribute" value="${attributeLayout.metaAttribute}" />
					${metaAttribute.name}:
					<g:render template="/tile/attribute" model='[metaAttribute: metaAttribute, column: column ]' />
				</label>
			</g:each>
			<g:actionSubmit value="Add" action="insert" />
		</g:form>
		<g:paginate total="${totalNumberOfEntities}" params="${queryMap}" />
		<g:form params="${queryMap}">
			<table>
				<thead>
					<tr>
						<g:each in="${layout.attributeLayouts}" var="attributeLayout">
							<th>${attributeLayout.metaAttribute.name}</th>
						</g:each>
					</tr>
				</thead>
				<tbody>
					<g:each in="${entities}" var="entity" status="row">
						<tr>
							<g:each in="${layout.attributeLayouts}" var="attributeLayout" status="column">
								<th>
									<g:set var="attribute" value="${entity.attribute(attributeLayout.metaAttribute.name)}" />
									<g:render template="/tile/attribute" model='[attribute: attribute, row: row, column: column ]' />
								</th>
							</g:each>
						</tr>
					</g:each>
				</tbody>
			</table>
			<g:actionSubmit value="Update" action="update" />
		</g:form>
    </body>
</html>