package toppings;

import pizza.Pizza;

public abstract class ToppingDecorator {
    protected Pizza pizza;
    public ToppingDecorator() {
        this.pizza = null;
    }


    public void decoratePizza(Pizza pizza) {
        this.pizza = pizza;
    }
}
