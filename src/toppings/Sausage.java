package toppings;

import pizza.Pizza;

public class Sausage extends ToppingDecorator {
    private final static double PRICE = 2.50;
    private final static double PREP_TIME = 15;
    private boolean status;

    public Sausage(Pizza pizza) {
        super(pizza);
        this.status = false;
    }

    @Override
    public String getDescription() {
        return getPizza().getDescription() + " with Sausage";
    }

    @Override
    public double getPrice() {
        return PRICE + super.getPrice();
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
        super.setStatus(true);
    }

    @Override
    public double getEstimatePrepTime(){
        return PREP_TIME + super.getEstimatePrepTime();
    }
}
