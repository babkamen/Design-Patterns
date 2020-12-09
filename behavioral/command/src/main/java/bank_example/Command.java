package bank_example;

class Command {

    public Action action;
    public int amount;
    public boolean success;
    public Command(Action action, int amount) {
        this.action = action;
        this.amount = amount;
    }

    enum Action {
        DEPOSIT, WITHDRAW
    }
}

class Account {

    public int balance;

    public void process(Command c) {
        switch (c.action) {
            case DEPOSIT:
                balance += c.amount;
                c.success = true;
                break;
            case WITHDRAW:
                if (c.amount < balance) {
                    balance -= c.amount;
                    c.success = true;
                }

                break;

        }
    }
}