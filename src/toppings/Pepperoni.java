package toppings;

import pizza.Pizza;

import java.util.Random;

public class Pepperoni extends ToppingDecorator {
    private final static double PRICE = 3.50;
    private final static double PREP_TIME = 16;

    public Pepperoni(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with Pepperoni";
    }

    @Override
    public double getPrice() {
        return super.getPrice() + PRICE;
    }

    @Override
    public void cook() {
        super.setStatus(true);
    }

    @Override
    public double getEstimatePrepTime() {
        return super.getEstimatePrepTime() + PREP_TIME;
    }
}
