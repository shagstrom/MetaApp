package metaapp.command

import org.apache.commons.collections.ListUtils
import org.apache.commons.collections.FactoryUtils

class AttributeGrid {
	List<AttributeRow> rows = ListUtils.lazyList([], FactoryUtils.instantiateFactory(AttributeRow))
}
