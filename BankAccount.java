
public class BankAccount {

    // Encapsulation: private variables
    private String accountHolderName;
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountHolderName,
                       String accountNumber,
                       double initialBalance) {

        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Getter methods
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
            return;
        }

        balance += amount;

        System.out.println("Amount deposited successfully!");
        System.out.println("Deposited Amount: Rs." + amount);
    }

    // Withdraw method
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return;
        }

        balance -= amount;

        System.out.println("Withdrawal successful!");
        System.out.println("Withdrawn Amount: Rs." + amount);
    }

    // Check balance
    public void checkBalance() {

        System.out.println("Available Balance: Rs." + balance);
    }

    // Polymorphism: method to override
    public String getAccountType() {
        return "General Bank Account";
    }

    // Display account details
    public void displayAccountDetails() {

        System.out.println("\n----- ACCOUNT DETAILS -----");
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + getAccountType());
        System.out.println("Balance: Rs." + balance);

        System.out.println("---------------------------");
    }
}
