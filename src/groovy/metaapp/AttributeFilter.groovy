package metaapp

import metaapp.meta.attribute.MetaAttribute

class AttributeFilter {

	MetaAttribute filteredAttribute
	String filterOnValue
	
	Boolean isActive() {
		filteredAttribute && filterOnValue
	}

}
