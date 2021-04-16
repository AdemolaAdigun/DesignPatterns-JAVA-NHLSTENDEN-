import Exceptions.ItemDoesNotExistException;
import pizza.Pizza;
import store.Store;
import utility.Menu;

import java.util.Map;
import java.util.Scanner;

public class RunApplication {
    //declare variables needed
    private Store store;

    //Scanner and commands
    private Scanner userInput;
    private int startCommand;

    //thinking of taking this variable to order class or any appropriate class
    private String orderCommand;
    private String userName;

    private int amountOfPizza;
    private String pizzaName;
    private String itemNameEntered;
    private String topping;

    public RunApplication() throws ItemDoesNotExistException, InterruptedException {
        userInput = new Scanner(System.in);
        this.welcomeMessage();
    }

    public String getOrderNameEntered() {
        return this.userName;
    }

    public String getItemNameEntered() {
        return this.itemNameEntered;
    }

    private void welcomeMessage() throws ItemDoesNotExistException, InterruptedException {
        System.out.println("Welcome to our pizza system.");
        System.out.print("Press 1 to start and create a store or 0 to exit: ");
        startCommand = userInput.nextInt();
        store();
    }

    public Scanner getUserInput() {
        return this.userInput;
    }

    public void setUserInput(Scanner userInput) {
        this.userInput = userInput;
    }

    /**
     * use for creating store
     */
    private void store() throws ItemDoesNotExistException, InterruptedException {
        switch (startCommand) {
            case 1:
                store = new Store();
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
     * use for getting order
     */
    private void createOrder() throws ItemDoesNotExistException, InterruptedException {
        System.out.print("would you want to create an order? (y/n) ");
        setUserInput(new Scanner(System.in));//set a new input inside the scanner
        orderCommand = userInput.nextLine();
        switch (orderCommand.toLowerCase()) {
            case "y" -> {
                System.out.print("Enter the name of the person placing the order: ");
                userName = userInput.nextLine();//get orderName
                store.createOrder(userName);//save order name
                System.out.println("Order created with orderName " + userName);
                this.amountOfPizzaToOrder();//calls amount of pizza to create
            }
            case "n" -> {
                userInput.close();
                System.out.println("exited");
            }
        }
    }

    /**
     * use for getting amount of pizza to order
     */
    private void amountOfPizzaToOrder() throws ItemDoesNotExistException, InterruptedException {
        System.out.print("Select from our available pizza: \nchicago-pizza. \nnew-york-pizza. \nveggie-pizza.\nbasic-pizza.\n");
        do {
            setUserInput(new Scanner(System.in));//set a new input inside the scanner
            pizzaName = userInput.nextLine();//getting pizzaName
            if (!Menu.AvailablePizza().contains(pizzaName)) {//check to not print again it when statement is satisfied
                System.out.print("Enter pizza name again not part of list: ");
            }
        } while (!Menu.AvailablePizza().contains(pizzaName));

        System.out.print("Enter item name for " + pizzaName + " ");//pizza item
        itemNameEntered = userInput.nextLine();//getting pizzaItemName
        store.findOrder(userName).addPizza(pizzaName, itemNameEntered);//find order and add pizza
        this.decoratePizza(itemNameEntered);
    }

    private void decoratePizza(String itemName) throws ItemDoesNotExistException, InterruptedException {
        System.out.print("Select from our available topping: \nsausage. \nmushroom. \npepperoni.\ncheddar.\n");
        do {
            setUserInput(new Scanner(System.in));//set a new input inside the scanner
            topping = userInput.nextLine();//get toppings
            if (!Menu.AvailableTopping().contains(topping))
                System.out.print("Enter toppings name again not part of list: ");
        } while (!Menu.AvailableTopping().contains(topping));

        store.findOrder(userName).addDecorationToPizza(itemName, topping);
        this.prepareOrder();
    }

    private void prepareOrder() throws ItemDoesNotExistException, InterruptedException  {
        System.out.print("Enter 1 to add another pizza to order or 2 to checkout current order?");
        setUserInput(new Scanner(System.in));
        orderCommand = userInput.nextLine();
        switch (orderCommand.toLowerCase()) {
            case "1" -> {
                this.createOrder();
            }
            case "2" -> {
                this.store.prepareParticularOrder(userName);

            }
        }
    }

//    private void makePayment() {
//        System.out.print("Select a payment method: \nPaypal \nBank Card");
//        setUserInput(new Scanner(System.in));
//    }
//    private void getPizzaEntered() {
//        setUserInput(new Scanner(System.in));//set a new input inside the scanner
//        pizzaName = userInput.nextLine();//getting pizzaName
//        checkIfUserEnterInvalidPizza(pizzaName);
//    }
//
//    private void checkIfUserEnterInvalidPizza(String pizzaName) {
//
//        do {
//            System.out.print("Enter pizza name again not part of list: ");
//            if (!ValidPizzaName.namesOfValidPizza().contains(pizzaName)) {
//                this.amountOfPizzaToOrder();
//            }
//        } while (!ValidPizzaName.namesOfValidPizza().contains(pizzaName));
//    }


    //TODO if good this way, adding topping decoration will be implemented like the rest

}

