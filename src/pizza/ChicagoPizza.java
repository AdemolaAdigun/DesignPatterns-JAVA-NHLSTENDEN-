package pizza;

public class ChicagoPizza implements Pizza{

    private boolean status;
    private final static double COST = 20;
    private final static double ESTIMATED_PREP_TIME = 22;

    public ChicagoPizza() {
        this.status = false;
    }

    @Override
    public double getPrice() {
        return COST;
    }

    @Override
    public boolean getStatus() {
        return false;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void cook() {
        setStatus(true);
    }

    @Override
    public double getEstimatePrepTime() {
        return ESTIMATED_PREP_TIME;
    }
}
