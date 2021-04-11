package payment;

import java.util.Scanner;

public class Paypal implements Payment {
    private String email;
    private String password;

    public Paypal(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        Scanner scanner = new Scanner(System.in);
        String emailToConfirm = "";
        System.out.print("Enter email to confirm payment: ");
        //keep repeating until email is correct
        do {
            emailToConfirm = scanner.nextLine();
            if (!(emailToConfirm.equals(getEmail())))
                System.out.print("Email incorrect enter again: ");

        } while (!(emailToConfirm.equals(getEmail())));

        System.out.println("payment successful");
        System.out.println("paid " + amount + " with PayPal");
    }

    private void confirmEmail() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter email to confirm: ");
//        String e = scanner.nextLine();
//
//        if(!e.equals(getEmail())) {
//            System.out.println("email is incorrect");
//        }
//        else {
//            System.out.println("payment successful");
//        }
    }

}
