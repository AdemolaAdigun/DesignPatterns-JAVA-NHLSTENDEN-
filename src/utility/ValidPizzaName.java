package utility;

import java.util.ArrayList;

/**
 * Use for adding available pizza available.
 */
public class ValidPizzaName {

    public static ArrayList<String> namesOfValidPizza() {
        ArrayList<String> namesOfPizza = new ArrayList<>();;
        namesOfPizza.add("chicago-pizza");
        namesOfPizza.add("new-york-pizza");
        namesOfPizza.add("veggie-pizza");
        namesOfPizza.add("basic-pizza");

        return namesOfPizza;
    }
}
