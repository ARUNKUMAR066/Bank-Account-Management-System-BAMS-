
import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountManagementSystem {

    static Scanner sc = new Scanner(System.in);

    // Store multiple bank accounts
    static ArrayList<BankAccount> accounts =
            new ArrayList<>();

    // Find account using account number
    public static BankAccount findAccount(String accNo) {

        for (BankAccount account : accounts) {

            if (account.getAccountNumber().equals(accNo)) {
                return account;
            }
        }

        return null;
    }

    // Read valid positive amount
    public static double readAmount(String message) {

        while (true) {

            System.out.print(message);

            try {

                double amount = Double.parseDouble(sc.nextLine());

                if (Double.isFinite(amount) && amount > 0) {
                    return amount;
                }

                System.out.println(
                    "Please enter an amount greater than zero."
                );

            } catch (NumberFormatException e) {

                System.out.println("Enter a valid number!");
            }
        }
    }

    // Create account
    public static void createAccount() {

        System.out.println("\n--- CREATE BANK ACCOUNT ---");

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine().trim();

        if (accNo.isEmpty()) {
            System.out.println("Account number cannot be empty!");
            return;
        }

        if (findAccount(accNo) != null) {
            System.out.println("Account already exists!");
            return;
        }

        System.out.print("Enter Initial Balance: ");

        double balance;

        try {

            balance = Double.parseDouble(sc.nextLine());

            if (!Double.isFinite(balance) || balance < 0) {
                System.out.println("Invalid initial balance!");
                return;
            }

        } catch (NumberFormatException e) {

            System.out.println("Please enter a valid balance!");
            return;
        }

        // Create child class object
        BankAccount account =
                new SavingsAccount(name, accNo, balance);

        accounts.add(account);

        System.out.println(
            "Bank account created successfully!"
        );
    }

    // Display account details
    public static void displayAccount() {

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine().trim();

        BankAccount account = findAccount(accNo);

        if (account != null) {

            account.displayAccountDetails();

        } else {

            System.out.println("Account not found!");
        }
    }

    // Deposit money
    public static void depositMoney() {

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine().trim();

        BankAccount account = findAccount(accNo);

        if (account != null) {

            double amount = readAmount(
                "Enter Deposit Amount: "
            );

            account.deposit(amount);

        } else {

            System.out.println("Account not found!");
        }
    }

    // Withdraw money
    public static void withdrawMoney() {

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine().trim();

        BankAccount account = findAccount(accNo);

        if (account != null) {

            double amount = readAmount(
                "Enter Withdrawal Amount: "
            );

            account.withdraw(amount);

        } else {

            System.out.println("Account not found!");
        }
    }

    // Check account balance
    public static void checkBalance() {

        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine().trim();

        BankAccount account = findAccount(accNo);

        if (account != null) {

            account.checkBalance();

        } else {

            System.out.println("Account not found!");
        }
    }

    // Main method
    public static void main(String[] args) {

        int choice = 0;

        do {

            System.out.println("\n================================");
            System.out.println(" BANK ACCOUNT MANAGEMENT SYSTEM ");
            System.out.println("================================");

            System.out.println("1. Create Bank Account");
            System.out.println("2. Display Account Details");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Check Account Balance");
            System.out.println("6. Exit");

            System.out.println("================================");

            System.out.print("Enter Your Choice: ");

            try {

                choice = Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid choice!");
                continue;
            }

            switch (choice) {

                case 1:
                    createAccount();
                    break;

                case 2:
                    displayAccount();
                    break;

                case 3:
                    depositMoney();
                    break;

                case 4:
                    withdrawMoney();
                    break;

                case 5:
                    checkBalance();
                    break;

                case 6:
                    System.out.println(
                        "Thank you for using our banking system!"
                    );
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while(choice != 6);

        sc.close();
    }
}
