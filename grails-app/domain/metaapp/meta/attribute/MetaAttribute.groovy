package metaapp.meta.attribute

import metaapp.meta.MetaData
import metaapp.meta.MetaEntity

class MetaAttribute extends MetaData {

	static belongsTo = [ metaEntity: MetaEntity ]

	def getType() {
		getClass().simpleName.replaceFirst("MetaAttribute", "")
	}

}
