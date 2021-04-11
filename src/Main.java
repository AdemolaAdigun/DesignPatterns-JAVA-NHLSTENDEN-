import Exceptions.ItemDoesNotExistException;
import payment.BankCard;
import payment.Paypal;
import store.Order;
import store.Oven;
import store.Store;

public class Main {
    public static void main(String[] args) throws ItemDoesNotExistException, InterruptedException {
        //creating store
        Store store = new Store();
        //creating order with the person placing the order
       Order order = store.createOrder("Kabir");
//        //adding pizzas
//        order.addPizza("chicago-pizza", "foo");
//        order.addPizza("veggie-pizza", "te");
//        //adding decoration to pizza
//        order.addDecorationToPizza("foo", "sausage");
//        order.addDecorationToPizza("te", "cheddar");
//        //get the status of pizza withe itemName
//        System.out.println(order.findPizza("foo").getStatus());
//        System.out.println(order.findPizza("te").getStatus());
//        //creating the oven
//        Oven oven = new Oven();
//        //preparing order
//        oven.prepareOrder(order);
//        System.out.println(order.findPizza("foo").getStatus());
//        System.out.println(order.findPizza("te").getStatus());
//       System.out.println("Oven status: " + oven.isReadyStatus());

       //order.payment(new Paypal("solo@gmail.com", "12345"));
       order.payment(new BankCard("Solomon", 12345));
    }
}
