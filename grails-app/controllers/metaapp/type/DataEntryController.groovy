package metaapp.type

import metaapp.command.AttributeGrid
import metaapp.command.AttributeRow
import metaapp.data.Entity
import metaapp.meta.MetaEntity
import metaapp.view.Layout

class DataEntryController {

	def attributeService

    def index = {
		def orderMetaData = MetaEntity.findByName("Order")
		def orders = Entity.findAllByMetaEntity(orderMetaData, [max:20, offset: 300])
		def placeOrderLayout = Layout.findByName("Place Order")
		return [ entities: orders, layout: placeOrderLayout, metaEntity: orderMetaData ]
	}

	def insert = { AttributeRow row ->
		attributeService.insertRow(row)
		redirect(action: 'index')
	}

	def update = { AttributeGrid grid ->
		attributeService.updateGrid(grid)
		redirect(action: 'index')
	}

}
