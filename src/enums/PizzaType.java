package enums;

public enum PizzaType {

    CHICAGO_PIZZA("chicago-pizza"),
    BASIC_PIZZA("basic-pizza"),
    NEW_YORK_PIZZA("new-york-pizza"),
    VEGGIE_PIZZA("veggie-pizza");

    private String pizzaName;

    PizzaType(String description) {
        this.pizzaName = description;
    }

    public String getPizzaName() {
        return this.pizzaName;
    }
}

