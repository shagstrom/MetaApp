package metaapp

import metaapp.data.Entity;
import metaapp.data.value.ListValue;
import metaapp.data.value.Text;
import metaapp.meta.MetaEntity;
import metaapp.meta.attribute.ListMetaAttribute;
import metaapp.meta.attribute.StringMetaAttribute;
import metaapp.meta.attribute.value.Option;
import grails.test.*

class EntityServiceTests extends GroovyTestCase {
	
	EntityService entityService
	
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testGetOrdersFilteredByStringAttribute() {
		bootstrap()
		def orderMetaEntity = MetaEntity.findByName("Order")
		def firstMetaAttribute = orderMetaEntity.metaAttributes.find { it.name == "First" }
		def filter = new AttributeFilter(filteredAttribute: firstMetaAttribute, filterOnValue: "Anna")
		def orders = entityService.findAll(orderMetaEntity, filter, new Paginator())
		assertEquals 2, orders.size()
		assertEquals "Andersson", orders[0].attribute("Last").value.toString()
    }
	
    void testGetOrdersFilteredByListAttribute() {
		bootstrap()
		def orderMetaEntity = MetaEntity.findByName("Order")
		def firstMetaAttribute = orderMetaEntity.metaAttributes.find { it.name == "Fruits" }
		def filter = new AttributeFilter(filteredAttribute: firstMetaAttribute, filterOnValue: "ana")
		def orders = entityService.findAll(orderMetaEntity, filter, new Paginator())
		assertEquals 2, orders.size()
		assertEquals "Hagstrom", orders[0].attribute("Last").value.toString()
		assertEquals "Persson", orders[1].attribute("Last").value.toString()
    }
	
	private bootstrap() {
		def firstDef = new StringMetaAttribute(name: "First")
		def lastDef = new StringMetaAttribute(name: "Last")

		def apple = new Option(value: "Apple")
		def banana = new Option(value: "Banana")
		def pear = new Option(value: "Pear");

		def fruitsDef = new ListMetaAttribute(name: "Fruits")
		fruitsDef.addToOptions(apple)
		fruitsDef.addToOptions(banana)
		fruitsDef.addToOptions(pear)


		def orderMetaData = new MetaEntity(name: "Order")
		orderMetaData.addToMetaAttributes(firstDef)
		orderMetaData.addToMetaAttributes(lastDef)
		orderMetaData.addToMetaAttributes(fruitsDef)
		orderMetaData.save()


		def order1 = Entity.create(orderMetaData)
		order1.attribute("First").value = new Text(value: "Simon")
		order1.attribute("Last").value = new Text(value: "Hagstrom")
		order1.attribute("Fruits").value = new ListValue(option: banana)
		order1.save()

		def order2 = Entity.create(orderMetaData)
		order2.attribute("First").value = new Text(value: "Anna")
		order2.attribute("Last").value = new Text(value: "Andersson")
		order2.attribute("Fruits").value = new ListValue(option: pear)
		order2.save()

		def order3 = Entity.create(orderMetaData)
		order3.attribute("First").value = new Text(value: "Anna")
		order3.attribute("Last").value = new Text(value: "Persson")
		order3.attribute("Fruits").value = new ListValue(option: banana)
		order3.save()

	}
}
