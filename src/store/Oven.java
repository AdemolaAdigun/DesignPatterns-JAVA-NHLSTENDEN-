package store;

import Exceptions.ItemDoesNotExistException;
import order.Order;
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
        for (Map.Entry<String, Pizza> orderItem : order.getOrders().entrySet()) {
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

    public static void main(String[] args) throws ItemDoesNotExistException, InterruptedException {
        Store store = new Store();
        Order order = store.createOrder("Kabir");
        order.addPizza("chicago-pizza", "foo");
        order.addPizza("veggie-pizza", "te");
        order.addDecorationPizza("foo", "sausage");
        order.addDecorationPizza("te", "cheddar");
        System.out.println(order.findPizza("foo").getStatus());
        System.out.println(order.findPizza("te").getStatus());
        Oven oven = new Oven();
        oven.prepareOrder(order);
//        System.out.println(order.findPizza("foo").getStatus());
//        System.out.println(order.findPizza("te").getStatus());
        System.out.println(oven.readyStatus);
    }

}
