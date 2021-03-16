package store;

import Exceptions.ItemDoesNotExistException;
import order.Order;
import pizza.ChicagoPizza;
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
            System.out.println("Oven started cooking a pizza!");
            orderItem.getValue().cook();
            TimeUnit.SECONDS.sleep((long) orderItem.getValue().getEstimatePrepTime());
            System.out.println("Oven finished cooking a pizza!");
        }
        System.out.println("All pizza's cooked successfully");
        order.setOrderStatus(true);
        this.setReadyStatus(true);
    }

    public boolean isReadyStatus() {
        return readyStatus;
    }

    public void setReadyStatus(boolean readyStatus) {
        this.readyStatus = readyStatus;
    }

    public static void main(String[] args) throws ItemDoesNotExistException, InterruptedException {
        Store store = new Store();
        Order order = store.createOrder("Kabir");
        order.addPizza("chicago-pizza", "foo");
        order.decorateAPizza("foo", "sausage");
        System.out.println(order.getOrderStatus());
        System.out.println(order.findPizza("foo").getStatus());
        Oven oven = new Oven();
        oven.prepareOrder(order);
        System.out.println(order.getOrderStatus());
        System.out.println(order.findPizza("foo").getStatus());

    }

}
