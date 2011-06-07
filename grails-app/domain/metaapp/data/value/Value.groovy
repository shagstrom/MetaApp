package metaapp.data.value

import metaapp.data.Attribute

public class Value {

	static belongsTo = Attribute

	public void update(String value) {
		throw new IllegalAccessException("""This method should be implemeted in the "concrete" class. Gorm does not support abstract classes, yet.""")
	}

}
