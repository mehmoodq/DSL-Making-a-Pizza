package pizzas

object create {
  def Pizza(block: Pizza => Unit): String = {
    var pizzaObj = new Pizza
    block(pizzaObj)
    pizzaObj.toString
  }
}
