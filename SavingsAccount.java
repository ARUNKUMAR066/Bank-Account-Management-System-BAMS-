
public class SavingsAccount extends BankAccount {

    private double minimumBalance;

    // Constructor
    public SavingsAccount(String name,
                          String accountNumber,
                          double initialBalance) {

        super(name, accountNumber, initialBalance);

        this.minimumBalance = 500;
    }

    // Method overriding: Runtime polymorphism
    @Override
    public String getAccountType() {

        return "Savings Account";
    }

    // Display minimum balance
    public void displayMinimumBalance() {

        System.out.println(
            "Minimum Balance: Rs." + minimumBalance
        );
    }
}
