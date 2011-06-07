package metaapp.meta.attribute.value

import metaapp.meta.attribute.ListMetaAttribute

class Option {

	String value

	static belongsTo = [ metaAttributeList: ListMetaAttribute ]

	static mapping = {
		cache 'read-only'
	}

	public String toString() {
		value
	}

}