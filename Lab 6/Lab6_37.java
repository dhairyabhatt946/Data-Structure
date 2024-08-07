import java.util.Scanner;

class BankAccount {
    final int account_Number;
    private double balance;
    private String name;

    public BankAccount(int account_Number, double balance, String name) {
        this.account_Number = account_Number;
        this.balance = balance;
        this.name = name;
    }
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited succesfully");
    }
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Amount withdrawn succesfully");
        }
        else {
            System.out.println("Insufficient balance");
        }
    }
    public void checkBalance() {
        System.out.println("Your balance is " + balance);
    }
}
public class Lab6_37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of persons: ");
        int n = sc.nextInt();
        BankAccount[] bankAccount = new BankAccount[n];
        for(int i=0; i<n; i++) {
            System.out.println("Enter details of person "+(i+1)+": ");
            System.out.println("Enter account number: ");
            int account_Number = sc.nextInt();
            System.out.println("Enter balance: ");
            double balance = sc.nextDouble();
            System.out.println("Enter name: ");
            String name = scanner.next();
            bankAccount[i] = new BankAccount(account_Number, balance, name);
        }
        System.out.println("Enter the account number of the person whose details you want to see: ");
        int account_Number = sc.nextInt();
        for(int i=0; i<n; i++) {
            if (bankAccount[i].account_Number == account_Number) {
                System.out.println("Enter 1 to deposit money, 2 to withdraw money, 3 to check balance: ");
                int choice = sc.nextInt();
                switch(choice) {
                    case 1:
                        System.out.println("Enter the amount you want to deposit: ");
                        double amount = sc.nextDouble();
                        bankAccount[i].deposit(amount);
                        break;

                    case 2:
                        System.out.println("Enter the amount you want to withdraw: ");
                        double amount2 = sc.nextDouble();
                        bankAccount[i].withdraw(amount2);
                        break;

                    case 3:
                        bankAccount[i].checkBalance();
                        break;

                    default: 
                        System.out.println("Invalid choice");
                        break;
                }
            }
        }
        sc.close();
        scanner.close();
    }
}
