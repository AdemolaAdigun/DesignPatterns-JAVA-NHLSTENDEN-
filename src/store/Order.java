package store;

import Exceptions.ItemDoesNotExistException;
import payment.Payment;
import pizza.*;
import toppings.*;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private final PizzaBuilder pizzaBuilder;
    private final HashMap<String, Pizza> pizzaOrders;
    private boolean orderStatus;
    private boolean isPaid;

    public Order() {
        this.pizzaBuilder = new PizzaBuilder();
        this.pizzaOrders = new HashMap<>();
        this.orderStatus = false;
        this.isPaid = false;
    }

    public void addPizza(String typeOfPizza, String itemName) {
        Pizza newPizza = this.pizzaBuilder.buildPizza(typeOfPizza);
        pizzaOrders.put(itemName, newPizza);
    }

    public Pizza findPizza(String itemName) {
        return pizzaOrders.get(itemName);
    }

    public boolean getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }

    public HashMap<String, Pizza> getPizzaOrders() {
        return this.pizzaOrders;
    }

    public void addDecorationToPizza(String itemName, String toppingType) throws ItemDoesNotExistException {
        Pizza pizza = pizzaOrders.get(itemName);
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
        pizzaOrders.put(itemName, decoratedPizza);
    }

    public double calculateBill() {
        double totalcost = 0.0;
        for (Map.Entry<String, Pizza> pizzas : pizzaOrders.entrySet()) {
            if(pizzas.getValue().getStatus()) {
                totalcost += pizzas.getValue().getPrice();
            }
        }
        return totalcost;
    }

    public void payment(Payment payment) {
        double amount = calculateBill();
        payment.pay(amount);
        setPaid(true);
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
