package pizzas

import scala.collection.mutable.ListBuffer
import scala.language.postfixOps

class Pizza {
  var layers = ListBuffer[String]()

  def spread(item : Symbol) = {
    layers += item.name
    this
  }

  def toppings(item : Symbol) = {
    layers += s"toppings: ${item.name}"
    this
  }

  def and(nextTopping: Symbol) = {
    layers.update( layers.size - 1, layers(layers.size - 1).concat(s", ${nextTopping.name}") )
    this
  }

  def bake() = {
    layers += s"baked"
    this
  }

  override def toString = s"Pizza: ${layers.mkString(", ")}".trim

}
