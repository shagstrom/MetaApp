package metaapp.command

import metaapp.meta.MetaEntity
import org.apache.commons.collections.ListUtils
import org.apache.commons.collections.FactoryUtils

class AttributeRow {
	MetaEntity metaEntity = new MetaEntity()
	List<AttributeCommand> attributes = ListUtils.lazyList([], FactoryUtils.instantiateFactory(AttributeCommand))
}
