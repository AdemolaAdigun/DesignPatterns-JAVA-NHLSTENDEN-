package pizza;

public class PizzaBuilder {

    public PizzaBuilder() {
    }

    public Pizza buildPizza(String pizzaName) {
        Pizza pizza;
        switch (pizzaName) {
            case "chicago-pizza":
                pizza = new ChicagoPizza();
                break;
            case "new-york-pizza":
                pizza = new NewYorkPizza();
                break;
            case "veggie-pizza":
               pizza = new VeggiePizza();
               break;
            case "basic-pizza":
                pizza = new BasicPizza();
                break;
            default:
                pizza = null;
        }
        return pizza;
    }
}
