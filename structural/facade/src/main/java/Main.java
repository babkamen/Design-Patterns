import facade.AutomatedTellMachine;

public class Main {
    public static void main(String[] args) {
        AutomatedTellMachine atm = new AutomatedTellMachine();
        //inserting card and pin number
        boolean isValid = atm.validateUser("1234", "4321");
        if(isValid){
            //checking balance with one of the account # retrieved from User object
            atm.displayBalance("A");
            //transferring X from account A to B
            atm.transfer("A", "B", 5000d);
            //depositing a check of $50,000 into account B
            atm.deposit("B", "Check", 50000d);
            //withdraw $10,000 from account A
            atm.withdraw("A", 10000d);
        }else{
            System.out.println("You've entered a damaged card or invalid pin...");
        }
    }
}
