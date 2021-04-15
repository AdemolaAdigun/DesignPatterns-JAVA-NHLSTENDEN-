package toppings;

import pizza.Pizza;

public class Sausage extends ToppingDecorator {
    private final static double PRICE = 2.50;
    private final static double PREP_TIME = 15;

    public Sausage(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with Sausage";
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
    public double getEstimatePrepTime(){
        return super.getEstimatePrepTime() + PREP_TIME;
    }
}
