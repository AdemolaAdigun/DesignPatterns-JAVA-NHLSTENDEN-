package store;

public interface Subject_Order {
    void cookOrder() throws InterruptedException;
    boolean getAPizzaStatus(String itemName);
}
