import store.Store;
import utility.ValidPizzaName;

import java.util.Scanner;

public class RunApplication {
    //declare variables needed
    private Store store;

    //Scanner and commands
    private Scanner userInput;
    private int startCommand;

    //thinking of taking this variable to order class or any appropriate class
    private String orderCommand;
    private String orderName;

    private int amountOfPizza;
    private String pizzaName;
    private String itemName;

    public RunApplication() {
        userInput = new Scanner(System.in);
        this.welcomeMessage();
    }

    private void welcomeMessage() {
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
    private void store() {
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
    private void createOrder() {
        System.out.print("would you want to create an order? (y/n) ");
        setUserInput(new Scanner(System.in));//set a new input inside the scanner
        orderCommand = userInput.nextLine();
        switch (orderCommand.toLowerCase()) {
            case "y" -> {
                System.out.print("Enter the name of the person placing the order: ");
                orderName = userInput.nextLine();//get orderName
                store.createOrder(orderName);//save order name
                System.out.println("Order created with orderName " + orderName);
                this.amountOfPizzaToOrder();
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
    private void amountOfPizzaToOrder() {
        System.out.print("How many pizza do you want: ");
        setUserInput(new Scanner(System.in));//set a new input inside the scanner
        amountOfPizza = userInput.nextInt();//get amount of pizza
        System.out.print("List of available pizza: \nchicago-pizza. \nnew-york-pizza. \nveggie-pizza.\nbasic-pizza.\n");
        for (int i = 1; i <= amountOfPizza; i++) {
            System.out.print("Enter pizza " + i + ": ");
            //keeping repeating if not valid pizza name
            do{
            //getPizzaEntered();
                setUserInput(new Scanner(System.in));//set a new input inside the scanner
                pizzaName = userInput.nextLine();//getting pizzaName
            if(!ValidPizzaName.namesOfValidPizza().contains(pizzaName)) {//check to not print again it when statement is satisfied
                System.out.print("Enter pizza name again not part of list: ");
              }
             } while (!ValidPizzaName.namesOfValidPizza().contains(pizzaName));

            System.out.print("Enter item name for " + pizzaName + " ");//pizza item
            itemName = userInput.nextLine();//getting pizzaItemName
            store.findOrder(orderName).addPizza(pizzaName, itemName);//find order and add pizza

        }
    }

    private void decoratePizza() {

    }
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

