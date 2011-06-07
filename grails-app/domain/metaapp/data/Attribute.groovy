package metaapp.data

import metaapp.meta.attribute.MetaAttribute
import metaapp.data.value.Value
import metaapp.data.Entity
import metaapp.data.Entity
import metaapp.data.value.Value

class Attribute {

	MetaAttribute metaAttribute

	Value value

	static belongsTo = [ entity: Entity ]

	static mapping = {
		metaAttribute cache: 'read-only'
		value fetch: 'join'
	}

}
