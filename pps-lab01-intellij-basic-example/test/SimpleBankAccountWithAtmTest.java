import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccountWithAtm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccountWithAtm implementation
 */
class SimpleBankAccountWithAtmTest {

    private AccountHolder accountHolder;
    private SimpleBankAccountWithAtm bankAccountWithAtm;

    private double feeAtm = 2;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccountWithAtm = new SimpleBankAccountWithAtm(accountHolder, 0, feeAtm);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccountWithAtm.getBalance());
    }

    @Test
    void testDepositAtm() {
        int balance = 100;
        bankAccountWithAtm.depositWithAtm(accountHolder.getId(), balance);
        assertEquals(balance - feeAtm, bankAccountWithAtm.getBalance());
    }

    @Test
    void testWrongDeposit() {
        bankAccountWithAtm.depositWithAtm(accountHolder.getId(), 100);
        bankAccountWithAtm.depositWithAtm(2, 50);
        assertEquals(100-feeAtm, bankAccountWithAtm.getBalance());
    }

    @Test
    void testWithdrawAtm() {
        bankAccountWithAtm.depositWithAtm(accountHolder.getId(), 100);
        bankAccountWithAtm.withdrawWithAtm(accountHolder.getId(), 70);
        assertEquals(30-(2*feeAtm), bankAccountWithAtm.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        bankAccountWithAtm.depositWithAtm(accountHolder.getId(), 100);
        bankAccountWithAtm.withdrawWithAtm(2, 70);
        assertEquals(100-feeAtm, bankAccountWithAtm.getBalance());
    }



}