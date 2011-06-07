package metaapp.meta

class MetaData {

	String name

	static mapping = {
		cache 'read-only'
	}

	public String toString() {
		name
	}

}
