package toppings;

import pizza.Pizza;

public class Cheddar extends ToppingDecorator {
    private final static double PRICE = 3.50;
    private final static double PREP_TIME = 23;
    private boolean status;

    public Cheddar(Pizza pizza) {
        super(pizza);
        this.status = false;
    }

    @Override
    public String getDescription() {
        return "Cheddar";
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
