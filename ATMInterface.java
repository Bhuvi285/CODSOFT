// TASK 3 :- ATM INTERFACE 
import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount 
{
    private double balance;       //By keeping private ,restricting the  direct access to it from outside the class.

    public BankAccount(double initialBalance) 
    {
        this.balance = initialBalance;
    }

    public double getBalance() 
    {
        return balance;
    }

    public void deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;              // adding incase of deposit 
            System.out.println("Deposit successful! Your new balance is: " + balance);
        }
         else 
         {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) 
        {
            balance -= amount;            // subtracting incase of withdrawl
            System.out.println("Withdrawal successful! Your new balance is: " + balance);
        }
         else if (amount > balance) 
         {
            System.out.println("Insufficient balance for withdrawal.");
        } 
        else
         {
            System.out.println("Invalid withdrawal amount.");
        }
    }
    public void checkBalance() 
    {
        System.out.println("Your current balance is: " + balance);
    }
}
// Class to represent the ATM machine
class ATM 
{
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) 
        {
            System.out.println("Welcome to the ATM!");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) 
            {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
public class ATMInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);  // Initial balance set to 1000 for demonstration
        ATM atm = new ATM(account);
        atm.start();
    }
}
