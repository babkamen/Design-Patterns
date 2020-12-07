package bank_example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void process() {
        Account account = new Account();
        Command c1 = new Command(Command.Action.DEPOSIT, 1000);
        Command c2 = new Command(Command.Action.WITHDRAW, 100);
        account.process(c1);
        account.process(c2);
        assertTrue(c1.success);
        assertTrue(c2.success);
        assertEquals(900, account.balance);
        Command c3 = new Command(Command.Action.WITHDRAW, 1000);
        account.process(c3);
        assertFalse(c3.success);
        assertEquals(900, account.balance);
    }
}