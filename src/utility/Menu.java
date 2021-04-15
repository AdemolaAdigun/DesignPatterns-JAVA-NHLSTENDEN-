package utility;

import java.util.ArrayList;

/**
 * Use for adding available pizza available.
 */
public class Menu {

    public static ArrayList<String> AvailablePizza() {
        ArrayList<String> nameOfPizzas = new ArrayList<>();

        nameOfPizzas.add("chicago-pizza");
        nameOfPizzas.add("new-york-pizza");
        nameOfPizzas.add("veggie-pizza");
        nameOfPizzas.add("basic-pizza");

        return nameOfPizzas;
    }

    public static ArrayList<String> AvailableTopping() {
        ArrayList<String> nameOfToppings = new ArrayList<>();

        nameOfToppings.add("sausage");
        nameOfToppings.add("mushroom");
        nameOfToppings.add("pepperoni");
        nameOfToppings.add("cheddar");

        return nameOfToppings;
    }
}
