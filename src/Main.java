import Exceptions.ItemDoesNotExistException;
import store.Order;
import store.Oven;
import store.Store;

public class Main {
    public static void main(String[] args) throws ItemDoesNotExistException, InterruptedException {
        Store store = new Store();
        Order order = store.createOrder("Kabir");
        order.addPizza("chicago-pizza", "foo");
        order.addPizza("veggie-pizza", "te");
        order.addDecorationToPizza("foo", "sausage");
        order.addDecorationToPizza("te", "cheddar");
        System.out.println(order.findPizza("foo").getStatus());
        System.out.println(order.findPizza("te").getStatus());
        Oven oven = new Oven();
        oven.prepareOrder(order);
        System.out.println(order.findPizza("foo").getStatus());
        System.out.println(order.findPizza("te").getStatus());
       System.out.println("Oven status: " + oven.isReadyStatus());
    }
}
