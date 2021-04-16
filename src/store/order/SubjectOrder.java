package store.order;

public interface SubjectOrder {
    void cookOrder() throws InterruptedException;
    boolean getAPizzaStatus(String itemName);
}
