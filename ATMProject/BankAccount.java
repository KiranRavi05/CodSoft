public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
            return;
        }
        balance += amount;
        System.out.printf("Amount deposited: Rs. %.2f%n", amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds for this transaction.");
        } else {
            balance -= amount;
            System.out.printf("Amount withdrawn: Rs. %.2f%n", amount);
        }
    }

    public void displayBalance() {
        System.out.printf("Current account balance: Rs. %.2f%n", balance);
    }
}
