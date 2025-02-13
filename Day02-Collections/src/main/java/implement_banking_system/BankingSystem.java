package implement_banking_system;

import java.util.*;

class BankingSystem {
    private Map<Integer, Double> accountBalances = new HashMap<>();
    private TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    // Create an account
    public void createAccount(int accountNumber, double initialBalance) {
        if (accountBalances.containsKey(accountNumber)) {
            System.out.println("Account already exists!");
            return;
        }
        accountBalances.put(accountNumber, initialBalance);
        sortedAccounts.put(initialBalance, accountNumber);
        System.out.println("Account created: " + accountNumber + " with balance: " + initialBalance);
    }

    // Deposit money
    public void deposit(int accountNumber, double amount) {
        if (!accountBalances.containsKey(accountNumber)) {
            System.out.println("Account not found!");
            return;
        }
        double newBalance = accountBalances.get(accountNumber) + amount;
        sortedAccounts.remove(accountBalances.get(accountNumber)); // Remove old balance
        accountBalances.put(accountNumber, newBalance);
        sortedAccounts.put(newBalance, accountNumber); // Add new balance
        System.out.println("Deposited " + amount + " into account: " + accountNumber);
    }

    // Request a withdrawal
    public void requestWithdrawal(int accountNumber, double amount) {
        if (!accountBalances.containsKey(accountNumber)) {
            System.out.println("Account not found!");
            return;
        }
        withdrawalQueue.offer(new WithdrawalRequest(accountNumber, amount));
        System.out.println("Withdrawal request added for account: " + accountNumber + " Amount: " + amount);
    }

    // Process withdrawal requests
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            int accountNumber = request.accountNumber;
            double amount = request.amount;

            if (accountBalances.get(accountNumber) >= amount) {
                double newBalance = accountBalances.get(accountNumber) - amount;
                sortedAccounts.remove(accountBalances.get(accountNumber)); // Remove old balance
                accountBalances.put(accountNumber, newBalance);
                sortedAccounts.put(newBalance, accountNumber); // Add new balance
                System.out.println("Withdrawal of " + amount + " from account " + accountNumber + " successful.");
            } else {
                System.out.println("Insufficient funds for account: " + accountNumber);
            }
        }
    }

    // Display all accounts sorted by balance
    public void displayAccountsSortedByBalance() {
        System.out.println("Accounts sorted by balance:");
        for (Map.Entry<Double, Integer> entry : sortedAccounts.entrySet()) {
            System.out.println("Account: " + entry.getValue() + " | Balance: " + entry.getKey());
        }
    }
    // Get account balance for testing
    public double getBalance(int accountNumber) {
        return accountBalances.getOrDefault(accountNumber, 0.0);
    }

    // Get sorted accounts map for testing
    public Map<Double, Integer> getSortedAccounts() {
        return sortedAccounts;
    }

}


