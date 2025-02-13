package implement_banking_system;

class WithdrawalRequest {
    int accountNumber;
    double amount;

    public WithdrawalRequest(int accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
}

