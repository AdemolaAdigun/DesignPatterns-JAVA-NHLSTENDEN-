package pizza;

public class ChicagoPizza implements Pizza{

    private boolean status;
    private final static double COST = 20;
    private final static double ESTIMATED_PREP_TIME = 20;

    public ChicagoPizza() {
        this.status = false;
    }

    @Override
    public double getPrice() {
        return COST;
    }

    @Override
    public boolean isReady() {
        return status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void cook() {

    }

    @Override
    public double estimatePrepTime() {
        return ESTIMATED_PREP_TIME;
    }
}
