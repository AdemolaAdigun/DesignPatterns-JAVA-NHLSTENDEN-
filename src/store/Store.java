package store;

import java.util.HashMap;
import java.util.Map;

public class Store {
   private final HashMap<String, Order> orders;
   private Oven oven;

   public Store() {
      this.orders = new HashMap<>();
      this.oven = new Oven();
   }

   public Order createOrder(String userName) {
      Order order = new Order();
      orders.put(userName, order);
      return order;
   }

   public void prepareAllOrders() throws InterruptedException {
      for (Map.Entry<String, Order> order : this.orders.entrySet()) {
         if(order.getValue().isPaid()) {
         this.oven.prepareOrder(order.getValue());
         }
      }
   }

   public void prepareParticularOrder(String customerName) throws InterruptedException {
      this.oven.prepareOrder(this.orders.get(customerName));
   }

   public Order findOrder(String customerName) {
      return orders.get(customerName);
   }

   public void deleteOrder(String customerName) {
      this.orders.remove(customerName);
   }

   public double getStoreRevenue() {
      double storeRevenue = 0.0;
      for (Map.Entry<String, Order> order : this.orders.entrySet()) {
         if(order.getValue().isPaid()) {
           storeRevenue += order.getValue().calculateBill();
         }
      }
      return storeRevenue;
   }
}
