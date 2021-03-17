package toppings;

import pizza.Pizza;

public abstract class ToppingDecorator implements Pizza {
    private Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public Pizza getPizza() {
        return this.pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public abstract String getDescription();

    public double getEstimatePrepTime(){
        return this.pizza.getEstimatePrepTime();
    }

    @Override
    public double getPrice() {
        return this.pizza.getPrice();
    }

    @Override
    public void setStatus(boolean status) {
    }

}
