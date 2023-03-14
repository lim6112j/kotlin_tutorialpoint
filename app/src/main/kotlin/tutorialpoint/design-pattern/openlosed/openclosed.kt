// strategy pattern open-closed principle
package tutorialpoint.designpattern.openclosed
class Order(var shipping: Shipping) {
    fun setShippingType(shippingType: Shipping) { this.shipping = shippingType }
    fun getShippingCost(): String = this.shipping.getCost(this)
}
interface Shipping {
    fun getCost(order: Order): String
    fun getDate(order: Order): String
}
class LandShipping : Shipping {
    override fun getCost(order: Order): String = "LandShiping cost : 100$"
    override fun getDate(order: Order): String = "2022-1-11"
}
class AirShipping : Shipping {
    override fun getCost(order: Order): String = "Air Shipping Cost : 1000$"
    override fun getDate(order: Order): String = "2023-1-11"
}
