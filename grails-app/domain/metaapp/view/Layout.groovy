package metaapp.view

class Layout {

	String name

    static hasMany = [ attributeLayouts: AttributeLayout ]

	static mapping = {
		attributeLayouts sort: "sequence"
		cache 'read-only'
	}

}
