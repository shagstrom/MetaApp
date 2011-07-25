package metaapp

class Paginator {
	Long max = 10
	Long offset = 0
	
	def getParams() {
		[ max: max, offset: offset ]
	}
}
