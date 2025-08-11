import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountHolder, double initialDeposit) {
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with initial deposit: $" + initialDeposit);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: $" + amount);
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
        } else if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount);
            System.out.println("Withdrawal successful. New balance: $" + balance);
        }
    }

    public double getBalance() {
        return balance;
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History for " + accountHolder + ":");
        for (String transaction : transactionHistory) {
            System.out.println("- " + transaction);
        }
    }
}


class BankAccount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Welcome to World Bank ===");
        System.out.print("Enter account holder's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial deposit amount: $");
        double initialDeposit = scanner.nextDouble();

        Account myAccount = new Account(name, initialDeposit);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    myAccount.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    myAccount.withdraw(withdrawalAmount);
                    break;
                case 3:
                    System.out.println("Current Balance: $" + myAccount.getBalance());
                    break;
                case 4:
                    myAccount.printTransactionHistory();
                    break;
                case 5:
                    System.out.println("Exiting. Thank you for using the World Bank.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1-5.");
            }
        }

        scanner.close();
    }
}
