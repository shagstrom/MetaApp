package metaapp.view

import metaapp.meta.attribute.MetaAttribute

class AttributeLayout {

	MetaAttribute metaAttribute
	Long sequence = Long.MAX_VALUE;

	static belongsTo = [ layout: Layout ]

	static mapping = {
		cache 'read-only'
	}

}
