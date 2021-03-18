package store;

import pizza.Pizza;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Oven {
    private double prepTime;
    private boolean readyStatus;

    public Oven() {
        this.prepTime = 0;
        this.readyStatus = false;
    }

    public double getPrepTime() {
        return prepTime;
    }

    public void prepareOrder(Order order) throws InterruptedException {
        for(Map.Entry<String, Pizza> orderItem : order.getPizzaOrders().entrySet()) {
            System.out.println("Oven started cooking " + orderItem.getValue().getDescription());
            orderItem.getValue().cook();
            TimeUnit.SECONDS.sleep((long) orderItem.getValue().getEstimatePrepTime());
            System.out.println("Oven finished cooking "  + orderItem.getValue().getDescription()) ;
        }
        System.out.println("All pizza's cooked successfully");
        order.setOrderStatus(true);
        this.setReadyStatus(true);
    }

    public boolean isReadyStatus() {
        return this.readyStatus;
    }

    public void setReadyStatus(boolean readyStatus) {
        this.readyStatus = readyStatus;
    }



}
