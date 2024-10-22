import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: Rs." + amount);
        } 
        else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: Rs." + amount);
        } 
        else if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } 
        else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void showMenu() {
        int option = 0;
        while (option != 4) {
            System.out.println("\nATM Menu");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Current Balance: Rs." + account.checkBalance());
                    break;

                case 2:
                    handleDeposit();
                    break;

                case 3:
                    handleWithdrawal();
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Have a good day!");
                    break;

                default:
                    System.out.println("Invalid option. Please select again.");
            }
        }
    }

    private void handleDeposit() {
        System.out.print("Enter deposit amount: Rs.");
        double amount = sc.nextDouble();
        account.deposit(amount);
    }

    private void handleWithdrawal() {
        System.out.print("Enter withdrawal amount: Rs.");
        double amount = sc.nextDouble();
        account.withdraw(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00);
        ATM atm = new ATM(account);
        atm.showMenu();
    }
}
