package toppings;

import pizza.Pizza;

public class Mushroom extends ToppingDecorator {
    private final static double PRICE = 3.50;
    private final static double PREP_TIME = 12;
    private boolean status;

    public Mushroom(Pizza pizza) {
        super(pizza);
        this.status = false;
    }

    @Override
    public String getDescription() {
        return getPizza().getDescription() + " with Mushrooms";
    }


    @Override
    public double getPrice() {
        return PRICE;
    }

    @Override
    public boolean getStatus() {
        return this.status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void cook() {
        super.setStatus(true);
    }

    @Override
    public double getEstimatePrepTime() {
        return PREP_TIME;
    }
}
