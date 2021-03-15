package store;

import enums.PizzaType;
import pizza.Pizza;

import java.util.ArrayList;

public class PizzaMenu {
   private ArrayList<PizzaType> pizzaTypes;

    public PizzaMenu() {
        this.pizzaTypes = new ArrayList<>();
        this.pizzaTypes.add(PizzaType.BASIC_PIZZA);
        this.pizzaTypes.add(PizzaType.VEGGIE_PIZZA);
        this.pizzaTypes.add(PizzaType.CHICAGO_PIZZA);
        this.pizzaTypes.add(PizzaType.NEW_YORK_PIZZA);
    }

    public void printMenu() {
        for (PizzaType pizzaType: this.pizzaTypes) {
            System.out.println(pizzaType.getDescription());
        }
    }
}
