package metaapp.meta.attribute

import metaapp.meta.attribute.value.Option
import metaapp.data.value.Value
import metaapp.data.value.ListValue

public class ListMetaAttribute extends MetaAttribute {

	static hasMany = [ options: Option ]

	public Value createValue(String value) {
		Value listValue = new ListValue()
		listValue.update(value)
		return listValue
	}

}