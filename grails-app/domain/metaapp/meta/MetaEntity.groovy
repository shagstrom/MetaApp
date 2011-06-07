package metaapp.meta

import metaapp.meta.MetaData
import metaapp.meta.attribute.MetaAttribute
import metaapp.meta.attribute.MetaAttribute

class MetaEntity extends MetaData {

	static hasMany = [
		metaAttributes: MetaAttribute
	]

}
