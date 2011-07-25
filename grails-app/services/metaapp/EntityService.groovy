package metaapp

import metaapp.data.Entity;
import metaapp.meta.MetaEntity;
import metaapp.meta.attribute.MetaAttribute;

class EntityService {

    static transactional = true
	
	private values = [
		"String": "a.value.value",
		"List": "a.value.option.value"
	]

    List<Entity> findAll(MetaEntity metaEntity, AttributeFilter attributeFilter, Paginator paginator) {
		if (!attributeFilter.active) {
			Entity.findAllByMetaEntity(metaEntity, paginator.params)
		} else {
			MetaAttribute metaAttribute = attributeFilter.filteredAttribute
			String value = attributeFilter.filterOnValue
			Entity.findAll("\
				FROM Entity \
				WHERE id IN ( \
					SELECT DISTINCT e.id \
					${innerQuery(metaAttribute.type)} \
				) \
			", [ metaEntity, metaAttribute, value ], paginator.params)
		}
    }
	
	Long count(MetaEntity metaEntity, AttributeFilter attributeFilter) {
		if (!attributeFilter.active) {
			Entity.countByMetaEntity(metaEntity)
		} else {
			MetaAttribute metaAttribute = attributeFilter.filteredAttribute
			String value = attributeFilter.filterOnValue
			Entity.executeQuery("\
				SELECT COUNT(e) \
				${innerQuery(metaAttribute.type)} \
			", [ metaEntity, metaAttribute, value ])[0]
		}
	}
	
	private innerQuery(metaAttributeType) {
		"\
		FROM Entity e \
		JOIN e.attributes a \
		WHERE e.metaEntity = ? \
		AND a.metaAttribute = ? \
		AND LOWER(${values[metaAttributeType]}) LIKE LOWER('%' || ? || '%') \
		"
	}
}
