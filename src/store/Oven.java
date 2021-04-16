package store;

import store.order.SubjectOrder;

public class Oven {
    private boolean readyStatus;

    public Oven() {
        this.readyStatus = false;
    }

    public void prepareOrder(SubjectOrder order) throws InterruptedException {
        this.setReadyStatus(false);
        order.cookOrder();
        this.setReadyStatus(true);
    }

    public void setReadyStatus(boolean readyStatus) {
        this.readyStatus = readyStatus;
    }



}
