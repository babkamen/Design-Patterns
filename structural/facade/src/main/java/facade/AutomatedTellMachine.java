package facade;

public class AutomatedTellMachine {
    public boolean validateUser(String cardNumber, String pin) {
        //call to complex validation logic goes here...
        System.out.println("performing validation operation...");
        System.out.println("validation is success...");
        return true;
    }

    public boolean getCash(String accountNumber, double preSelectedAmount) {
        //call to complex fast cash logic goes here...
        System.out.println("running sufficient fund logic...");
        System.out.println(String.format("dispensing $%.2f", preSelectedAmount));
        return true;
    }

    public boolean withdraw(String accountNumber, double amount) {
        //call to complex withdrawal logic goes here...
        System.out.println("running sufficient fund logic...");
        System.out.println(String.format("dispensing $%.2f", amount));
        return true;
    }

    public void displayBalance(String accountNumber) {
        //call to complex balance inquiry logic goes here...
        System.out.println("retrieving balance...");
        System.out.println("Balance : $23,500,500");
    }

    public void deposit(String accountNumber, String type, double amount) {
        //call to complex deposit logic goes here...
        System.out.println("validating amount...");
        System.out.println(String.format("depositing $%.2f of type %s", amount, type));
    }

    public boolean transfer(String accountNumberFrom, String accountNumberTo, double amount) {
        //call to complex transfer logic goes here...
        System.out.println("running sufficient fund logic...");
        System.out.println(String.format("transferring $%.2f from %s to %s",
                amount, accountNumberFrom, accountNumberTo));
        return true;
    }
}