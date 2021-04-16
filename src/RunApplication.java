import Exceptions.ItemDoesNotExistException;
import payment.BankCard;
import payment.Payment;
import payment.Paypal;
import store.Store;
import store.order.Order;
import utility.Menu;

import java.util.Scanner;

/**
 * This is the frontend of our application
 */
public class RunApplication {
    //declare variables needed
    private Store store;

    //Scanner and commands
    private Scanner userInput;
    private int startCommand;
    private String orderCommand;
    private String customerName;
    private String paymentOption;
    private String pizzaName;
    private String orderItemName;
    private String topping;

    /**
     * Initialise all variables in a new instance of our RunApplication class
     * @throws ItemDoesNotExistException
     * @throws InterruptedException
     */
    public RunApplication() throws ItemDoesNotExistException, InterruptedException {
        userInput = new Scanner(System.in);
        this.welcomeMessage();
        this.startCommand = 0;
        this.orderCommand = "";
        this.customerName = "";
        this.paymentOption = "";
        this.pizzaName = "";
        this.orderItemName = "";
        this.topping = "";
    }

    /**
     * Initial step when application starts
     * @throws ItemDoesNotExistException
     * @throws InterruptedException
     */
    private void welcomeMessage() throws ItemDoesNotExistException, InterruptedException {
        System.out.println("Welcome to our pizza system.");
        System.out.print("Press 1 to start and create a store or 0 to exit: ");
        startCommand = userInput.nextInt();
        store(startCommand);
    }

    public void setUserInput(Scanner userInput) {
        this.userInput = userInput;
    }

    /**
     * Used for creating store based on user input
     * @param startCommand
     * @throws ItemDoesNotExistException
     * @throws InterruptedException
     */
    private void store(int startCommand) throws ItemDoesNotExistException, InterruptedException {
        switch (startCommand) {
            case 1:
                this.store = new Store();
                System.out.println("store successfully created.");
                this.createOrder();
                break;
            case 0:
                userInput.close();
                System.out.println("program exited.");
                break;
            default:

        }
    }

    /**
     * Creates an order
     * @throws ItemDoesNotExistException
     * @throws InterruptedException
     */
    private void createOrder() throws ItemDoesNotExistException, InterruptedException {
        System.out.print("would you want to create an order? (y/n) ");
        setUserInput(new Scanner(System.in));//set a new input inside the scanner
        this.orderCommand = userInput.nextLine();
        switch (this.orderCommand.toLowerCase()) {
            case "y" -> {
                System.out.print("Enter the name of the person placing the order: ");
                this.customerName = userInput.nextLine();//get customerName
                this.store.createOrder(customerName);//save order name
                System.out.println("Order created for " + customerName);
                this.createPizza();
            }
            case "n" -> {
                userInput.close();
                System.out.println("exited");
            }
        }
    }

    /**
     * Create a pizza from menu based on user input
     * @throws ItemDoesNotExistException
     * @throws InterruptedException
     */
    private void createPizza() throws ItemDoesNotExistException, InterruptedException {
        System.out.print("Select from our available pizza: \nchicago-pizza. \nnew-york-pizza. \nveggie-pizza.\nbasic-pizza.\n");
        do {
            setUserInput(new Scanner(System.in));//set a new input inside the scanner
            this.pizzaName = userInput.nextLine();//getting pizzaName
            if (!Menu.availablePizza().contains(pizzaName)) {//check to not print again it when statement is satisfied
                System.out.print("Enter pizza name again not part of list: ");
            }
        } while (!Menu.availablePizza().contains(pizzaName));

        System.out.print("Enter item name for " + this.pizzaName + " ");//pizza item
        setUserInput(new Scanner(System.in));
        this.orderItemName = userInput.nextLine();//getting pizzaItemName
        this.store.findOrder(this.customerName).addPizza(this.pizzaName, this.orderItemName);//find order and add pizza
        this.decoratePizza(this.orderItemName);
    }

    /**
     * Decorates pizza with the corresponding item name
     * @param itemName
     * @throws ItemDoesNotExistException
     * @throws InterruptedException
     */
    private void decoratePizza(String itemName) throws ItemDoesNotExistException, InterruptedException {
        System.out.print("Select from our available topping: \nsausage. \nmushroom. \npepperoni.\ncheddar.\n");
        do {
            setUserInput(new Scanner(System.in));//set a new input inside the scanner
            this.topping = userInput.nextLine();//get toppings
            if (!Menu.availableTopping().contains(topping))
                System.out.print("Enter toppings name again not part of list: ");
        } while (!Menu.availableTopping().contains(topping));

        this.store.findOrder(this.customerName).addDecorationToPizza(itemName, this.topping);
        this.prepareOrder(this.store.findOrder(this.customerName));
    }

    /**
     * Prepares order and accepts payment
     * @param order
     * @throws ItemDoesNotExistException
     * @throws InterruptedException
     */
    private void prepareOrder(Order order) throws ItemDoesNotExistException, InterruptedException {
        System.out.print("Enter 1 to add another pizza to order or 2 to checkout current order? ");
        setUserInput(new Scanner(System.in));
        this.orderCommand = userInput.nextLine();
        switch (this.orderCommand.toLowerCase()) {
            case "1" -> {
                this.createOrder();
            }
            case "2" -> {
                double bill = order.calculateBill();
                System.out.print("Your bill is " + bill + ", select a payment method. \nEnter 1 for bank-card and 2 for paypal ");
                setUserInput(new Scanner(System.in));//set a new input inside the scanner
                paymentOption = userInput.nextLine();//get payment option selected
                switch (paymentOption.toLowerCase()) {
                    case "1" -> {
                        System.out.print("Enter your IBAN ");
                        setUserInput(new Scanner(System.in));
                        int iban = userInput.nextInt();
                        Payment payment = new BankCard(customerName, iban);//create a bank card when option selected
                        this.store.findOrder(customerName).payment(payment);
                        this.orderPrep(this.store.findOrder(customerName));
                    }
                    case "2" -> {
                        System.out.print("Enter your paypal email ");
                        setUserInput(new Scanner(System.in));
                        String email = userInput.nextLine();
                        System.out.print("Enter your paypal password ");
                        setUserInput(new Scanner(System.in));
                        String password = userInput.nextLine();
                        Payment payment = new Paypal(email, password);//create a paypapl when option selected
                        this.store.findOrder(customerName).payment(payment);
                        this.orderPrep(this.store.findOrder(customerName));
                    }
                }
            }
        }
    }

    /**
     * prepares order entered as a parameter
     * @param order
     * @throws InterruptedException
     * @throws ItemDoesNotExistException
     */
    private void orderPrep(Order order) throws InterruptedException, ItemDoesNotExistException {
        if (order.isPaid()) { //If order is paid then start cooking
            double time = order.getOrderEstimatedPreparationTime();
            System.out.print("Sit back relax while we prepare your order. \n" +
                    "Your order will be ready in " + time + " seconds");
            order.cookOrder();
            System.out.println("\nYour Order is done and on its way! Thank you good-bye :)");
            System.out.print("Enter 1 to create another order or 2 to end ");
            setUserInput(new Scanner(System.in));
            String choice = userInput.nextLine();
            switch (choice.toLowerCase()) {
                case "1" -> {
                    this.createOrder();
                }
                case "2" -> {
                    userInput.close();
                }
            }
        }
    }
}
