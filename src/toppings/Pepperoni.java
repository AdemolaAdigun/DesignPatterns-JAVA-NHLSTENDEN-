package toppings;

import pizza.Pizza;

public class Pepperoni extends ToppingDecorator {
    private final static double PRICE = 3.50;
    private final static double PREP_TIME = 16;
    private boolean status;

    public Pepperoni(Pizza pizza) {
        super(pizza);
        this.status = false;
    }

    @Override
    public String getDescription() {
        return getPizza().getDescription() + " with Pepperoni";
    }

    @Override
    public double getPrice() {
        return PRICE;
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void cook() {
        setStatus(true);
        super.setStatus(true);
    }

    @Override
    public double getEstimatePrepTime() {
        return PREP_TIME;
    }
}
