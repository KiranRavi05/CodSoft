import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM {
    private final BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("=======================================");
        System.out.println("        Welcome to ATM Services        ");
        System.out.println("=======================================");

        do {
            displayMenu();
            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        handleWithdrawal(scanner);
                        break;
                    case 2:
                        handleDeposit(scanner);
                        break;
                    case 3:
                        account.displayBalance();
                        break;
                    case 4:
                        System.out.println("Thank you for using our services.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // Clear the invalid input
                choice = -1;
            }

        } while (choice != 4);

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\n------------- ATM Menu -------------");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.println("------------------------------------");
    }

    private void handleWithdrawal(Scanner scanner) {
        System.out.print("Enter amount to withdraw: Rs. ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    private void handleDeposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: Rs. ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(5000.00);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
