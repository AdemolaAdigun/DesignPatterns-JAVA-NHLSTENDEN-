package pizza;

public class BasicPizza implements Pizza{

    private boolean status;
    private final static double COST = 20;
    private final static double ESTIMATED_PREP_TIME = 20;

    public BasicPizza() {
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void setStatus(boolean status) {

    }

    @Override
    public void cook() {

    }

    @Override
    public double estimatePrepTime() {
        return 0;
    }
}
