package pizza;

public class PizzaBuilder {

    public PizzaBuilder() {
    }

    public Pizza buildPizza(String pizzaName) {
        return switch (pizzaName) {
            case "chicago-pizza" -> new ChicagoPizza();
            case "new-york-pizza" -> new NewYorkPizza();
            case "veggie-pizza" -> new VeggiePizza();
            default -> new BasicPizza();
        };
    }
}
