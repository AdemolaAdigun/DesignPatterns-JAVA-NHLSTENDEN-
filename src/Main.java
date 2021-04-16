import Exceptions.ItemDoesNotExistException;

public class Main {
    public static void main(String[] args) throws ItemDoesNotExistException, InterruptedException {
       startApp();
    }

    public static void startApp() throws InterruptedException, ItemDoesNotExistException {
        RunApplication runApplication = new RunApplication();
    }
}
