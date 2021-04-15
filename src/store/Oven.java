package store;

import store.order.Order;

public class Oven {
    private boolean readyStatus;

    public Oven() {
        this.readyStatus = false;
    }

    public void prepareOrder(Order order) throws InterruptedException {
        this.setReadyStatus(false);
        order.cookOrder();
        this.setReadyStatus(true);
    }

    public boolean isReadyStatus() {
        return this.readyStatus;
    }

    public void setReadyStatus(boolean readyStatus) {
        this.readyStatus = readyStatus;
    }



}
