package pizza;

public interface Pizza {
    double getPrice();
    boolean getStatus();
    void setStatus(boolean status);
    void cook();
    double getEstimatePrepTime();
    String getDescription();
}
