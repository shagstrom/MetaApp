import metaapp.data.Entity
import metaapp.data.value.Value
import metaapp.meta.MetaEntity
import metaapp.meta.attribute.ListMetaAttribute
import metaapp.meta.attribute.StringMetaAttribute
import metaapp.meta.attribute.value.Option
import metaapp.view.AttributeLayout
import metaapp.view.Layout
import metaapp.data.value.Text
import metaapp.data.value.ListValue
import metaapp.data.value.ListValue
import metaapp.data.value.Text
import metaapp.data.Entity
import metaapp.data.value.Text
import metaapp.meta.attribute.StringMetaAttribute

class BootStrap {

    def init = { servletContext ->

		def commentDef = new StringMetaAttribute(name: "Comment")
		def firstDef = new StringMetaAttribute(name: "First")
		def lastDef = new StringMetaAttribute(name: "Last")

		def apple = new Option(value: "Apple")
		def banana = new Option(value: "Banana")
		def pear = new Option(value: "Pear");

		def fruitsDef = new ListMetaAttribute(name: "Fruits")
		fruitsDef.addToOptions(apple)
		fruitsDef.addToOptions(banana)
		fruitsDef.addToOptions(pear)

		def bmw = new Option(value: "BMW")
		def audi = new Option(value: "Audi")
		def volvo = new Option(value: "Volvo");
		def mercedes = new Option(value: "Mercedes");
		def saab = new Option(value: "Saab");

		def carsDef = new ListMetaAttribute(name: "Cars")
		carsDef.addToOptions(bmw)
		carsDef.addToOptions(audi)
		carsDef.addToOptions(volvo)
		carsDef.addToOptions(mercedes)
		carsDef.addToOptions(saab)

		def orderDef = new MetaEntity(name: "Order")
		orderDef.addToMetaAttributes(commentDef)
		orderDef.addToMetaAttributes(firstDef)
		orderDef.addToMetaAttributes(lastDef)
		orderDef.addToMetaAttributes(fruitsDef)
		orderDef.addToMetaAttributes(carsDef)
		orderDef.save()


		def commentLayout = new AttributeLayout(metaAttribute: commentDef, sequence: 2)
		def firstLayout = new AttributeLayout(metaAttribute: firstDef, sequence: 3)
		def lastLayout = new AttributeLayout(metaAttribute: lastDef, sequence: 4)
		def fruitsLayout = new AttributeLayout(metaAttribute: fruitsDef, sequence: 1)
		def carsLayout = new AttributeLayout(metaAttribute: carsDef, sequence: 5)
		def layout = new Layout(name: "Place Order")
		layout.addToAttributeLayouts(commentLayout)
		layout.addToAttributeLayouts(firstLayout)
		layout.addToAttributeLayouts(lastLayout)
		layout.addToAttributeLayouts(fruitsLayout)
		layout.addToAttributeLayouts(carsLayout)
		layout.save();

		println "Bootstrapping with 1000 rows of data. This might take a couple of minutes..."
		(1..1000).each {
			createOrder(orderDef, banana, bmw, it)
		}

    }

    def destroy = {
    }

	def createOrder(orderDef, banana, bmw, index) {

		def order = Entity.create(orderDef)

		order.attribute("Comment").value = new Text(value: "This is the comment ${index}")
		order.attribute("First").value = new Text(value: "Simon ${index}")
		order.attribute("Last").value = new Text(value: "Hagstrom ${index}")
		order.attribute("Fruits").value = new ListValue(option: banana)
		order.attribute("Cars").value = new ListValue(option: bmw)
		order.save()
	}

}
