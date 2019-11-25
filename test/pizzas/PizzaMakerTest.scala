package pizzas

import org.scalatest._
import Matchers._
import create._
import scala.language.postfixOps

class PizzaMakerTest extends FunSuite {
  test("canary") {
    assert(true)
  }

  test("create pizza creates an object of type Pizza") {
    def result =
      create Pizza { _ => }

    assert(result == "Pizza:")
  }

  test("spread sauce") {
    def result =
      create Pizza {
        _ spread 'sauce
      }

    assert(result == "Pizza: sauce")
  }

  test("spread cheese") {
    def result =
      create Pizza {
        _ spread 'cheese
      }

    assert(result == "Pizza: cheese")
  }

  test("toppings option 1") {
    def result =
      create Pizza {
        _ toppings 'tomatoes
      }

    assert(result == "Pizza: toppings: tomatoes")
  }

  test("toppings option 2") {
    def result =
      create Pizza {
        _ toppings 'tomatoes and 'onion and 'red_peppers
      }

    assert(result == "Pizza: toppings: tomatoes, onion, red_peppers")
  }

  test("bake pizza") {
    def result =
      create Pizza {
        _ bake
      }

    assert(result == "Pizza: baked")
  }

  test("add all ingredients and bake pizza") {
    def result =
      create Pizza {
        _ spread 'sauce toppings 'tomatoes and 'onion and 'green_peppers spread 'cheese bake
      }

    assert(result == "Pizza: sauce, toppings: tomatoes, onion, green_peppers, cheese, baked")
  }

}
