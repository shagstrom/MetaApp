package metaapp.data

import metaapp.data.Attribute
import metaapp.meta.MetaEntity
import metaapp.meta.attribute.MetaAttribute

public class Entity {

	MetaEntity metaEntity

	static hasMany = [ attributes: Attribute ]

	static mapping = {
		metaEntity cache: 'read-only'
		attributes batchSize: 100
	}

	Attribute attribute(String attributeName) {
		attributes.find { Attribute a -> a.metaAttribute.name == attributeName }
	}

	static Entity create(MetaEntity metaEntity) {
		def entity = new Entity(metaEntity: metaEntity)
		metaEntity.getMetaAttributes().each {
			entity.addToAttributes(new Attribute(metaAttribute: it))
		}
		return entity
	}

}