package com.babkamen.bank_example;

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
        if (c.action == Command.Action.DEPOSIT) {
            balance += c.amount;
            c.success = true;
        } else if (c.action == Command.Action.WITHDRAW && c.amount < balance) {
            balance -= c.amount;
            c.success = true;
        }
    }
}