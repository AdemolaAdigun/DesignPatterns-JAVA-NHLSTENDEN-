package pizza;

public class BasicPizza implements Pizza{

    private boolean status;
    private final static double COST = 10;
    private final static double ESTIMATED_PREP_TIME = 10;

    public BasicPizza() {
    }

    @Override
    public double getPrice() {
        return COST;
    }

    @Override
    public boolean getStatus() {
        return this.status;
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

    @Override
    public String getDescription() {
       return "Basic pizza";
    }
}
