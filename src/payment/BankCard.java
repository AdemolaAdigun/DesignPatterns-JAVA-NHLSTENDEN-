package payment;

public class BankCard implements Payment {
    private String name;
    private int cardNumber;

    public BankCard(String name, int cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCardNumber() {
        return this.cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount + "paid with Bank card");
    }
}
