package metaapp

import metaapp.command.AttributeCommand
import metaapp.command.AttributeGrid
import metaapp.command.AttributeRow
import metaapp.data.Attribute
import metaapp.data.Entity
import metaapp.meta.MetaEntity
import metaapp.meta.attribute.MetaAttribute

class AttributeService {

	static transactional = true

	def updateGrid(AttributeGrid grid) {
		grid.rows.each { row ->
			row.attributes.each { updateAttributeCommand(it) }
		}
	}

	def insertRow(AttributeRow row) {
		Entity entity = Entity.create(row.metaEntity)
		row.attributes.each {
			Attribute attribute = entity.attribute(row.attribute.metaAttribute.name)
			attribute.value = attribute.metaAttribute.createValue(it.value)
		}
		entity.save()
	}

	private updateAttributeCommand(AttributeCommand attributeCommand) {
		attributeCommand.attribute.value.update(attributeCommand.value)
		attributeCommand.attribute.save()
	}

}
