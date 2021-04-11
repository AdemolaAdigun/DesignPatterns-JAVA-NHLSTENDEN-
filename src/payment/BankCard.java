package payment;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        int bankCardToConfirm;
        System.out.print("Enter bank card to confirm payment: ");
        //keep repeating until bank card is correct
        do {
            bankCardToConfirm = scanner.nextInt();
            if(bankCardToConfirm != getCardNumber())
                System.out.print("Bank card incorrect enter again: ");

        } while (bankCardToConfirm != getCardNumber());
        System.out.println("payment successful");
        System.out.println(amount + " paid with Bank card");
    }
}
