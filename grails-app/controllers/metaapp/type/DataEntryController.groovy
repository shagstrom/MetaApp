package metaapp.type

import metaapp.command.AttributeGrid
import metaapp.command.AttributeRow
import metaapp.data.Entity
import metaapp.meta.MetaEntity
import metaapp.view.Layout
import metaapp.AttributeFilter
import metaapp.Paginator

class DataEntryController {

	def attributeService
	def entityService
	
	def afterInterceptor = { model ->
		model.queryMap = getQueryParams(request)
	}

    def index = { AttributeFilter filter, Paginator paginator ->
		def orderMetaData = MetaEntity.findByName("Order")
		def orders = entityService.findAll(orderMetaData, filter, paginator)
		def totalNumberOfOrders = entityService.count(orderMetaData, filter)
		def placeOrderLayout = Layout.findByName("Place Order")
		return [ 
			entities: orders,
			totalNumberOfEntities: totalNumberOfOrders,
			layout: placeOrderLayout,
			metaEntity: orderMetaData
		]
	}

	def insert = { AttributeRow row ->
		attributeService.insertRow(row)
		redirect(action: 'index', params: getQueryParams(request))
	}

	def update = { AttributeGrid grid ->
		attributeService.updateGrid(grid)
		redirect(action: 'index', params: getQueryParams(request))
	}
	
	def getQueryParams(request) {
		def map = [:]
		request.queryString?.split("&").each {
			def parts = it.split("=")
			map[parts[0]] = parts.size() > 1 ? parts[1] : ""
		}
		map
	}
	
}
