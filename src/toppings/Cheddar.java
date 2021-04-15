package toppings;

import pizza.Pizza;

public class Cheddar extends ToppingDecorator {
    private final static double PRICE = 1.50;
    private final static double PREP_TIME = 23;

    public Cheddar(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with Cheddar";
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
