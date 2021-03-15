package pizza;

public interface Pizza {
    double getPrice();
    boolean isReady();
    void setStatus(boolean status);
    void cook();
    double estimatePrepTime();
}
