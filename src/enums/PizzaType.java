package enums;

public enum PizzaType {
    CHICAGO_PIZZA("This is chicago pizza"),
    BASIC_PIZZA("This is basic pizza"),
    NEW_YORK_PIZZA("This is new york pizza"),
    VEGGIE_PIZZA("This is veggie pizza");

    private String description;
    PizzaType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public static void main(String[] args) {

    }
}

