package implement_banking_system;
public class BankingSystemMain {
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.createAccount(1001, 5000);
        bank.createAccount(1002, 3000);
        bank.createAccount(1003, 7000);

        bank.deposit(1002, 2000);

        bank.requestWithdrawal(1001, 1000);
        bank.requestWithdrawal(1003, 8000); // Insufficient funds case

        bank.processWithdrawals();
        bank.displayAccountsSortedByBalance();
    }
}
