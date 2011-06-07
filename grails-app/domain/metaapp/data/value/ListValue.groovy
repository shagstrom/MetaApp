package metaapp.data.value

import metaapp.meta.attribute.value.Option

public class ListValue extends Value {

	Option option

	static mapping = {
		option fetch: 'join'
	}

	@Override
	public void update(String value) {
		def optionId = value.toLong()
		option = Option.get(optionId)
	}

	public String toString() {
		option.toString()
	}

}
