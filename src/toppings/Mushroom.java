package toppings;

import pizza.Pizza;

public class Mushroom extends ToppingDecorator {
    private final static double PRICE = 3.20;
    private final static double PREP_TIME = 12;

    public Mushroom(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with Mushrooms";
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
