package order;

import Exceptions.ItemDoesNotExistException;
import payment.Payment;
import pizza.*;
import toppings.*;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private final PizzaBuilder pizzaBuilder;
    private final HashMap<String, Pizza> orders;
    private boolean orderStatus;
    private boolean isPaid;

    public Order() {
        this.pizzaBuilder = new PizzaBuilder();
        this.orders = new HashMap<>();
        this.orderStatus = false;
        this.isPaid = false;
    }

    public void addPizza(String typeOfPizza, String itemName) {
        Pizza newPizza = this.pizzaBuilder.buildPizza(typeOfPizza);
        orders.put(itemName, newPizza);
    }

    public Pizza findPizza(String itemName) {
        return orders.get(itemName);
    }

    public boolean getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public HashMap<String, Pizza> getOrders() {
        return orders;
    }

    public void addDecorationPizza(String itemName, String toppingType) throws ItemDoesNotExistException {
        Pizza pizza = orders.get(itemName);
        Pizza decoratedPizza;
        switch (toppingType) {
            case "sausage":
                decoratedPizza = new Sausage(pizza);
                break;
            case "mushroom":
                decoratedPizza = new Mushroom(pizza);
                break;
            case "pepperoni":
                decoratedPizza = new Pepperoni(pizza);
                break;
            case "cheddar":
                decoratedPizza = new Cheddar(pizza);
                break;
            default:
                throw new ItemDoesNotExistException();
        }
        orders.put(itemName, decoratedPizza);
    }

    public double calculateCost() {
        double totalcost = 0.0;
        for (Map.Entry<String, Pizza> pizzas : orders.entrySet()) {
            if(pizzas.getValue().getStatus()) {
                totalcost += pizzas.getValue().getPrice();
            }
        }
        return totalcost;
    }

    public void payment(Payment payment) {
        double amount = calculateCost();
        payment.pay(amount);
    }
}
