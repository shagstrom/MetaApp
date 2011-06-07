package metaapp.meta.attribute

import metaapp.meta.attribute.MetaAttribute
import metaapp.data.value.Text
import metaapp.data.value.Value

class StringMetaAttribute extends MetaAttribute {

	public Value createValue(String value) {
		Value text = new Text()
		text.update(value)
		return text
	}
}
