package implement_banking_system;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

class BankingSystemTest {
    private BankingSystem bank;

    @BeforeEach
    void setUp() {
        bank = new BankingSystem();
        bank.createAccount(1001, 5000);
        bank.createAccount(1002, 3000);
        bank.createAccount(1003, 7000);
    }

    @Test
    void testCreateAccount() {
        bank.createAccount(1004, 2000);
        assertEquals(2000, bank.getBalance(1004));
    }

    @Test
    void testDeposit() {
        bank.deposit(1001, 1500);
        assertEquals(6500, bank.getBalance(1001));
    }

    @Test
    void testWithdrawal() {
        bank.requestWithdrawal(1002, 2000);
        bank.processWithdrawals();
        assertEquals(1000, bank.getBalance(1002));
    }

    @Test
    void testWithdrawalInsufficientFunds() {
        bank.requestWithdrawal(1003, 8000); // More than balance
        bank.processWithdrawals();
        assertEquals(7000, bank.getBalance(1003)); // Balance should remain unchanged
    }

    @Test
    void testSortedAccounts() {
        Map<Double, Integer> sorted = bank.getSortedAccounts();
        assertTrue(sorted.containsKey(3000.0));
        assertTrue(sorted.containsKey(5000.0));
        assertTrue(sorted.containsKey(7000.0));
    }
}
